package com.rfn.controle_equipamentos_ti.controller;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value; // <-- 1. ADICIONE ESTA IMPORTAÇÃO
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.rfn.controle_equipamentos_ti.service.EnvioAtualService;
import com.rfn.controle_equipamentos_ti.service.DescarteService;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {
    
    @Autowired
    private EnvioAtualService envioAtualService;

    @Autowired
    private DescarteService descarteService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String remetenteConfigurado;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("enviosList", envioAtualService.getAllEnviosAtuais());
        model.addAttribute("descartesList", descarteService.getAllDescartes()); //model objeto que leva dados do backend para a view
        return "relatorio/index";
    }

    @PostMapping("/enviarExcel")
    @ResponseBody
    public ResponseEntity<String> enviarExcel(
            @RequestParam("file") MultipartFile file,
            @RequestParam("destinatarios") String destinatarios) {
    
        System.out.println("-----> O REMETENTE QUE O SPRING ESTÁ USANDO É: [" + remetenteConfigurado + "]");
    
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
    
            // ==================================================================
            // ADICIONE ESTA LINHA PARA FORÇAR O REMETENTE CORRETO
            helper.setFrom(remetenteConfigurado); 
            // ==================================================================
    
            String[] emails = destinatarios.split("[;,]");
            helper.setTo(emails);
    
            helper.setSubject("Relatório de Envios de Equipamentos");
            helper.setText("Segue em anexo o relatório solicitado.");
            helper.addAttachment("relatorio.xlsx", new ByteArrayResource(file.getBytes()));
    
            javaMailSender.send(message);
    
            return ResponseEntity.ok("E-mail enviado com sucesso para: " + String.join(", ", emails));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao enviar e--mail: " + e.getMessage());
        }
    }
}