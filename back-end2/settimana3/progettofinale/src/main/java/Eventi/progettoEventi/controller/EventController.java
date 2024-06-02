package Eventi.progettoEventi.controller;

import Eventi.progettoEventi.entity.Event;
import Eventi.progettoEventi.exeption.BadRequestException;
import Eventi.progettoEventi.payloads.EventDto;
import Eventi.progettoEventi.payloads.UserDto;
import Eventi.progettoEventi.payloads.UserEventDto;
import Eventi.progettoEventi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    private EventService eventService;
    //creo un evento solo se sono un organizzatore
   @PostMapping("")
   @PreAuthorize("hasAuthority('ORGANIZZATORE')")//solo gli organizzatori possono creare eventi
    public ResponseEntity<String> saveEvent(@RequestBody @Validated EventDto eventDto, BindingResult validation) {
      if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).
                    reduce("", (s, s2) -> s+s2));
        }
       String result = eventService.saveEvent(eventDto);
       return ResponseEntity.ok(result);
    }
    //recupero tutti gli eventi
    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('ORGANIZZATORE')")//SIA ORGANIZZATORI CHE UTENTI POSSONO VEDERE GLI EVENTI
    public List<Event> getEvents() {
        return eventService.getEvents();
    }
    //recupero tutti gli eventi di un user data la mail/user puo vedere solo i suoi eventi
    @GetMapping("/user/{id}")
    @PreAuthorize("(hasAuthority('ORGANIZZATORE')) or (hasAuthority('USER') and #id == authentication.principal.id)")
    public List<Event> getEventsByUser(@PathVariable int id) {
        return eventService.getEventsByUser(id);
    }
    //modifico un evento solo se sono un organizzatore
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")//SOLO GLI ORGANIZZATORI POSSONO MODIFICARE GLI EVENTI
    public String updateEvent(@PathVariable int id, @RequestBody @Validated EventDto eventDto, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).
                    reduce("", (s, s2) -> s+s2));
        }
        String result = eventService.updateEvent(id, eventDto);
        return result;
    }

    //assegno un evento a un utente solo se sono un organizzatore o se sono l'utente stesso
    @PostMapping("/assign")
    @PreAuthorize("(hasAuthority('ORGANIZZATORE')) or (hasAuthority('USER') and #userEventDto.userId == authentication.principal.id)")    public ResponseEntity<String> assignEvent(@RequestBody @Validated UserEventDto userEventDto, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).
                    reduce("", (s, s2) -> s+s2));
        }
        String result = eventService.assignEvent(userEventDto);
        return ResponseEntity.ok(result);
    }
    //elimino un evento solo se sono un organizzatore
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")//SOLO GLI ORGANIZZATORI POSSONO ELIMINARE GLI EVENTI
    public String deleteEvent(@PathVariable int id) {
        return eventService.deleteEvent(id);
    }
    //elimino la relazione tra un evento e un utente solo se sono un organizzatore
    @DeleteMapping("/user/assign/{userId}/{eventId}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")//SOLO GLI ORGANIZZATORI POSSONO ELIMINARE LA RELAZIONE TRA UN EVENTO E UN UTENTE
    public String deleteEventUser(@PathVariable int userId, @PathVariable int eventId) {
        UserEventDto userEventDto = new UserEventDto(userId, eventId);
        return eventService.deleteEventUser(userEventDto);
    }
}
