package Eventi.progettoEventi.exeption;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorsPayload {
	private String message;
	private LocalDateTime timestamp;
}