package com.portfolio.JoseLuisVilches.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @Size(min = 10, max = 50, message = "no cumple con la longitud")
    private String titulo_skill;
    
    @NotNull
    private int porcentaje_skill;

    public Skill() {
    }

    public Skill(long id, String titulo_skill, int porcentaje_skill) {
        this.id = id;
        this.titulo_skill = titulo_skill;
        this.porcentaje_skill = porcentaje_skill;
    }
    
}
