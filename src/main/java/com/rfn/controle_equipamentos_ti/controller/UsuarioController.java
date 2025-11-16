package com.rfn.controle_equipamentos_ti.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @GetMapping("/me")
    public String me(Principal principal) {
        return principal == null ? "Nenhum usuário conctado." : principal.getName();
    }
}
