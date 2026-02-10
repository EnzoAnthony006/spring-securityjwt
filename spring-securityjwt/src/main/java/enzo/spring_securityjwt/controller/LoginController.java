package enzo.spring_securityjwt.controller;

import enzo.spring_securityjwt.dtos.Login;
import enzo.spring_securityjwt.dtos.Sessao;
import enzo.spring_securityjwt.model.User;
import enzo.spring_securityjwt.repository.UserRepository;
import enzo.spring_securityjwt.security.JWTCreator;
import enzo.spring_securityjwt.security.JWTObject;
import enzo.spring_securityjwt.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public Sessao logar(@RequestBody Login login) {

        User user = userRepository.findByUsername(login.getUsername());
        if (user == null) {
            throw new RuntimeException("Erro Ao Tentar Fazer Login");
        }

        boolean passwordOk = passwordEncoder.matches(login.getPassword(), user.getPassword());
        if (!passwordOk) {
            throw new RuntimeException("Senha Incorreta para o login " + login.getUsername());
        }

        Sessao sessao = new Sessao();
        sessao.setLogin(user.getUsername());

        JWTObject jwtObject = new JWTObject();
        jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
        jwtObject.setExpiration(new Date(System.currentTimeMillis() + securityConfig.getExpiration())); // <- aqui
        jwtObject.setRoles(user.getRoles());

        sessao.setToken(JWTCreator.create(securityConfig.getPrefix(), securityConfig.getKey(), jwtObject)); // <- e aqui

        return sessao;
    }
}
