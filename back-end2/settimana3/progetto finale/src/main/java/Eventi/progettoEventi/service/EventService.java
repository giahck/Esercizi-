package Eventi.progettoEventi.service;

import Eventi.progettoEventi.entity.Event;
import Eventi.progettoEventi.entity.User;
import Eventi.progettoEventi.mapper.MapperEvent;
import Eventi.progettoEventi.payloads.EventDto;
import Eventi.progettoEventi.payloads.UserEventDto;
import Eventi.progettoEventi.repository.EventRepository;
import Eventi.progettoEventi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private MapperEvent mapperEvent;
    @Autowired
    private UserRepository userRepository;

    //imposoto il role nel mapping di defoult su USER
    public String saveEvent(EventDto eventDto) {
        if (eventDto == null) {
            throw new IllegalArgumentException("EventDto cannot be null");
        }
        // Verifica se userId è presente nell'EventDto
        // List<Integer> userIds = eventDto.getUserId() != null ? eventDto.getUserId() : Collections.emptyList();

        Event event = mapperEvent.toEvent(eventDto);
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
        eventRepository.save(event);
        System.out.println(event.toString());

        return "Event with id=" + event.getId() + " correctly saved";
    }

    //tutti gli eventi
    public List<Event> getEvents() {
        List<Event> events = eventRepository.findAll();
        if (events == null || events.isEmpty()) {
            throw new RuntimeException("No events found");
        }
        return events;
    }

    //eventi di un utente
        public List<Event> getEventsByUser(int id) {
            User user = userRepository.findById(id).orElse(null);
            if (user == null) {
                throw new IllegalArgumentException("User not found");
            }
            return eventRepository.findByUtenti(user);
        }
    public Event getEventById(int id) {
        return eventRepository.findById(id).orElse(null);
    }
    //elimino un evento
    public String deleteEvent(int id) {
        eventRepository.deleteById(id);
        return "Event with id=" + id + " correctly deleted";
    }
    //modifico un evento
    public String updateEvent(int id, EventDto eventDto) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event == null) {
            throw new IllegalArgumentException("Event not found");
        }
        mapperEvent.updateEventFromDto(eventDto, event);
        eventRepository.save(event);
        return "Event with id=" + event.getId() + " correctly updated \n"+event.toString();
    }
//assegno un evento a un utente
    public String assignEvent(UserEventDto userEventDto) {
        if (userEventDto == null) {
            throw new IllegalArgumentException("UserEventDto cannot be null");
        }
        //cerco l'evento e l'utente
        Event event = eventRepository.findById(userEventDto.getEventId()).orElse(null);
        //numero di utenti collegati all'evento
        // System.out.println(event.toString()+"\n"+event.getUtenti().toString());
        // System.out.println(event.getUtenti().size());

        // faccio un controllo degli utenti in modo che non modifico levento per ogni utente
        if (event.getUtenti().size() > event.getPostiDisponibili()) {
            throw new RuntimeException("Event with id=" + event.getId() + " is full");
        }
        User user = userRepository.findById(userEventDto.getUserId()).orElse(null);
        if (event == null && user == null) {
            throw new IllegalArgumentException("Event/User not found");
        }
        //controllo se gia é stato assegnato se si ritorno un messaggio di errore
        if (event.getUtenti().contains(user)) {
            throw new RuntimeException("Event with id=" + event.getId() + " already assigned to user with id=" + user.getId());
        }
        //assegno l'evento all'utente
        event.getUtenti().add(user);
        eventRepository.save(event);
        return "Event with id=" + event.getId() + " correctly assigned to user with id=" + user.getId();
    }
    //elimino la relazione tra un evento e un utente
    public String deleteEventUser(UserEventDto userEventDto) {
        Event event = eventRepository.findById(userEventDto.getEventId()).orElse(null);
        if (event == null) {
            throw new IllegalArgumentException("Event not found");
        }
        User user = userRepository.findById(userEventDto.getUserId()).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        if (!event.getUtenti().contains(user)) {
            throw new RuntimeException("Event with id=" + event.getId() + " not assigned to user with id=" + user.getId());
        }
        event.getUtenti().remove(user);
        eventRepository.save(event);
        return "Event with id=" + event.getId() + " correctly unassigned to user with id=" + user.getId();
    }

}


