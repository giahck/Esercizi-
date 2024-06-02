package Eventi.progettoEventi.service;

import Eventi.progettoEventi.entity.User;
import Eventi.progettoEventi.payloads.UserLoginDto;
import Eventi.progettoEventi.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthService {
    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateUserEGeneraToken(UserLoginDto loginDto) {
        Optional<User> optionalUser = userService.checkUser(loginDto.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
                return jwtTool.createToken(user);
            } else {
                throw new RuntimeException("Password errata");
            }
        } else {
            throw new RuntimeException("Utente non trovato");
        }
    }
}
