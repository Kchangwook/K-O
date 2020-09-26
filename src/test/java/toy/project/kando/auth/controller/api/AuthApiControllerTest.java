package toy.project.kando.auth.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import toy.project.kando.auth.service.JwtService;
import toy.project.kando.common.config.WebConfig;
import toy.project.kando.user.model.User;
import toy.project.kando.user.service.UserService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class AuthApiControllerTest {
	@Mock
	private JwtService jwtService;

	@Mock
	private UserService userService;

	@InjectMocks
	private AuthApiController authApiController;
	private MockMvc mockMvc;
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(authApiController).build();
	}

	@Test
	@DisplayName("로그인 테스트 - ID 혹은 비밀번호가 틀린 경우")
	public void loginTestWithoutData() throws Exception {
		//when
		User user = createUser();
		when(userService.login(any(User.class))).thenReturn(null);

		//given
		mockMvc.perform(post("/login").contentType("application/json")
			.content(objectMapper.writeValueAsString(user)))
			.andExpect(status().is4xxClientError());

		//then
		verify(jwtService, times(0)).createToken("id");
		verify(userService, times(1)).login(any(User.class));
	}

	@Test
	@DisplayName("로그인 테스트 - 성공한 경우")
	public void loginTest() throws Exception {
		//when
		User user = createUser();
		when(userService.login(any(User.class))).thenReturn(user);
		when(jwtService.createToken(anyString())).thenReturn("token");

		//given
		mockMvc.perform(post("/login").contentType("application/json")
												 .content(objectMapper.writeValueAsString(user)))
			.andExpect(status().isOk())
			.andExpect(content().string("token"));

		//then
		verify(jwtService, times(1)).createToken(anyString());
		verify(userService, times(1)).login(any(User.class));
	}

	private User createUser() {
		return User.builder()
			.userId("id")
			.userPassword("password")
			.build();
	}
}
