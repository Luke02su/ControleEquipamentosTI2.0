package com.rfn.controle_equipamentos_ti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.rfn.controle_equipamentos_ti.service.EnvioAtualService; 

@Controller
public class RelatorioViewController {

    @Autowired
    private EnvioAtualService envioAtualService;

    @GetMapping("/relatorio")
    public String index(Model model) {
        model.addAttribute("enviosList", envioAtualService.getAllEnviosAtuais());
        return "relatorio/index";
    }
}
