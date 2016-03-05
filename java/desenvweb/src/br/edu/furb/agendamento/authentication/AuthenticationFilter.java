package br.edu.furb.agendamento.authentication;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Filtro de autentica��o
 * 
 * 
 */

public class AuthenticationFilter implements Filter {

    public static final String AUTHENTICATE_USER = "AUTHENTICATE_USER";

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Obt�m a informa��o sobre a autentica��o.
        HttpSession session = httpRequest.getSession(true);
        String entity = (String) session.getAttribute(AUTHENTICATE_USER);
        // Caso o usu�rio j� tenha sido autenticado, continua normalmente.
        if (entity != null) {
            chain.doFilter(request, response);
            return;
        }
        httpResponse.sendRedirect("login.xhtml");
    }
}
