
package com.portfolio.JoseLuisVilches.repositorio;

import com.portfolio.JoseLuisVilches.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Long>{

    //public Persona findBy(Long id);
    
}
