package com.example.tp_prg.controller;

import com.example.tp_prg.dto.InscripcionDTO;
import com.example.tp_prg.dto.InscripcionDetalleDTO;
import com.example.tp_prg.entidades.Encargado;
import com.example.tp_prg.entidades.Alumno;
import com.example.tp_prg.entidades.Curso;
import com.example.tp_prg.entidades.Inscripcion;
import com.example.tp_prg.servicios.EncargadoService;
import com.example.tp_prg.servicios.AlumnoService;
import com.example.tp_prg.servicios.CursoService;
import com.example.tp_prg.servicios.InscripcionService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private EncargadoService encargadoService;

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private CursoService cursoService;

    @PostMapping("/")
    public ResponseEntity<?> crearInscripcion(@RequestBody InscripcionDTO nuevaInscripcionDTO) {
        System.out.println("ID Encargado recrearInscricibido: " + nuevaInscripcionDTO.getIdEncargado());
        System.out.println("ID Alumno recibido: " + nuevaInscripcionDTO.getIdAlumno());
        System.out.println("ID Curso recibido: " + nuevaInscripcionDTO.getIdCurso());

        Encargado encargado = encargadoService.obtenerEncargadoPorId(nuevaInscripcionDTO.getIdEncargado());
        Alumno alumno = alumnoService.obtenerAlumnoPorId(nuevaInscripcionDTO.getIdAlumno()).orElse(null);
        Curso curso = cursoService.obtenerCursoPorId(nuevaInscripcionDTO.getIdCurso()).orElse(null);

        if (encargado == null || alumno == null || curso == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Encargado, Alumno o Curso no encontrado");
        }

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setEncargado(encargado);
        inscripcion.setAlumno(alumno);
        inscripcion.setCurso(curso);
        inscripcion.setFechaInscripcion(nuevaInscripcionDTO.getFechaInscripcion());
        inscripcion.setEstado(nuevaInscripcionDTO.getEstado());
        inscripcion.setNumeroCuenta(nuevaInscripcionDTO.getNumeroCuenta());
        inscripcion.setFechaContrato(nuevaInscripcionDTO.getFechaContrato());

        Inscripcion inscripcionCreada = inscripcionService.crearInscripcion(inscripcion);
        return ResponseEntity.ok(inscripcionCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarInscripcion(@PathVariable Long id, @RequestBody InscripcionDTO inscripcionDTO) {
        System.out.println("ID Encargado recibido: " + inscripcionDTO.getIdEncargado());
        System.out.println("ID Alumno recibido: " + inscripcionDTO.getIdAlumno());
        System.out.println("ID Curso recibido: " + inscripcionDTO.getIdCurso());

        if (!inscripcionService.existePorId(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inscripción no encontrada con ID: " + id);
        }

        Encargado encargado = encargadoService.obtenerEncargadoPorId(inscripcionDTO.getIdEncargado());
        Alumno alumno = alumnoService.obtenerAlumnoPorId(inscripcionDTO.getIdAlumno()).orElse(null);
        Curso curso = cursoService.obtenerCursoPorId(inscripcionDTO.getIdCurso()).orElse(null);

        if (encargado == null || alumno == null || curso == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Encargado, Alumno o Curso no encontrado");
        }

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setIdInscripcion(id);
        inscripcion.setEncargado(encargado);
        inscripcion.setAlumno(alumno);
        inscripcion.setCurso(curso);
        inscripcion.setFechaInscripcion(inscripcionDTO.getFechaInscripcion());
        inscripcion.setEstado(inscripcionDTO.getEstado());
        inscripcion.setNumeroCuenta(inscripcionDTO.getNumeroCuenta());
        inscripcion.setFechaContrato(inscripcionDTO.getFechaContrato());

        Inscripcion inscripcionActualizada = inscripcionService.actualizarInscripcion(id, inscripcion);
        return ResponseEntity.ok(inscripcionActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarInscripcion(@PathVariable Long id) {
        System.out.println("ID de Inscripción a eliminar: " + id);

        if (!inscripcionService.eliminarInscripcion(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inscripción no encontrada con ID: " + id);
        }
        return ResponseEntity.ok("Inscripción eliminada correctamente");
    }

   @GetMapping("/")
public ResponseEntity<?> obtenerTodasLasInscripciones() {
    System.out.println("Obteniendo todas las inscripciones");

        List<InscripcionDetalleDTO> inscripcionesDetalles = new ArrayList<>();
    List<Inscripcion> inscripciones = inscripcionService.obtenerTodasLasInscripciones();
    
    for (Inscripcion inscripcion : inscripciones) {
        InscripcionDetalleDTO inscripcionDetalleDTO = new InscripcionDetalleDTO();
        inscripcionDetalleDTO.setIdInscripcion(inscripcion.getIdInscripcion());
        inscripcionDetalleDTO.setEncargado(inscripcion.getEncargado());
        inscripcionDetalleDTO.setAlumno(inscripcion.getAlumno());
        inscripcionDetalleDTO.setCurso(inscripcion.getCurso());
        inscripcionDetalleDTO.setFechaInscripcion(inscripcion.getFechaInscripcion());
        inscripcionDetalleDTO.setEstado(inscripcion.getEstado());
        inscripcionDetalleDTO.setNumeroCuenta(inscripcion.getNumeroCuenta());
        inscripcionDetalleDTO.setFechaContrato(inscripcion.getFechaContrato());
        
        inscripcionesDetalles.add(inscripcionDetalleDTO);
    }
    
    return ResponseEntity.ok(inscripcionesDetalles);
}


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerInscripcionPorId(@PathVariable Long id) {
        System.out.println("Obteniendo inscripción por ID: " + id);

        Inscripcion inscripcion = inscripcionService.obtenerInscripcionPorId(id);
        if (inscripcion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inscripción no encontrada con ID: " + id);
        }
        return ResponseEntity.ok(inscripcion);
    }
}
