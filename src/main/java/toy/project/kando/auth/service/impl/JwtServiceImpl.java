package toy.project.kando.auth.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import toy.project.kando.auth.service.JwtService;

@Service
public class JwtServiceImpl implements JwtService {
	private static final String OFFSET_TIME = "+09:00";
	private final String secretKey;
	private final long validationTime;

	public JwtServiceImpl(
		@Value("${auth.token.secretKey}") String secretKey,
		@Value("${auth.token.validationTime}") long validationTime) {
		this.secretKey = secretKey;
		this.validationTime = validationTime;
	}

	@Override
	public String createToken(String userId) {
		Claims claims = Jwts.claims().setSubject(userId);
		LocalDateTime expireTime = LocalDateTime.now().plusMinutes(validationTime);

		return Jwts.builder()
			.setClaims(claims)
			.setExpiration(Date.from(expireTime.toInstant(ZoneOffset.of(OFFSET_TIME))))
			.signWith(SignatureAlgorithm.HS256, secretKey)
			.compact();
	}
}
