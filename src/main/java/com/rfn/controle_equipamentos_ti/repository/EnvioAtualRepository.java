package com.rfn.controle_equipamentos_ti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rfn.controle_equipamentos_ti.model.EnvioAtual;

@Repository
public interface EnvioAtualRepository extends JpaRepository<EnvioAtual, Long>  {
    @Query(value = "SELECT * FROM envio_equipamento ORDER BY pk_envio DESC", nativeQuery = true)
    List<EnvioAtual> findAllDesc();
}
