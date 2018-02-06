package fr.cnp.examples.oidc.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nchapon on 22/12/17.
 */
@RestController
public class MessageRestController {

    @GetMapping("/secured")
    @PreAuthorize("hasAuthority('users')")
    public Message getSecured(){
        return new Message("Hello user");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('admins')")
    public Message getAdmin(){
        return new Message("Hello admin");
    }

    @GetMapping("/403")
    @ResponseStatus(value= HttpStatus.FORBIDDEN)
    public Message accessDenied(){
        return new Message("Access Denied");
    }




}
