package com.example.demo.controlador;

import com.example.demo.modelo.ResultadoPlural;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pluralizador")
public class PluralizadorController {

    @PostMapping
    public ResultadoPlural pluralizar(@RequestBody List<String> palabras){
        return pluralizador(palabras.toArray(new String[0]));
    }

    private ResultadoPlural pluralizador(String[] palabras){
        List<String> palabrasPluralizadas = new ArrayList<>();
        int[] cantidadesPorRegla = new int[4]; // Contadores para cada regla

        for (String palabra : palabras) {
            String plural = hacerPlural(palabra, cantidadesPorRegla);
            palabrasPluralizadas.add(plural);
        }
        return new ResultadoPlural(palabrasPluralizadas, cantidadesPorRegla);
    }

    private String hacerPlural(String palabra, int[] cantidadesPorRegla){
        if (palabra == null || palabra.isEmpty()) {
            return palabra;
        }
        // Convertir la palabra a minúsculas
        palabra = palabra.toLowerCase();

        char ultimaLetra = palabra.charAt(palabra.length() - 1);

        // Regla 1: Si el sustantivo termina en vocal se agrega "s"
        if (ultimaLetra == 'a' || ultimaLetra == 'e' || ultimaLetra == 'i' || ultimaLetra == 'o' || ultimaLetra == 'u'){
            cantidadesPorRegla[0]++;
            return palabra + "s";
        }

        // Regla 2: Si el sustantivo termina en "s - x" queda igual
        if (ultimaLetra == 's' || ultimaLetra == 'x' ){
            cantidadesPorRegla[1]++;
            return palabra ;
        }

        // Regla 3: Si el sustantivo termina en "z" esta se cambia por "ces"
        if (ultimaLetra == 'z' ){
            cantidadesPorRegla[2]++;
            return palabra.substring(0, palabra.length()- 1) + "ces";
        }

        // Regla 4: Si el sustantivo termina en otra consonante se agrega "es"
        else
            cantidadesPorRegla[3]++;
        return palabra + "es";
    }

}
