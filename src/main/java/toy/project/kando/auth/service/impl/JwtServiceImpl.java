package toy.project.kando.auth.service.impl;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import toy.project.kando.auth.model.Auth;
import toy.project.kando.auth.service.JwtService;

@Service
public class JwtServiceImpl implements JwtService {
	private static final String OFFSET_TIME = "+09:00";
	private final long validationTime;
	private final Key key;

	public JwtServiceImpl(
		@Value("${auth.token.secretKey}") String secretKey,
		@Value("${auth.token.validationTime}") long validationTime) {
		this.validationTime = validationTime;
		this.key = new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS256.getJcaName());
	}

	@Override
	public String createToken(String userId) {
		Claims claims = Jwts.claims().setSubject(userId);
		LocalDateTime expireTime = LocalDateTime.now().plusMinutes(validationTime);

		return Jwts.builder()
			.setClaims(claims)
			.setExpiration(Date.from(expireTime.toInstant(ZoneOffset.of(OFFSET_TIME))))
			.signWith(SignatureAlgorithm.HS256, key)
			.compact();
	}

	@Override
	public Auth getAuth(String tokenValue) {
		Claims claims = Jwts.parser()
							.setSigningKey(key)
							.parseClaimsJws(tokenValue)
							.getBody();

		LocalDateTime expiration = LocalDateTime.ofInstant(claims.getExpiration().toInstant(), ZoneOffset.of(OFFSET_TIME));
		String userId = claims.getSubject();
		return Auth.builder()
			.userId(userId)
			.expiration(expiration)
			.build();
	}
}