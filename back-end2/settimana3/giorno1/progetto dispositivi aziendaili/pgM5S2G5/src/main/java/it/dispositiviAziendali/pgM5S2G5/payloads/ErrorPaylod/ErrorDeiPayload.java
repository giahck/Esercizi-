package it.dispositiviAziendali.pgM5S2G5.payloads.ErrorPaylod;

import java.util.Date;
import java.util.List;

public record ErrorDeiPayload(
        String message,
        Date timestamp,
        List<String> errorsList
) {
}
