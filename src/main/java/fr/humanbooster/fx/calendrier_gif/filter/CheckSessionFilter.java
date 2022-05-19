package fr.humanbooster.fx.calendrier_gif.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2) // Deuxième filtre à exécuter lorsque le serveur reçoit une requête HTTP
public class CheckSessionFilter implements Filter {
	
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (((HttpServletRequest)request).getRequestURI().startsWith("/calendrier") &&
                ((HttpServletRequest)request).getSession().getAttribute("utilisateur")==null) {
            System.out.println("Pas de session");
            ((HttpServletResponse) response).sendRedirect("/index");
        }
        else {
            chain.doFilter(request, response);
        }
    }

}
