package Eventi.progettoEventi.security;

import Eventi.progettoEventi.entity.User;
import Eventi.progettoEventi.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTool jwtTools;
    @Autowired
    @Lazy
    private UserService usersService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
       String authHeader = request.getHeader("Authorization"); // Authorization Header --> Bearer eyJhbGciOiJIUzM4NCJ9.eyJpYXQiOjE3MTMxNzY3NDUsImV4cCI6MTcxMzc4MTU0NSwic3ViIjoiZDFlZTlmN2MtZWQwZS00ZTQ3LThmN2EtYTQ0Yzk5MTNkMzE0In0.HFk14O-60faQY4TEnvsNgqjQdOVy7aD-1L-jCvayGz2VTRIQQqGDRzx1qSx5WWxy

        if(authHeader == null || !authHeader.startsWith("Bearer ")) throw new RuntimeException("Per favore inserisci il token nell'Authorization Header");
        String accessToken = authHeader.substring(7);

        jwtTools.verifyToken(accessToken);

        String id = jwtTools.getIdFromToken(accessToken);
        Optional<User>optionalUser= Optional.ofNullable(this.usersService.getUserById(Integer.parseInt(id)));
        if(optionalUser.isPresent()){
            User currentUser = optionalUser.get();
            Authentication authentication = new UsernamePasswordAuthenticationToken(currentUser, null, currentUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }else{
            throw new RuntimeException("Utente non trovato");
        }
        filterChain.doFilter(request, response);
    }

    // Sovrascrivendo il seguente metodo disabilito il filtro per determinate richieste tipo Login o Register (esse ovviamente non devono richiedere un token!)
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){
        // Uso questo metodo per specificare in che situazioni NON FILTRARE
        // Se l'URL della richiesta corrente corrisponde a /auth/qualsiasicosa allora non entrare in azione
        return new AntPathMatcher().match("/auth/**", request.getServletPath());
    }


}