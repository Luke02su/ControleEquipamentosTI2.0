package com.rfn.controle_equipamentos_ti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rfn.controle_equipamentos_ti.model.Descarte;

@Repository
public interface DescarteRepository extends JpaRepository<Descarte, Long>  {
    @Query(value = "SELECT * FROM log_equipamentos_descartados ORDER BY pk_descarte DESC", nativeQuery = true)
    List<Descarte> findAllDesc();
}
