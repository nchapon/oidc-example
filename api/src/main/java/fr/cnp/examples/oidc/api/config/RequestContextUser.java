package fr.cnp.examples.oidc.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.cnp.examples.oidc.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by nchapon on 19/01/18.
 */
public class RequestContextUser {


    private static final Logger log = LoggerFactory.getLogger(RequestContextUser.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public  static final String USER_HEADER = "x-userinfo";

    public static User findUser() {
        String userInfoHeader;
        HttpServletRequest req;

        try {
            RequestAttributes reqAttr = RequestContextHolder.currentRequestAttributes();

            if (
                    reqAttr instanceof ServletRequestAttributes &&
                            (req = ((ServletRequestAttributes) reqAttr).getRequest()) != null &&
                            (userInfoHeader = req.getHeader(USER_HEADER)) != null
                    ) {
                log.debug("Found user info from {} header with value {}", USER_HEADER, userInfoHeader);
                User user =  mapper.readValue(userInfoHeader, User.class);
                req.setAttribute(User.class.getName(), user);
                return user;
            }
        } catch (IllegalStateException|IOException e) {
            log.error("Unable to resolve user from {} header", USER_HEADER, e);
        }

        log.debug("Did not find user from {} header.", USER_HEADER);
        return null;
    }



}
