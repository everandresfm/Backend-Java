package com.example.tp_prg.servicios;

import com.example.tp_prg.entidades.Alumno;
import com.example.tp_prg.repositorios.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public Alumno crearAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Alumno actualizarAlumno(Long id, Alumno alumno) {
        if (!alumnoRepository.existsById(id)) {
            throw new RuntimeException("Alumno no encontrado con ID: " + id);
        }
        alumno.setIdAlumno(id);
        return alumnoRepository.save(alumno);
    }

    public void eliminarAlumno(Long id) {
        if (!alumnoRepository.existsById(id)) {
            throw new RuntimeException("Alumno no encontrado con ID: " + id);
        }
        alumnoRepository.deleteById(id);
    }

  public List<Alumno> obtenerTodosLosAlumnos() {
    return alumnoRepository.findAll();
}


    public Optional<Alumno> obtenerAlumnoPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    public List<Alumno> buscarAlumnosPorNombre(String nombre) {
        return alumnoRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
