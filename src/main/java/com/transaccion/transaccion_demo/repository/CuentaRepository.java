package com.transaccion.transaccion_demo.repository;

import com.transaccion.transaccion_demo.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, String> {
}
