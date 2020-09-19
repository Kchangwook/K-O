package toy.project.kando.common.interceptor;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import toy.project.kando.auth.model.Auth;
import toy.project.kando.auth.service.JwtService;

@Component
public class AuthCheckInterceptor implements HandlerInterceptor {
	private final JwtService jwtService;

	@Autowired
	public AuthCheckInterceptor(JwtService jwtService) {
		this.jwtService = jwtService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String tokenValue = getTokenValue(request.getCookies());

		if(StringUtils.isEmpty(tokenValue)) {
			return true;
		}

		Auth auth = jwtService.getAuth(tokenValue);

		if(auth.isNotExpired()) {
			request.setAttribute("userId", auth.getUserId());
		}

		return true;
	}

	private String getTokenValue(Cookie[] cookies) {
		return Arrays.stream(cookies)
			.filter(cookie -> StringUtils.equals(cookie.getName(), "token"))
			.map(Cookie::getName)
			.findFirst()
			.orElse("");
	}
}
