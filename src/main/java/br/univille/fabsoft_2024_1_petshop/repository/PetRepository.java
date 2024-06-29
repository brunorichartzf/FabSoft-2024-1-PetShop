package br.univille.fabsoft_2024_1_petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.fabsoft_2024_1_petshop.entity.Cliente;
import br.univille.fabsoft_2024_1_petshop.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    
    List<Pet> findAllByCliente_Id(long id);
}
