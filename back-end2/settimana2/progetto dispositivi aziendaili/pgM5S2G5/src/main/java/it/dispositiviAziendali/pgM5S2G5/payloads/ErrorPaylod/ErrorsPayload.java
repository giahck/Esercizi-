package it.dispositiviAziendali.pgM5S2G5.payloads.ErrorPaylod;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

public record ErrorsPayload(
        String message,
        Date timestamp) {
    public ErrorsPayload(String message, Date timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
