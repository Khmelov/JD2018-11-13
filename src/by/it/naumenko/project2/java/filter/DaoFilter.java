package by.it.naumenko.project2.java.filter;


import javax.servlet.*;
import java.io.IOException;

public class DaoFilter implements Filter {

    private String daofilter = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        daofilter = filterConfig.getInitParameter("daofilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (daofilter != null &&
                !daofilter.equalsIgnoreCase(servletRequest.getCharacterEncoding()))
            servletRequest.setCharacterEncoding(daofilter);

        if (daofilter != null &&
                !daofilter.equalsIgnoreCase(servletResponse.getCharacterEncoding()))
            servletResponse.setCharacterEncoding(daofilter);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
