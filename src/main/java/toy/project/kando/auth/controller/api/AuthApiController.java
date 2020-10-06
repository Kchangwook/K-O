package toy.project.kando.auth.controller.api;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toy.project.kando.auth.annotation.LoginUser;
import toy.project.kando.auth.service.JwtService;
import toy.project.kando.common.model.ErrorResponse;
import toy.project.kando.user.model.User;
import toy.project.kando.user.service.UserService;

@RestController
public class AuthApiController {
	private final JwtService jwtService;
	private final UserService userService;

	@Autowired
	public AuthApiController(JwtService jwtService, UserService userService) {
		this.jwtService = jwtService;
		this.userService = userService;
	}

	@PostMapping(value = "login", produces = "text/plain;charset=UTF-8")
	public String login(@RequestBody User user) {
		User loginUser = userService.login(user);

		if(loginUser == null) {
			throw new IllegalArgumentException();
		}

		return jwtService.createToken(loginUser.getUserId());
	}

	@GetMapping("check")
	public boolean loginCheck(@LoginUser User user) {
		System.out.println("user: " + user);
		return ObjectUtils.isNotEmpty(user);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> illegalArgument() {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
