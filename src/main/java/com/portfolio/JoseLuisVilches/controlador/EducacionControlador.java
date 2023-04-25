
package com.portfolio.JoseLuisVilches.controlador;

import com.portfolio.JoseLuisVilches.excepciones.ResourceNotFoundException;
import com.portfolio.JoseLuisVilches.modelo.Educacion;
import com.portfolio.JoseLuisVilches.repositorio.EducacionRepositorio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionControlador {
    
    @Autowired
    private EducacionRepositorio repositorio;

    @GetMapping("{id}")
    public ResponseEntity<Educacion> obtenerPerfil(@PathVariable Long id) {
        Educacion educacion = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese ID : " + id));
        return ResponseEntity.ok(educacion);
    }
    
    @GetMapping("/educaciones")
    public List<Educacion> listarSkill() {
        return repositorio.findAll();
    }
    
    @PostMapping("/crear")
    public Educacion crearSkill(@RequestBody Educacion educacion) {
        return repositorio.save(educacion);
    }
    
     @PutMapping("/editar/{id}")
    public ResponseEntity<Educacion> actualizarskill(@PathVariable Long id, @RequestBody Educacion nuevaEducacion) {
        Educacion educacion = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese ID : " + id));

        educacion.setEstablecimiento_educacion(nuevaEducacion.getEstablecimiento_educacion());
        educacion.setTitulo_educacion(nuevaEducacion.getTitulo_educacion());
        educacion.setFin_educacion(nuevaEducacion.getFin_educacion());
        educacion.setImagen_educacion(nuevaEducacion.getImagen_educacion());

        Educacion educacionActualizada = repositorio.save(educacion);
        return ResponseEntity.ok(educacionActualizada);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEducacion(@PathVariable Long id) {
        Educacion educacion = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese el ID : " + id));

        repositorio.delete(educacion);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
}
