package Eventi.progettoEventi.service;

import Eventi.progettoEventi.entity.User;
import Eventi.progettoEventi.mapper.UserMapper;
import Eventi.progettoEventi.payloads.UserDto;
import Eventi.progettoEventi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    public UserDto saveUser(UserDto userdto) {
        //controllo se la mail esiste già
        if (checkUser(userdto.getEmail()).isPresent()) {
            throw new RuntimeException("Utente già registrato con email: "+userdto.getEmail());
        }
        User user = userMapper.toEntity(userdto, passwordEncoder);
        return userMapper.toDto(userRepository.save(user));
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Utente non trovato con id: "+id));
    }
    public Optional<User> checkUser(String email) {
        return userRepository.findByEmail(email);
    }



}
