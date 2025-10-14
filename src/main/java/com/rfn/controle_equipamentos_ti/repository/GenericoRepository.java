package com.rfn.controle_equipamentos_ti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rfn.controle_equipamentos_ti.model.Generico;

@Repository
public interface GenericoRepository extends JpaRepository<Generico, Long> {
    @Query(value = "SELECT * FROM equipamento_generico ORDER BY pk_equipamento_generico DESC", nativeQuery = true)
    List<Generico> findAllDesc();
}
