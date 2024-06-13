package com.example.demo.modelo;

import java.util.List;

public class ResultadoPlural {
    private List<String> palabrasPluralizadas;
    private int[] cantidadesPorRegla;

    public ResultadoPlural(){}
    public ResultadoPlural(List<String> palabrasPluralizadas, int[] cantidadesPorRegla){
        this.palabrasPluralizadas = palabrasPluralizadas;
        this.cantidadesPorRegla = cantidadesPorRegla;
    }

    public List<String> getPalabrasPluralizadas(){
        return palabrasPluralizadas;
    }

    public void setPalabrasPluralizadas(List<String> palabrasPluralizadas) {
        this.palabrasPluralizadas = palabrasPluralizadas;
    }

    public int[] getCantidadesPorRegla() {
        return cantidadesPorRegla;
    }

    public void setCantidadesPorRegla(int[] cantidadesPorRegla) {
        this.cantidadesPorRegla = cantidadesPorRegla;
    }

}
