package servlet.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Администратор on 05.12.2016.
 */

// для сервлетов, доступных только после авторизации
@WebFilter(servletNames = {"", ""})

public class LoginFilter implements Filter{
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        // Получаем путь до страницы типа /index.jsp или /login.jsp
        String uriPath = req.getRequestURI().substring(req.getContextPath().length());
        if (session == null || session.getAttribute("userLogin") == null){
            if ("/auth".equals(uriPath) || "/logout".equals(uriPath)){
                filterChain.doFilter(request, response);
            }
            resp.sendRedirect("/auth?destination=" + uriPath);
            return;
        }
        filterChain.doFilter(request, response);
    }
    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
