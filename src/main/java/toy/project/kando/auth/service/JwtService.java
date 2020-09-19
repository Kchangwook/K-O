package toy.project.kando.auth.service;

import toy.project.kando.auth.model.Auth;

public interface JwtService {
	String createToken(String userId);
	Auth getAuth(String tokenValue);
}
