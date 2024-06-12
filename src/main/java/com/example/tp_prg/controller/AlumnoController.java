package com.example.tp_prg.controller;

import com.example.tp_prg.entidades.Alumno;
import com.example.tp_prg.repositorios.AlumnoRepository;
import com.example.tp_prg.servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @PostMapping("/")
    public ResponseEntity<?> crearAlumno(@RequestBody Alumno nuevoAlumno) {
        Alumno alumnoCreado = alumnoRepository.save(nuevoAlumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        if (!alumnoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alumno no encontrado con ID: " + id);
        }
        alumno.setIdAlumno(id);
        Alumno alumnoActualizado = alumnoRepository.save(alumno);
        return ResponseEntity.ok(alumnoActualizado);
    }

   @DeleteMapping("/{id}")
public ResponseEntity<?> eliminarAlumno(@PathVariable Long id) {
    if (!alumnoRepository.existsById(id)) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alumno no encontrado con ID: " + id);
    }
    alumnoRepository.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body("Alumno borrado correctamente");
}


    @GetMapping("/buscar")
    public ResponseEntity<?> obtenerAlumnosPorNombre(@RequestParam String nombre) {
        List<Alumno> alumnos = alumnoRepository.findByNombreContainingIgnoreCase(nombre);
        if (alumnos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron alumnos con el nombre: " + nombre);
        } else {
            return ResponseEntity.ok(alumnos);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Long id) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);
        if (optionalAlumno.isPresent()) {
            return ResponseEntity.ok(optionalAlumno.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alumno no encontrado con ID: " + id);
        }
    }
    
     @Autowired
    private AlumnoService alumnoService;
@GetMapping("/")
public ResponseEntity<?> obtenerTodosLosAlumnos() {
    List<Alumno> alumnos = alumnoService.obtenerTodosLosAlumnos(); // Llamada al método desde una instancia de AlumnoService
    return ResponseEntity.ok(alumnos);
}
   @GetMapping("/primeros10")
    public ResponseEntity<?> obtenerPrimeros10Alumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll(PageRequest.of(0, 10)).getContent();
        return ResponseEntity.ok(alumnos);
    }

}
