package toy.project.kando.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import toy.project.kando.user.model.User;

@Mapper
public interface UserMapper {
	void insertUser(User user);
	User selectUserById(String userId);
}
