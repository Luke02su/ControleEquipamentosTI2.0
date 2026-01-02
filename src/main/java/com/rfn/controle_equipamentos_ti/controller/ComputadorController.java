package com.rfn.controle_equipamentos_ti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rfn.controle_equipamentos_ti.model.Computador;
import com.rfn.controle_equipamentos_ti.service.ComputadorService;
import com.rfn.controle_equipamentos_ti.service.EquipamentoService;
import com.rfn.controle_equipamentos_ti.service.LojaService;

@Controller //Define um controlador Spring MVC. Indica que a classe é um controlador MVC
public class ComputadorController {


    @Autowired //Injeta automaticamente a dependência do serviço
    private ComputadorService computadorService;
    
    @Autowired
    private EquipamentoService equipamentoService;

    @Autowired
    private LojaService lojaService;


    @GetMapping("/computador") //Mapear requisição get
    public String index(Model model) { //listar 
        model.addAttribute("computadoresList", computadorService.getAllComputadores()); //model objeto que leva dados do backend para a view
        return "computador/index"; //mapeia requisições GET para o método index()
    }

    @GetMapping("/computador/create") //Mapeia requisiões HTTP para métodos
    public String create(Model model) {
        model.addAttribute("computador", new Computador());
        model.addAttribute("equipamentos", equipamentoService.getAllEquipamentos());
        model.addAttribute("computadores", computadorService.getAllComputadores());
        model.addAttribute("lojas", lojaService.getAllLojas());
        return "computador/create";
    }

    @PostMapping("/computador/save")
    public String salvarComputador(@ModelAttribute @Validated Computador computador, BindingResult result) {

        //String usuario_cadastro = principal.getName();
       // computador.setEquipamento(null);


        if (result.hasErrors()) {
            return "computador/create";
        }

        // Agora salva o computador
        computadorService.saveComputador(computador); // ou via computadorService.saveComputador(computador)
        return "redirect:/computador";
    }

    @GetMapping("/computador/delete/{pk_computador}")
    public String deleteComputador(@PathVariable Long pk_computador) {
        this.computadorService.deleteComputadorById(pk_computador);
        return "redirect:/computador";
    }

    @GetMapping("/computador/edit/{pk_computador}")
    public String edit(@PathVariable Long pk_computador, Model model) {
        Computador computador = computadorService.getComputadorById(pk_computador);
        model.addAttribute("computador", computador);
        model.addAttribute("equipamentos", equipamentoService.getAllEquipamentos());
        model.addAttribute("computadores", computadorService.getAllComputadores());
        model.addAttribute("lojas", lojaService.getAllLojas());
        return "computador/edit";
    }
//integração da camada de serviço com as views (index, new_product, update_product)
}