package Eventi.progettoEventi.payloads;

import Eventi.progettoEventi.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventDto {
@NotBlank(message = "Il titolo non può essere vuoto o mancante o composto da soli spazi")
    private String titolo;
    @NotBlank(message = "La descrizione non può essere vuota o mancante o composta da soli spazi")
    private String descrizione;
    @Future(message = "La data deve essere nel futuro")
    @NotNull(message = "La data non può essere nulla")
    private LocalDateTime data;
    @NotBlank(message = "Il luogo non può essere vuoto o mancante o composto da soli spazi")
    private String luogo;
    @NotNull(message = "Il numero di posti non può essere nullo")
    private int postiDisponibili;
    //@NotNull(message = "L'utente non può essere nullo")
    private List<Integer> userId;
}