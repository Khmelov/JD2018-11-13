package by.it.akhmelev.project06.java.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class FilterEncoding implements Filter {

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
