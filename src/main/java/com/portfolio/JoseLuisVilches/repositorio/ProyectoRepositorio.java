
package com.portfolio.JoseLuisVilches.repositorio;

import com.portfolio.JoseLuisVilches.modelo.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepositorio extends JpaRepository<Proyecto, Long> {
    
}
