package Eventi.progettoEventi.payloads;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class UserEventDto {
    @NotNull(message = "L'ID dell'utente non può essere nullo")
    private Integer userId;

    @NotNull(message = "L'ID dell'evento non può essere nullo")
    private Integer eventId;
}