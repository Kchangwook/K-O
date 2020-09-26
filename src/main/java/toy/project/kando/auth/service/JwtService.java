package toy.project.kando.auth.service;

public interface JwtService {
	String createToken(String userId);
	String getUserIdFromToken(String tokenValue);
}
