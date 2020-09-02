package tech.dirickx.littlearithmetics.security;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        System.out.println("Login failed");
        System.out.println(exception);

        if (exception.getClass().equals(InternalAuthenticationServiceException.class)) {
            response.sendRedirect("/newUser");
        } else {
            request.setAttribute("wrongPassword", "Wrong password, please try again");
            request.getRequestDispatcher("/login").forward(request, response);
        }

    }

}
