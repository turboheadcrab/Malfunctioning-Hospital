package servlet.filters;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Администратор on 09.12.2016.
 */
public class LoggingFilter implements Filter{
    private FilterConfig filterConfig;
    private Logger log;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        PropertyConfigurator.configure(filterConfig.getServletContext().getRealPath(
                "/")
                + "main/resources/log4j.properties");
        log = Logger.getLogger(LoggingFilter.class);
        log.info("Logger instantiated in " + getClass().getName());

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req =  (HttpServletRequest) request;
        String address =  req.getRemoteHost();
        String file = req.getRequestURI();

        log.info(
                " User IP: " + address +
                " Resource: " + file + " for " + file
        );
        filterChain.doFilter(request, response);
    }
    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
