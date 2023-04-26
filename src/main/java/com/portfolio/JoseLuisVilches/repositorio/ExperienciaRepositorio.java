
package com.portfolio.JoseLuisVilches.repositorio;

import com.portfolio.JoseLuisVilches.modelo.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepositorio extends JpaRepository<Experiencia, Long> {
    
}
