package com.portfolio.JoseLuisVilches.controlador;

import com.portfolio.JoseLuisVilches.excepciones.ResourceNotFoundException;
import com.portfolio.JoseLuisVilches.modelo.Persona;
import com.portfolio.JoseLuisVilches.repositorio.PersonaRepositorio;
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
@RequestMapping("/persona")
@CrossOrigin("http://localhost:4200")
public class PersonaControlador {

    @Autowired
    private PersonaRepositorio repositorio;

    @GetMapping("{id}")
    public ResponseEntity<Persona> obtenerPerfil(@PathVariable Long id) {
        Persona persona = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese ID : " + id));
        return ResponseEntity.ok(persona);
    }

    /*@GetMapping("")
    public Persona findPersona(){
        return repositorio.findPersona((long)1);  
    }*/
    
    @GetMapping("/personas")
    public List<Persona> listarPersonas() {
        return repositorio.findAll();
    }

    @PostMapping("/crear")
    public Persona crearPersona(@RequestBody Persona persona) {
        return repositorio.save(persona);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Persona> actualizarPerfil(@PathVariable Long id, @RequestBody Persona nuevaPersona) {
        Persona persona = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese ID : " + id));

        persona.setNombre(nuevaPersona.getNombre());
        persona.setApellido(nuevaPersona.getApellido());
        persona.setImagen(nuevaPersona.getImagen());
        persona.setPuesto(nuevaPersona.getPuesto());
        persona.setCompania(nuevaPersona.getCompania());
        persona.setUbicacion(nuevaPersona.getUbicacion());
        persona.setTelefono(nuevaPersona.getTelefono());
        persona.setEmail(nuevaPersona.getEmail());
        persona.setTitulo_acerca_de(nuevaPersona.getTitulo_acerca_de());
        persona.setAcerca_de(nuevaPersona.getAcerca_de());
        persona.setUser(nuevaPersona.getUser());
        persona.setPassword(nuevaPersona.getPassword());

        Persona perfilActualizado = repositorio.save(persona);
        return ResponseEntity.ok(perfilActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarPersona(@PathVariable Long id) {
        Persona persona = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese el ID : " + id));

        repositorio.delete(persona);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
