package com.rfn.controle_equipamentos_ti.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // Marca esta classe como uma entidade JPA
@Table(name = "envio_antigo") // Mapeia para a tabela 'envio_antigo' no banco de dados
public class EnvioAntigo {
    
    @Id // Marca o campo como a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática de IDs pelo banco de dados
    @Column(name = "pk_envio_antigo") // Mapeia para a coluna 'pk_envio_antigo'
    private Long pk_envio_antigo; // O nome da chave primária foi alterado para refletir 'antigo'

    @ManyToOne // Indica um relacionamento muitos para um com Equipamento
    @JoinColumn(name = "fk_num_serie", referencedColumnName = "pk_num_serie") // Coluna que armazena a chave estrangeira
    private Equipamento equipamento; // O equipamento que foi enviado

    @Column(name = "origem") // Coluna para a origem do envio
    private String origem; // Ex: "Departamento de TI", "Loja X"

    @ManyToOne // Indica um relacionamento muitos para um com Loja
    @JoinColumn(name = "fk_loja", referencedColumnName = "pk_loja") // Coluna que armazena a chave estrangeira
    private Loja lojaDestino; // A loja para onde o equipamento foi enviado

    @Column(name = "motivo") // Coluna para o motivo do envio
    private String motivo; // Ex: "Substituição", "Manutenção", "Novo envio"

    @Column(name = "data_envio") // Coluna para a data do envio
    private LocalDate data_envio;

    @Column(name = "usuario_envio") // Coluna para o usuário que realizou o envio
    private String usuario_envio;

    // Construtor padrão (necessário para JPA)
    public EnvioAntigo() {
    }

    // --- Métodos Getters e Setters ---

    public Long getPk_envio_antigo() {
        return pk_envio_antigo;
    }

    public void setPk_envio_antigo(Long pk_envio_antigo) {
        this.pk_envio_antigo = pk_envio_antigo;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Loja getLojaDestino() {
        return lojaDestino;
    }

    public void setLojaDestino(Loja lojaDestino) {
        this.lojaDestino = lojaDestino;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getData_envio() {
        return data_envio;
    }

    public void setData_envio(LocalDate data_envio) {
        this.data_envio = data_envio;
    }

    public String getUsuario_envio() {
        return usuario_envio;
    }

    public void setUsuario_envio(String usuario_envio) {
        this.usuario_envio = usuario_envio;
    }
}