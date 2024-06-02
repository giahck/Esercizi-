package Eventi.progettoEventi.controller;

import Eventi.progettoEventi.payloads.UserDto;
import Eventi.progettoEventi.payloads.UserLoginDto;
import Eventi.progettoEventi.service.AuthService;
import Eventi.progettoEventi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public UserDto registerDipendente(@RequestBody @Validated UserDto userDto, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException("Richiesta non valida: " + bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("", (s1, s2) -> s1 + "\n" + s2));
        }
        return userService.saveUser(userDto);
    }
    @PostMapping("/login")
    public String loginDipendente(@RequestBody @Validated UserLoginDto userLoginDto, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException("Richiesta non valida: " + bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("", (s1, s2) -> s1 + "\n" + s2));
        }
        return authService.authenticateUserEGeneraToken(userLoginDto);
    }
}
