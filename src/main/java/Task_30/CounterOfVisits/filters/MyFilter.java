package Task_30.CounterOfVisits.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/counter")
public class MyFilter implements Filter {

    public int counter;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        counter = 0;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        counter++;
        System.out.println("Counter of website visits: " + counter);
        servletRequest.setAttribute("CounterValue", counter);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}