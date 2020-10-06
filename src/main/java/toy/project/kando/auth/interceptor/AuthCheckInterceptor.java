package toy.project.kando.auth.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import toy.project.kando.auth.service.JwtService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

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

		if(StringUtils.isNotEmpty(tokenValue)) {
			request.setAttribute("userId", jwtService.getUserIdFromToken(tokenValue));
		}

		return true;
	}

	private String getTokenValue(Cookie[] cookies) {
		if(cookies == null) {
			return "";
		}

		return Arrays.stream(cookies)
			.filter(c -> StringUtils.equals(c.getName(), "token"))
			.findFirst()
			.map(Cookie::getValue)
			.orElse("");
	}
}
