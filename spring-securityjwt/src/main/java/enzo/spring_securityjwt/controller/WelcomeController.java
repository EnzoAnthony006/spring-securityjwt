package enzo.spring_securityjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome()
        {
        return "Welcome to My Spring Security Web API";
        }
        @GetMapping("/users")
    public String users()
        {
            return "Authorized users";
        }
        @GetMapping("/managers")
    public String managers()
        {
            return "Authorized managers";
        }
}
