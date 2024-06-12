    package com.example.tp_prg.servicios;

    import com.example.tp_prg.entidades.Encargado;
    import com.example.tp_prg.repositorios.EncargadoRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class EncargadoService {

        @Autowired
        private EncargadoRepository encargadoRepository;

        public Encargado crearEncargado(Encargado encargado) {
            return encargadoRepository.save(encargado);
        }

         public boolean existeEncargado(Long id) {
            return encargadoRepository.existsById(id);
        }

        public Encargado actualizarEncargado(Long id, Encargado encargado) {
            if (!encargadoRepository.existsById(id)) {
                throw new RuntimeException("Encargado no encontrado con ID: " + id);
            }
            encargado.setIdEncargado(id);
            return encargadoRepository.save(encargado);
        }

        public void eliminarEncargado(Long id) {
            if (!encargadoRepository.existsById(id)) {
                throw new RuntimeException("Encargado no encontrado con ID: " + id);
            }
            encargadoRepository.deleteById(id);
        }

        public List<Encargado> obtenerTodosLosEncargados() {
            return encargadoRepository.findAll();
        }

        public Encargado obtenerEncargadoPorId(Long id) {
            return encargadoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Encargado no encontrado con ID: " + id));
        }


    }
