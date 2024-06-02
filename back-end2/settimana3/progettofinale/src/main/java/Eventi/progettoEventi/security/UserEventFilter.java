/*
package Eventi.progettoEventi.security;

import Eventi.progettoEventi.entity.User;
import Eventi.progettoEventi.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;
@Component
public class UserEventFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(request);

        if (token != null) {
            //estrago l'id dell'utente dal token
            String userId = jwtTool.getIdFromToken(token);
         //   System.out.println(request.getRequestURI()+" "+userId);

            String path = request.getRequestURI();
            //controllo se l'utente sta cercando di accedere a informazioni di un altro utente
            //controllo se il path inizia con /api/event/user/ e se l'id dell'utente è diverso da null
            if (path.startsWith("/api/event/user/") && userId != null) {
                String[] parts = path.split("/");
                if (parts.length >= 5) {
                    int requestedUserId = Integer.parseInt(parts[4]);
                    if (!userId.equals(String.valueOf(requestedUserId))) {
                        response.sendError(HttpServletResponse.SC_FORBIDDEN, "You are not allowed to access other users' information");
                        return;
                    }
                }
            }
        }

        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }
}*/
/*@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication != null && authentication.isAuthenticated()) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            String username = userDetails.getUsername();

            String path = request.getRequestURI();
            if (path.startsWith("/api/event/user/") && username != null) {
                String[] parts = path.split("/");
                if (parts.length >= 5) {
                    int requestedUserId = Integer.parseInt(parts[4]);
                    if (!username.equals(String.valueOf(requestedUserId))) {
                        response.sendError(HttpServletResponse.SC_FORBIDDEN, "You are not allowed to access other users' information");
                        return;
                    }
                }
            }
        }
    }

    filterChain.doFilter(request, response);
}*/
