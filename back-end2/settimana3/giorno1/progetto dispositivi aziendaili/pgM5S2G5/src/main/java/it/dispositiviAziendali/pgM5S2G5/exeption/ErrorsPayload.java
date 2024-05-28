package it.dispositiviAziendali.pgM5S2G5.exeption;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class ErrorsPayload {
	private String message;
	private LocalDateTime timestamp;
}