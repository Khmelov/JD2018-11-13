package by.it.denisova.project.java.filters;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;

public  class FilterEncoding implements Filter {
    private String encode = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode = filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (encode != null &&
                !encode.equalsIgnoreCase(servletRequest.getCharacterEncoding()))
            servletRequest.setCharacterEncoding(encode);
        if (encode != null &&
                !encode.equalsIgnoreCase(servletResponse.getCharacterEncoding()))
            servletResponse.setCharacterEncoding(encode);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
