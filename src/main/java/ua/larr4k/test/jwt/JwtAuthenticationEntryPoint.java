package ua.larr4k.test.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.BiConsumer;


@Component
public class JwtAuthenticationEntryPoint {

    private final BiConsumer<HttpServletRequest, HttpServletResponse> commenceHandler = (request, response) -> {
        try {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        } catch (IOException ignored) {

        }
    };

    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) {
        commenceHandler.accept(request, response);
    }
}
