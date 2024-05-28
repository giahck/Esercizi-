package it.dispositiviAziendali.pgM5S2G5.security;


import it.dispositiviAziendali.pgM5S2G5.model.Dipendente;
import it.dispositiviAziendali.pgM5S2G5.service.DipendenteService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import java.util.Optional;


@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTool jwtTool;


    @Autowired
    private DipendenteService dipendenteService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       //verifico se il token è presente
        String token = request.getHeader("Authorization");
        if (token == null||!token.startsWith("Bearer ")) {
            throw new RuntimeException("Token non presente");
        }else
        {
            //estraggo il token, rimuovendo la stringa "Bearer "
            token = token.substring(7);
            jwtTool.verifyToken(token);



            int userId = jwtTool.getIdFromToken(token);
            Optional<Dipendente>dipendenteOptional = Optional.ofNullable(dipendenteService.getDipendenteById(userId));
            if (dipendenteOptional.isPresent()) {
                Dipendente dipendente = dipendenteOptional.get();
                Authentication authentication = new UsernamePasswordAuthenticationToken(dipendente, null, dipendente.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);

            } else {
                throw new RuntimeException("Dipendente non trovato");
            }
                filterChain.doFilter(request, response);

            //se il token è valido passo la richiesta al prossimo filtro
            filterChain.doFilter(request, response);


        }
    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request)throws ServletException {
        return new AntPathMatcher().match("/auth/**",request.getServletPath());
    }
}
