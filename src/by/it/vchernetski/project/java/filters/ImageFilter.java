package by.it.vchernetski.project.java.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class ImageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String[] dirs = request.getRequestURI().split("/");
        String name = dirs[dirs.length-1];
        String realname = request.getServletContext().getRealPath("/image/" + name);
        if(new File(realname).exists()) {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
