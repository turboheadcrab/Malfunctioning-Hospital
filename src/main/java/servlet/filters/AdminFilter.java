package servlet.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Администратор on 10.12.2016.
 */
public class AdminFilter implements Filter{
    private FilterConfig filterConfig;
    private String reqURI = null;

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
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        String loginURI = req.getContextPath() + "/auth";
        if (reqURI != null){
            reqURI = null;
            resp.sendRedirect(reqURI);
        }else {
            reqURI = req.getRequestURI();
            boolean loginRequest = reqURI.equals(loginURI);
            if (loggedIn || loginRequest) {
                reqURI = null;
                filterChain.doFilter(request, response);
            } else {
                resp.sendRedirect("/auth");
            }
        }
    }
    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
