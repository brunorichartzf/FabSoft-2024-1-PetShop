package br.univille.fabsoft_2024_1_petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.fabsoft_2024_1_petshop.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    
}
