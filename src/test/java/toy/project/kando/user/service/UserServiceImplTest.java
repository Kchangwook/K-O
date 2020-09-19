package toy.project.kando.user.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import toy.project.kando.user.mapper.UserMapper;
import toy.project.kando.user.model.User;
import toy.project.kando.user.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	@Mock
	private UserMapper userMapper;
	@InjectMocks
	private UserServiceImpl userService;

	@Test
	@DisplayName("회원 데이터 삽입 테스트")
	public void addUserTest() {
		//when
		User user = mock(User.class);

		//given
		userService.addUser(user);

		//then
		verify(userMapper, times(1)).insertUser(user);
	}

	@Test
	@DisplayName("로그인 테스트 - 아이디에 해당하는 데이터가 없는 경우")
	public void loginTestWithoutData() {
		//when
		User requestUser = mock(User.class);
		when(requestUser.getUserId()).thenReturn("id");
		when(userMapper.selectUserById(requestUser.getUserId())).thenReturn(null);

		//given
		User user = userService.login(requestUser);

		//then
		assertNull(user);
		verify(userMapper, times(1)).selectUserById(requestUser.getUserId());
	}

	@Test
	@DisplayName("로그인 테스트 - 비밀번호가 일치하지 않는 경우")
	public void loginTestNotEqualPassword() {
		//when
		User requestUser = User.builder().userId("id").userPassword("password").build();
		User selectedUser = User.builder().userId("id").userPassword("pwd").build();
		when(userMapper.selectUserById(requestUser.getUserId())).thenReturn(selectedUser);

		//given
		User user = userService.login(requestUser);

		//then
		assertNull(user);
		verify(userMapper, times(1)).selectUserById(requestUser.getUserId());
	}

	@Test
	@DisplayName("로그인 테스트 - 아이디 비밀번호가 일치하는 경우")
	public void loginTest() {
		//when
		User requestUser = mock(User.class);
		User selectedUser = mock(User.class);
		when(requestUser.getUserId()).thenReturn("id");
		when(userMapper.selectUserById(anyString())).thenReturn(selectedUser);

		//given
		User user = userService.login(requestUser);

		//then
		assertEquals(user, selectedUser);
		verify(userMapper, times(1)).selectUserById(requestUser.getUserId());
	}

	@Test
	@DisplayName("회원 아이디로 정보 가져오기 테스트")
	public void getUserByIdTest() {
		//when
		String id = "id";
		User user = mock(User.class);
		when(userMapper.selectUserById(id)).thenReturn(user);

		//given
		User selectedUser = userService.getUserById("id");

		//then
		assertSame(user, selectedUser);
	}
}
