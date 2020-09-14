package toy.project.kando.user.service.impl;

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
}
