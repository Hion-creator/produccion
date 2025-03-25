package com.example.produccion.repository;

import com.example.produccion.entity.OrdenProduccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Timestamp;
import java.util.List;

public interface OrdenProduccionRepository extends JpaRepository<OrdenProduccionEntity, Long> {
    List<OrdenProduccionEntity> findByEstadoAndFechaCreacionBefore(String estado, Timestamp fecha);
}

