package com.transaccion.transaccion_demo.repository;

import com.transaccion.transaccion_demo.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}
