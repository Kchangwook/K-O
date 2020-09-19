package toy.project.kando.auth.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> illegalArgument() {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
