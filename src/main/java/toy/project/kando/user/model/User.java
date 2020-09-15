package toy.project.kando.user.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("user")
@Data
@NoArgsConstructor
public class User {

	@NotNull(message = "{user.id.notnull}")
	@Length(min = 1, max = 20, message = "{user.id.length}")
	private String userId;

	@NotNull(message = "{user.email.notnull}")
	@Email(message = "{user.email.email}")
	@Length(min = 5, max = 20, message = "{user.email.length}")
	private String userEmail;

	@NotNull(message = "{user.name.notnull}")
	@Length(min = 1, max = 10, message = "{user.name.length}")
	private String userName;

	@NotNull(message = "{user.nick.notnull}")
	@Length(min = 1, max = 10, message = "{user.nick.length}")
	private String userNick;

	@NotNull(message = "{user.password.notnull}")
	@Length(min = 1, max = 20, message = "{user.password.length}")
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
