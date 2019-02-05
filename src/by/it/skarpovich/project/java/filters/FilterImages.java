package by.it.skarpovich.project.java.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class FilterImages implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String[] part = req.getRequestURI().split("/");
        String fn = part[part.length - 1];
        String real = req.getServletContext().getRealPath("/image/" + fn);
        if (real.equals("noimage.png") || new File(real).exists()) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else req.getRequestDispatcher("/image/noimage.png").forward(req, resp);


    }

    @Override
    public void destroy() {

    }
}
