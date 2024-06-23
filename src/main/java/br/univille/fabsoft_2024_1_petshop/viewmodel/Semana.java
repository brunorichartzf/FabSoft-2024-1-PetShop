package br.univille.fabsoft_2024_1_petshop.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class Semana {
    List<Dia> listaDias = new ArrayList<>();

    public List<Dia> getListaDias() {
        return listaDias;
    }

    public void setListaDias(List<Dia> listaDias) {
        this.listaDias = listaDias;
    }
}
