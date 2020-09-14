package toy.project.kando.user.service;

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
}
