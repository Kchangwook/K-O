package toy.project.kando.auth.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import toy.project.kando.auth.service.JwtService;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

@Service
public class JwtServiceImpl implements JwtService {
	private final Key key;

	public JwtServiceImpl(
		@Value("${auth.token.secretKey}") String secretKey) {
		this.key = new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS256.getJcaName());
	}

	@Override
	public String createToken(String userId) {
		Claims claims = Jwts.claims().setSubject(userId);

		return Jwts.builder()
			.setClaims(claims)
			.signWith(SignatureAlgorithm.HS256, key)
			.compact();
	}

	@Override
	public String getUserIdFromToken(String tokenValue) {
		System.out.println("token: " + tokenValue);

		Claims claims = Jwts.parser()
							.setSigningKey(key)
							.parseClaimsJws(tokenValue)
							.getBody();

		return claims.getSubject();
	}
}