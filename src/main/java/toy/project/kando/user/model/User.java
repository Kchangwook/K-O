package toy.project.kando.user.model;

import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("user")
@Data
@NoArgsConstructor
public class User {
	private String userId;
	private String userEmail;
	private String userName;
	private String userNick;
	private String userPassword;
	private String userType;

	@Builder
	public User(String userId, String userEmail, String userName, String userNick, String userPassword,
		String userType) {
		this.userId = userId;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userNick = userNick;
		this.userPassword = userPassword;
		this.userType = userType;
	}
}
