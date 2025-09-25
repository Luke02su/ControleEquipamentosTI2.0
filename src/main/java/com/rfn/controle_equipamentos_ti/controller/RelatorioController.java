package com.rfn.controle_equipamentos_ti.controller;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/enviarExcel")
    public ResponseEntity<String> enviarExcel(
            @RequestParam("file") MultipartFile file,
            @RequestParam("destinatarios") String destinatarios) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // Separar múltiplos e-mails
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
                    .body("Erro ao enviar e-mail: " + e.getMessage());
        }
    }
}
