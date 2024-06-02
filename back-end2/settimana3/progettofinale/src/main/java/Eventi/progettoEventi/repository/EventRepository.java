package Eventi.progettoEventi.repository;

import Eventi.progettoEventi.entity.Event;
import Eventi.progettoEventi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("SELECT COUNT(u) FROM Event e JOIN e.utenti u WHERE e.id = :eventId")
    int countUsersByEvent(@Param("eventId") int eventId);
    List<Event> findByUtenti(User user);
}
