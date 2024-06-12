package com.example.tp_prg.repositorios;

import com.example.tp_prg.entidades.Encargado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EncargadoRepository extends JpaRepository<Encargado, Long> {

    List<Encargado> findByNombreContainingIgnoreCase(String nombre);

    @Override
    Optional<Encargado> findById(Long id);
}
