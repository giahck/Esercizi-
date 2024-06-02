package Eventi.progettoEventi.mapper;

import Eventi.progettoEventi.entity.User;
import Eventi.progettoEventi.payloads.UserDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-02T17:16:45+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setNome( userDto.getNome() );
        user.setCognome( userDto.getCognome() );
        user.setEmail( userDto.getEmail() );

        return user;
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setNome( user.getNome() );
        userDto.setCognome( user.getCognome() );
        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );

        return userDto;
    }
}
