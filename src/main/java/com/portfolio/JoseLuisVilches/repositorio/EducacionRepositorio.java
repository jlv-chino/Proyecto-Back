
package com.portfolio.JoseLuisVilches.repositorio;

import com.portfolio.JoseLuisVilches.modelo.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepositorio extends JpaRepository<Educacion, Long> {
    
}
