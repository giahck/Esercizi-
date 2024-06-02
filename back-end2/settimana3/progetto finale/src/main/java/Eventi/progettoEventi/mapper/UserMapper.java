package Eventi.progettoEventi.mapper;

import Eventi.progettoEventi.entity.User;
import Eventi.progettoEventi.enums.Role;
import Eventi.progettoEventi.payloads.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    default User toEntity(UserDto userDto, PasswordEncoder passwordEncoder) {

        User user = toEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(Role.USER);
        return user;
    }
}
