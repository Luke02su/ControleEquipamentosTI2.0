package com.rfn.controle_equipamentos_ti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardBIController {

    @GetMapping("/dashboardBI")
    public String dashboardBI() {
        return "dashboardBI/index";
    }
}
