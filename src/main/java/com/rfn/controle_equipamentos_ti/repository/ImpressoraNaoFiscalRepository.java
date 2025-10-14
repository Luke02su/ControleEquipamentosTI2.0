package com.rfn.controle_equipamentos_ti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rfn.controle_equipamentos_ti.model.ImpressoraNaoFiscal;

@Repository
public interface ImpressoraNaoFiscalRepository extends JpaRepository<ImpressoraNaoFiscal, Long> {
    @Query(value = "SELECT * FROM impressora ORDER BY pk_impressora DESC", nativeQuery = true)
    List<ImpressoraNaoFiscal> findAllDesc();
}