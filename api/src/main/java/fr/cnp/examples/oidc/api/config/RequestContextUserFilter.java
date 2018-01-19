package fr.cnp.examples.oidc.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import java.io.IOException;

@Component
public class RequestContextUserFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(RequestContextUserFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {


        String user = RequestContextUser.findUser();
        log.info("XXXX > User");

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
