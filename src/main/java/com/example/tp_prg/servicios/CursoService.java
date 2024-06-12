package com.example.tp_prg.servicios;

import com.example.tp_prg.entidades.Curso;
import com.example.tp_prg.repositorios.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerCursoPorId(Integer id) {
        return cursoRepository.findById(id);
    }

    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso actualizarCurso(Integer id, Curso curso) {
        if (cursoRepository.existsById(id)) {
            curso.setIdCur(id);
            return cursoRepository.save(curso);
        } else {
            return null;
        }
    }

    public boolean eliminarCurso(Integer id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
