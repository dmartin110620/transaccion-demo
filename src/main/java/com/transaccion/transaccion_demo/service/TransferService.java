package com.transaccion.transaccion_demo.service;

import com.transaccion.transaccion_demo.model.Cuenta;
import com.transaccion.transaccion_demo.model.Transaccion;
import com.transaccion.transaccion_demo.repository.CuentaRepository;
import com.transaccion.transaccion_demo.repository.TransaccionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Service
public class TransferService {
    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;

    public TransferService(CuentaRepository cuentaRepository, TransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }

    @Transactional
    public void transferir(String origen, String destino, double monto) {
        Cuenta cuentaOrigen = cuentaRepository.findById(origen).orElseThrow();
        Cuenta cuentaDestino = cuentaRepository.findById(destino).orElseThrow();

        if (cuentaOrigen.getMonto() >= monto) {
            cuentaOrigen.setMonto(cuentaOrigen.getMonto() - monto);
            cuentaDestino.setMonto(cuentaDestino.getMonto() + monto);

            cuentaRepository.save(cuentaOrigen);
            cuentaRepository.save(cuentaDestino);

            transaccionRepository.save(new Transaccion(origen, destino, monto));
        }
    }

    public void ejecutarTransferenciasConcurrentes() {
        ExecutorService executor = Executors.newFixedThreadPool(30);

        IntStream.range(0, 1000).forEach(i -> executor.execute(() -> transferir("abc", "cbd", 10)));

        executor.shutdown();
    }
}
