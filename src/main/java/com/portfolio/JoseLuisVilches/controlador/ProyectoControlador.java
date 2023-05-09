
package com.portfolio.JoseLuisVilches.controlador;

import com.portfolio.JoseLuisVilches.excepciones.ResourceNotFoundException;
import com.portfolio.JoseLuisVilches.modelo.Proyecto;
import com.portfolio.JoseLuisVilches.repositorio.ProyectoRepositorio;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "https://portfolio-frontend-jlv.web.app")
public class ProyectoControlador {
    
    @Autowired
    private ProyectoRepositorio repositorio;

    @GetMapping("{id}")
    public ResponseEntity<Proyecto> obtenerProyecto(@PathVariable Long id) {
        Proyecto proyecto = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese ID : " + id));
        return ResponseEntity.ok(proyecto);
    }
    
    @GetMapping("/proyectos")
    public List<Proyecto> listarProyecto() {
        return repositorio.findAll();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {
        return repositorio.save(proyecto);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto nuevoProyecto) {
        Proyecto proyecto = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese ID : " + id));

        proyecto.setNombre_proyecto(nuevoProyecto.getNombre_proyecto());
        proyecto.setUrl_repositorio(nuevoProyecto.getUrl_repositorio());
        proyecto.setUrl_deploy(nuevoProyecto.getUrl_deploy());
        proyecto.setDescripcion_proyecto(nuevoProyecto.getDescripcion_proyecto());
        proyecto.setImagen_proyecto(nuevoProyecto.getImagen_proyecto());

        Proyecto proyectoActualizado = repositorio.save(proyecto);
        return ResponseEntity.ok(proyectoActualizado);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProyecto(@PathVariable Long id) {
        Proyecto proyecto = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese el ID : " + id));

        repositorio.delete(proyecto);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
}
