package toy.project.kando.user.controller.api;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import toy.project.kando.auth.annotation.LoginUser;
import toy.project.kando.common.model.ErrorResponse;
import toy.project.kando.user.model.User;
import toy.project.kando.user.service.UserService;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("user")
public class UserApiController {
	private final UserService userService;

	@Autowired
	public UserApiController(UserService userService) {
		this.userService = userService;
	}

	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<ErrorResponse> methodArgumentNotValid(MethodArgumentNotValidException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
		errorResponse.setMessage(Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
		return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void join(@RequestBody @Valid User user) {
		userService.addUser(user);
	}

	@GetMapping("check/{userId}")
	public boolean checkUserIdDuplicated(@PathVariable String userId) {
		return ObjectUtils.isNotEmpty(userService.getUserById(userId));
	}

	@GetMapping("mydata")
	public User getLoginUserData(@LoginUser User user) {
		return user;
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void modifyUser(@RequestBody @Valid User user) {
		userService.modifyUser(user);
	}
}
