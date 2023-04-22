package com.portfolio.JoseLuisVilches.repositorio;

import com.portfolio.JoseLuisVilches.modelo.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepositorio extends JpaRepository<Skill, Long>{
    
}
