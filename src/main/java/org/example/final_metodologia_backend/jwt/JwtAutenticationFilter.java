package org.example.final_metodologia_backend.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.http.HttpHeaders;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;



@Component
@RequiredArgsConstructor
public class JwtAutenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        String method = request.getMethod();

       if (path.startsWith("/auth")) {
            filterChain.doFilter(request, response);
            return;
        }


        // Excluye los métodos GET en las rutas públicas
        if (method.equals("GET") && (
                path.startsWith("/productos")
                        || path.startsWith("/categorias")
                        || path.startsWith("/detalle")
                        || path.startsWith("/colores")
                        || path.startsWith("/talles")
                        || path.startsWith("/imagenes")
                        || path.startsWith("/precios")
                        || path.startsWith("/descuentos")
                        || path.startsWith("/localidades"))) {

            filterChain.doFilter(request, response);
            return;
        }

        final String token = getTokenFromRequest(request);
        final String email = jwtService.getUsernameFromToken(token);

        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }


        System.out.println(email);
        if(email!=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails=userDetailsService.loadUserByUsername(email);

            if(jwtService.isTokenValid(token, userDetails)){
                List<String> roles = jwtService.getClaim(token, claims -> claims.get("rol", List.class));
                List<GrantedAuthority> authorities = roles.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        authorities); //userDetails.getAuthorities())
                System.out.println(email);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);


            }
        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {

        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")){
            return authHeader.substring(7);
        }
        return null;
    }
}
