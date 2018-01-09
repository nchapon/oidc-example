package fr.cnp.examples.oidc.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nchapon on 22/12/17.
 */
@RestController
public class MessageRestController {


    @GetMapping("/public")
    public Message getPublic(){
        return new Message(1L,"public");
    }

    @GetMapping("/secured")
    public Message getSecured(){
        return new Message(2L,"secured");
    }

    @GetMapping("/admin")
    public Message getAdmin(){
        return new Message(3L,"admin");
    }



}
