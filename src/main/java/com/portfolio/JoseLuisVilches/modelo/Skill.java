package com.portfolio.JoseLuisVilches.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skill")
@Getter
@Setter
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo_skill;
    private int porcentaje_skill;

    public Skill() {
    }

    public Skill(long id, String titulo_skill, int porcentaje_skill) {
        this.id = id;
        this.titulo_skill = titulo_skill;
        this.porcentaje_skill = porcentaje_skill;
    }
    
}
