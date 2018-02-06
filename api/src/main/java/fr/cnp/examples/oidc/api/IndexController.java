package fr.cnp.examples.oidc.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by nchapon on 05/02/18.
 */
@Controller
public class IndexController {


    @GetMapping("/index.html")
    public String index(){
        return "index";
    }
}
