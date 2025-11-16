package com.rfn.controle_equipamentos_ti.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity // Entidade JPA
@Table(name = "equipamento") // Tabela do banco de dados MySQL
public class Equipamento {

    @Id
    @NotBlank(message = "O campo de número de série é obrigatório.")
    @Column(name = "pk_num_serie", nullable = false)
    private String pk_num_serie;

    @NotBlank(message = "O campo de placa é obrigatório.")
    @Column(name = "placa", nullable = false)
    private String placa;

    @NotBlank(message = "O campo de tipo é obrigatório.")
    @Column(name = "tipo", nullable = false)
    private String tipo;

    @NotBlank(message = "O campo de modelo é obrigatório.")
    @Column(name = "modelo", nullable = false)
    private String modelo;

    @NotNull(message = "O campo de localização atual é obrigatório.")
    @Column(name = "localizacao_atual", nullable = false)
    private int localizacao_atual;

    @Column(name = "enviado")
    private String enviado = "Não";

    @Column(name = "usuario_cadastro")
    private String usuario_cadastro;

    public String getPk_num_serie() {
        return pk_num_serie;
    }
    
    public void setPk_num_serie(String pk_num_serie) {
        this.pk_num_serie = pk_num_serie;
    }
    
    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public int getLocalizacao_atual() {
        return localizacao_atual;
    }
    
    public void setLocalizacao_atual(int localizacao_atual) {
        this.localizacao_atual = localizacao_atual;
    }
    
    public String getEnviado() {
        return enviado;
    }
    
    public void setEnviado(String enviado) {
        this.enviado = enviado;
    }

    public String getUsuario_cadastro() {
        return usuario_cadastro;
    }
    
    public void setUsuario_cadastro(String usuario_cadastro) {
        this.usuario_cadastro = usuario_cadastro;
    }
}