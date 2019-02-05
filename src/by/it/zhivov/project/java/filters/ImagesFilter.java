package by.it.zhivov.project.java.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class ImagesFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String[] part = req.getRequestURI().split("/");
        String fileName = part[part.length - 1];
        String real = req.getServletContext().getRealPath("/images/" + fileName);
        if (real.equals("noimage.png") || new File(real).exists()) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else req.getRequestDispatcher("/images/noimage.png").forward(req, resp);
    }

    @Override
    public void destroy() {

    }
}
