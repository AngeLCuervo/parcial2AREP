package com.parcial2AREP.controller;

import com.parcial2AREP.model.OperationResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/operaciones")
public class OperationController {

    @GetMapping("/tribonacci")
    public OperationResult calcularTribonacci(@RequestParam int numero) {

        List<Integer> serie = new ArrayList<>();

        serie.add(0);
        if (numero >= 1) serie.add(0);
        if (numero >= 2) serie.add(1);

        for (int i = 3; i <= numero; i++) {
            int valor = serie.get(i - 1) + serie.get(i - 2) + serie.get(i - 3);
            serie.add(valor);
        }

        StringBuilder resultadoTexto = new StringBuilder();
        for (int i = 0; i < serie.size(); i++) {
            resultadoTexto.append(serie.get(i));
            if (i != serie.size() - 1) {
                resultadoTexto.append(", ");
            }
        }

        return new OperationResult("Serie Tribonacci", numero, resultadoTexto.toString());
    }
}