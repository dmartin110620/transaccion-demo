package com.transaccion.transaccion_demo.controller;

import com.transaccion.transaccion_demo.service.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/start")
    public String iniciarTransferencias() {
        transferService.ejecutarTransferenciasConcurrentes();
        return "Transferencias en proceso...";
    }
}
