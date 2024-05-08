package br.univille.fabsoft_2024_1_petshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //string nome
    //string marca
    //date validade
    //string categoria
    //long quantidade

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
