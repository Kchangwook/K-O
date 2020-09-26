package toy.project.kando.user.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import toy.project.kando.common.config.WebConfig;
import toy.project.kando.user.model.User;
import toy.project.kando.user.service.UserService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
@TestPropertySource("classpath:/properties/auth.properties")
public class UserApiControllerTest {
	@Mock
	private UserService userService;
	@InjectMocks
	private UserApiController userApiController;
	private MockMvc mockMvc;
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(userApiController).build();
		objectMapper = new ObjectMapper();
	}

	@Test
	@DisplayName("회원 가입 API 테스트")
	public void joinTest() throws Exception {
		//when
		User user = createUser();
		//given
		mockMvc.perform(post("/user").contentType("application/json")
												.content(objectMapper.writeValueAsString(user)))
			.andExpect(status().is2xxSuccessful());

		//then
		verify(userService, times(1)).addUser(user);
	}

	private User createUser() {
		return User.builder()
			.userId("id")
			.userName("name")
			.userEmail("email@email.com")
			.userNick("nick")
			.userPassword("password")
			.userType("type").build();
	}

	private MultiValueMap<String, String> convertToMultiValueMap(Object object)
		throws InvocationTargetException, IllegalAccessException {
		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();

		for (Method method : object.getClass().getMethods()) {
			if (StringUtils.startsWith(method.getName(), "get")) {
				Object result = method.invoke(object);
				String name = StringUtils.substring(method.getName(), 3).toLowerCase();

				if(ObjectUtils.isEmpty(result)) {
					multiValueMap.add(name, "");
				} else {
					multiValueMap.add(name, String.valueOf(result));
				}
			}
		}

		return multiValueMap;
	}

	@Test
	@DisplayName("회원 ID 중복 체크 테스트 - ID가 존재하지 않을 때")
	public void checkUserIdDuplicatedTestWithNullObject() throws Exception {
		//when
		String id = "id";
		when(userService.getUserById(id)).thenReturn(null);

		//given
		mockMvc.perform(get("/user/check/id"))
			.andExpect(status().isOk())
			.andExpect(content().string("false"));

		//then
		verify(userService, times(1)).getUserById(id);
	}

	@Test
	@DisplayName("회원 ID 중복 체크 테스트")
	public void checkUserIdDuplicatedTest() throws Exception {
		//when
		String id = "id";
		User user = mock(User.class);
		when(userService.getUserById(id)).thenReturn(user);

		//given
		mockMvc.perform(get("/user/check/id"))
			.andExpect(status().isOk())
			.andExpect(content().string("true"));

		//then
		verify(userService, times(1)).getUserById(id);
	}
}
