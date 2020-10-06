package toy.project.kando.user.service.impl;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toy.project.kando.user.mapper.UserMapper;
import toy.project.kando.user.model.User;
import toy.project.kando.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public void addUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public User login(User user) {
		User selectedUser = userMapper.selectUserById(user.getUserId());

		if (ObjectUtils.isNotEmpty(selectedUser)
			&& StringUtils.equals(user.getUserPassword(), selectedUser.getUserPassword())) {
			return selectedUser;
		}

		return null;
	}

	@Override
	public User getUserById(String userId) {
		return userMapper.selectUserById(userId);
	}

	@Override
	public void modifyUser(User user) {
		userMapper.updateUser(user);
	}
}
