package toy.project.kando.auth.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Auth {
	private String userId;
	private LocalDateTime expiration;

	@Builder
	public Auth(String userId, LocalDateTime expiration) {
		this.userId = userId;
		this.expiration = expiration;
	}

	public boolean isNotExpired() {
		return expiration.isAfter(LocalDateTime.now())
			&& expiration.isEqual(LocalDateTime.now());
	}
}
