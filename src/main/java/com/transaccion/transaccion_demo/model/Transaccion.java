package com.transaccion.transaccion_demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origen;
    private String destino;
    private double monto;
    private LocalDateTime timestamp;

    public Transaccion(String origen, String destino, double monto) {
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
        this.timestamp = LocalDateTime.now();
    }
}
