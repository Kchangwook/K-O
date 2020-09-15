package toy.project.kando.common.model;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {
	private HttpStatus httpStatus;
	private String message;
}
