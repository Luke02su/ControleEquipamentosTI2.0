package com.rfn.controle_equipamentos_ti.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "log_equipamentos_descartados")
public class Descarte {

    @Valid
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_descarte")
    private Long pk_descarte;

    @Valid
    @NotBlank(message = "O campo de número de série é obrigatório.")
    @Column(name = "fk_num_serie", nullable = false)
    private String fk_num_serie;

    @Valid
    @NotBlank(message = "O campo de placa é obrigatório.")
    @Column(name = "placa", nullable = false)
    private String placa;

    @Valid
    @NotBlank(message = "O campo de tipo é obrigatório.")
    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Valid
    @NotBlank(message = "O campo de modelo é obrigatório.")
    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Valid
    @NotBlank(message = "O campo de motivo é obrigatório.")
    @Column(name = "motivo", nullable = false)
    private String motivo;

    @Valid
    @NotNull(message = "O campo de última localização é obrigatório.")
    @Column(name = "ultima_localizacao", nullable = false)
    private Long ultima_localizacao;

    @Valid
    @NotNull(message = "O campo de data de envio é obrigatório.")
    @Column(name = "data", nullable = false)
    private Date data;

    @Valid
    @NotBlank(message = "O campo de última usuário de envio é obrigatório.")
    @Column(name = "usuario", nullable = false)
    private String usuario;

    public String getFk_num_serie() {
        return fk_num_serie;
    }
    
    public void setFk_num_serie(String fk_num_serie) {
        this.fk_num_serie = fk_num_serie;
    }    

    public Long getPk_descarte() {
        return pk_descarte;
    }

    public void setPPk_descarte(Long pk_descarte) {
        this.pk_descarte = pk_descarte;
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

    public String getMotivo() {
        return motivo;
    }
    
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setUltima_localizacao(Long ultima_localizacao) {
        this.ultima_localizacao = ultima_localizacao;
    }

    public Long getUltima_localizacao() {
        return ultima_localizacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
