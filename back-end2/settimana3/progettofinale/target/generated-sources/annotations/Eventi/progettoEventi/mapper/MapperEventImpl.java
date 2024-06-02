package Eventi.progettoEventi.mapper;

import Eventi.progettoEventi.entity.Event;
import Eventi.progettoEventi.payloads.EventDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-02T17:16:45+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class MapperEventImpl implements MapperEvent {

    @Override
    public Event toEvent(EventDto eventDto) {
        if ( eventDto == null ) {
            return null;
        }

        Event event = new Event();

        event.setUtenti( mapUserIdsToUsers( eventDto.getUserId() ) );
        event.setTitolo( eventDto.getTitolo() );
        event.setDescrizione( eventDto.getDescrizione() );
        event.setData( eventDto.getData() );
        event.setLuogo( eventDto.getLuogo() );
        event.setPostiDisponibili( eventDto.getPostiDisponibili() );

        return event;
    }

    @Override
    public void updateEventFromDto(EventDto eventDto, Event event) {
        if ( eventDto == null ) {
            return;
        }

        event.setTitolo( eventDto.getTitolo() );
        event.setDescrizione( eventDto.getDescrizione() );
        event.setData( eventDto.getData() );
        event.setLuogo( eventDto.getLuogo() );
        event.setPostiDisponibili( eventDto.getPostiDisponibili() );
    }
}
