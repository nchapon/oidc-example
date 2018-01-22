package fr.cnp.examples.oidc.api.config;

import fr.cnp.examples.oidc.api.model.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

/**
 * Created by nchapon on 22/01/18.
 */
public class RequestContextUserTest {


    @Test
    public void findUserFromHeader() {

        String userInfoHeader="{" +
                "\"user.fullName\":\"alice\"," +
                "\"user.email\":\"alice@gmail.com\"," +
                "\"id\":\"60f65308-3510-40ca-83f0-e9c0151cc680\"," +
                "\"sub\":\"60f65308-3510-40ca-83f0-e9c0151cc680\"," +
                "\"groups\":[\"user\"]" +
                "}";

        MockHttpServletRequest request= new MockHttpServletRequest();

        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        request.addHeader(RequestContextUser.USER_HEADER,userInfoHeader);

        User userFound = RequestContextUser.findUser();

        assertThat(userFound).isNotNull();
        assertThat(userFound.getFullName()).isEqualTo("alice");
        assertThat(userFound.getEmail()).isEqualTo("alice@gmail.com");
        assertThat(userFound.getAuthorities()).hasSize(1);




    }
}