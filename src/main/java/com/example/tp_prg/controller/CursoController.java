package com.example.tp_prg.controller;

import com.example.tp_prg.entidades.Curso;
import com.example.tp_prg.servicios.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/")
    public ResponseEntity<?> obtenerTodosLosCursos() {
        List<Curso> cursos = cursoService.obtenerTodosLosCursos();
        if (cursos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay cursos disponibles");
        }
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCursoPorId(@PathVariable Integer id) {
        Optional<Curso> curso = cursoService.obtenerCursoPorId(id);
        if (curso.isPresent()) {
            return ResponseEntity.ok(curso.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso no encontrado con ID: " + id);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> crearCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.crearCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Curso creado exitosamente con ID: " + nuevoCurso.getIdCur());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCurso(@PathVariable Integer id, @RequestBody Curso curso) {
        Curso cursoActualizado = cursoService.actualizarCurso(id, curso);
        if (cursoActualizado != null) {
            return ResponseEntity.ok("Curso actualizado exitosamente con ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Curso no encontrado con ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable Integer id) {
        if (cursoService.eliminarCurso(id)) {
            return ResponseEntity.ok("Curso eliminado exitosamente con ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Curso no encontrado con ID: " + id);
        }
    }
}
