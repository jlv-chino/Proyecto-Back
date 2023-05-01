package com.portfolio.JoseLuisVilches.controlador;

import com.portfolio.JoseLuisVilches.excepciones.ResourceNotFoundException;
import com.portfolio.JoseLuisVilches.modelo.Skill;
import com.portfolio.JoseLuisVilches.repositorio.SkillRepositorio;
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
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillControlador {

    @Autowired
    private SkillRepositorio repositorio;

    @GetMapping("{id}")
    public ResponseEntity<Skill> obtenerSkill(@PathVariable Long id) {
        Skill skill = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese ID : " + id));
        return ResponseEntity.ok(skill);
    }
    
    @GetMapping("/skills")
    public List<Skill> listarSkill() {
        return repositorio.findAll();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public Skill crearSkill(@RequestBody Skill skill) {
        return repositorio.save(skill);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Skill> actualizarSkill(@PathVariable Long id, @RequestBody Skill nuevoSkill) {
        Skill skill = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese ID : " + id));

        skill.setTitulo_skill(nuevoSkill.getTitulo_skill());
        skill.setPorcentaje_skill(nuevoSkill.getPorcentaje_skill());

        Skill skillActualizado = repositorio.save(skill);
        return ResponseEntity.ok(skillActualizado);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarSkill(@PathVariable Long id) {
        Skill skill = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese el ID : " + id));

        repositorio.delete(skill);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
