package com.transaccion.transaccion_demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cuenta {
    @Id
    private String numeroCuenta;

    private double monto;

    public Cuenta(String numeroCuenta, double monto) {
        this.numeroCuenta = numeroCuenta;
        this.monto = monto;
    }
}