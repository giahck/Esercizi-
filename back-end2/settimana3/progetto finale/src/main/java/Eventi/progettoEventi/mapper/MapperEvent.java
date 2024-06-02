package Eventi.progettoEventi.mapper;

import Eventi.progettoEventi.entity.Event;
import Eventi.progettoEventi.entity.User;
import Eventi.progettoEventi.payloads.EventDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface MapperEvent {
    MapperEvent INSTANCE = Mappers.getMapper(MapperEvent.class);

    @Mapping(target = "utenti", source = "userId")
    Event toEvent(EventDto eventDto);
    @Mapping(target = "id", ignore = true) // Ensure the ID is not overwritten
    void updateEventFromDto(EventDto eventDto, @MappingTarget Event event);

    default List<User> mapUserIdsToUsers(List<Integer> userIds) {
        // Se la lista degli ID degli utenti è null o vuota, restituisci una lista vuota
        if (userIds == null || userIds.isEmpty()) {
            return List.of();
        }

        return userIds.stream()
                .map(userId -> {
                    User user = new User();
                    user.setId(userId);
                    return user;
                })
                .collect(Collectors.toList());
    }
}