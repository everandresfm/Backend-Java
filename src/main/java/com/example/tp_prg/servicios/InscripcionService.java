package com.example.tp_prg.servicios;

import com.example.tp_prg.entidades.Inscripcion;
import com.example.tp_prg.repositorios.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    public Inscripcion crearInscripcion(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    public Inscripcion actualizarInscripcion(Long id, Inscripcion inscripcion) {
        if (!inscripcionRepository.existsById(id)) {
            return null;
        }
        inscripcion.setIdInscripcion(id);
        return inscripcionRepository.save(inscripcion);
    }

    public boolean eliminarInscripcion(Long id) {
        if (!inscripcionRepository.existsById(id)) {
            return false;
        }
        inscripcionRepository.deleteById(id);
        return true;
    }

    public List<Inscripcion> obtenerTodasLasInscripciones() {
        return inscripcionRepository.findAll();
    }

    public Inscripcion obtenerInscripcionPorId(Long id) {
        return inscripcionRepository.findById(id).orElse(null);
    }

    public boolean existePorId(Long id) {
        return inscripcionRepository.existsById(id);
    }
}
