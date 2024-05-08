package br.univille.fabsoft_2024_1_petshop.service;

import java.util.List;

import br.univille.fabsoft_2024_1_petshop.entity.Pet;

public interface PetService {
    void save(Pet pet);

    Pet getById(long id);

    List<Pet> getAll();

    Pet delete(long id);
}
