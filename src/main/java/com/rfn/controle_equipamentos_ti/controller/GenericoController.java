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

import com.rfn.controle_equipamentos_ti.model.Generico;
import com.rfn.controle_equipamentos_ti.service.EquipamentoService;
import com.rfn.controle_equipamentos_ti.service.GenericoService;
import com.rfn.controle_equipamentos_ti.service.LojaService;

@Controller
public class GenericoController {

    @Autowired //Injeta automaticamente a dependência do serviço
    private GenericoService genericoService;

    @Autowired
    private EquipamentoService equipamentoService;

    @Autowired
    private LojaService lojaService;

    @GetMapping("/generico") //Mapear requisição get
    public String index(Model model) { //listar 
        model.addAttribute("genericoList", genericoService.getAllGenericos()); //model objeto que leva dados do backend para a view
        return "generico/index"; //mapeia requisições GET para o método index()
    }

    @GetMapping("/generico/create") //Mapeia requisiões HTTP para métodos
    public String create(Model model) {
        model.addAttribute("generico", new Generico());
        model.addAttribute("equipamentos", equipamentoService.getAllEquipamentos());
        model.addAttribute("genericos", genericoService.getAllGenericos());
        model.addAttribute("lojas", lojaService.getAllLojas());
        return "generico/create";
    }

    @PostMapping("/generico/save")
    public String salvarGenerico(@ModelAttribute @Validated Generico generico, BindingResult result) {
        if (result.hasErrors()) {
            return "generico/create";
        }

        // Agora salva o computador
        genericoService.saveGenerico(generico);; // ou via computadorService.saveComputador(computador)
        return "redirect:/generico";
    }

    @GetMapping("/generico/delete/{pk_equipamento_generico}")
    public String deleteGenerico(@PathVariable Long pk_equipamento_generico) {
        this.genericoService.deleteGenericoById(pk_equipamento_generico);
        return "redirect:/generico";
    }

    @GetMapping("/generico/edit/{pk_equipamento_generico}")
    public String edit(@PathVariable Long pk_equipamento_generico, Model model) {
        Generico generico = genericoService.getGenericoById(pk_equipamento_generico);
        model.addAttribute("generico", generico);
        model.addAttribute("equipamentos", equipamentoService.getAllEquipamentos());
        model.addAttribute("genericos", genericoService.getAllGenericos());
        model.addAttribute("lojas", lojaService.getAllLojas());
        return "generico/edit";
    }
}


