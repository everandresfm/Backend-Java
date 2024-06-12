package com.example.tp_prg.controller;

import com.example.tp_prg.entidades.Encargado;
import com.example.tp_prg.servicios.EncargadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/encargados")
public class EncargadoController {

    @Autowired
    private EncargadoService encargadoService;

    @PostMapping("/")
    public ResponseEntity<?> crearEncargado(@RequestBody Encargado nuevoEncargado) {
        Encargado encargadoCreado = encargadoService.crearEncargado(nuevoEncargado);
        return ResponseEntity.ok(encargadoCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEncargado(@PathVariable Long id, @RequestBody Encargado encargado) {
        if (!encargadoService.existeEncargado(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Encargado no encontrado con ID: " + id);
        }
        Encargado encargadoActualizado = encargadoService.actualizarEncargado(id, encargado);
        return ResponseEntity.ok(encargadoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEncargado(@PathVariable Long id) {
        if (!encargadoService.existeEncargado(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Encargado no encontrado con ID: " + id);
        }
        encargadoService.eliminarEncargado(id);
        return ResponseEntity.ok("Encargado eliminado correctamente");
    }

    @GetMapping("/")
    public ResponseEntity<?> obtenerTodosLosEncargados() {
        List<Encargado> encargados = encargadoService.obtenerTodosLosEncargados();
        return ResponseEntity.ok(encargados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEncargadoPorId(@PathVariable Long id) {
        Encargado encargado = encargadoService.obtenerEncargadoPorId(id);
        if (encargado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Encargado no encontrado con ID: " + id);
        }
        return ResponseEntity.ok(encargado);
    }
}
