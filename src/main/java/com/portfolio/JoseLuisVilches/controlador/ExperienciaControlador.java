package com.portfolio.JoseLuisVilches.controlador;

import com.portfolio.JoseLuisVilches.excepciones.ResourceNotFoundException;
import com.portfolio.JoseLuisVilches.modelo.Experiencia;
import com.portfolio.JoseLuisVilches.repositorio.ExperienciaRepositorio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "https://portfolio-frontend-jlv.web.app")
public class ExperienciaControlador {

    @Autowired
    private ExperienciaRepositorio repositorio;

    @GetMapping("{id}")
    public ResponseEntity<Experiencia> obtenerExperiencia(@PathVariable Long id) {
        Experiencia experiencia = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese ID : " + id));
        return ResponseEntity.ok(experiencia);
    }

    @GetMapping("/experiencias")
    public List<Experiencia> listarExperiencia() {
        return repositorio.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public Experiencia crearExperiencia(@RequestBody Experiencia experiencia) {
        return repositorio.save(experiencia);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Experiencia> actualizarExperiencia(@PathVariable Long id, @RequestBody Experiencia nuevaExperiencia) {
        Experiencia experiencia = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese ID : " + id));

        experiencia.setPuesto_experiencia(nuevaExperiencia.getPuesto_experiencia());
        experiencia.setCompania_experiencia(nuevaExperiencia.getCompania_experiencia());
        experiencia.setModalidad_experiencia(nuevaExperiencia.getModalidad_experiencia());
        experiencia.setImagen_experiencia(nuevaExperiencia.getImagen_experiencia());
        experiencia.setInicio_experiencia(nuevaExperiencia.getInicio_experiencia());
        experiencia.setFin_experiencia(nuevaExperiencia.getFin_experiencia());
        experiencia.setTiempo_experiencia(nuevaExperiencia.getTiempo_experiencia());

        Experiencia experienciaActualizada = repositorio.save(experiencia);
        return ResponseEntity.ok(experienciaActualizada);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarExperiencia(@PathVariable Long id) {
        Experiencia experiencia = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese el ID : " + id));

        repositorio.delete(experiencia);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
