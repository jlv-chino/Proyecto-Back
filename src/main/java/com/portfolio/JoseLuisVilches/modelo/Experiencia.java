package com.portfolio.JoseLuisVilches.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "experiencia")
@Getter
@Setter
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String puesto_experiencia;
    String compania_experiencia;
    String modalidad_experiencia;
    String imagen_experiencia;
    String inicio_experiencia;
    String fin_experiencia;
    int tiempo_experiencia;

    public Experiencia() {
    }

    public Experiencia(long id, String puesto_experiencia, String compania_experiencia, String modalidad_experiencia, String imagen_experiencia, String inicio_experiencia, String fin_experiencia, int tiempo_experiencia) {
        this.id = id;
        this.puesto_experiencia = puesto_experiencia;
        this.compania_experiencia = compania_experiencia;
        this.modalidad_experiencia = modalidad_experiencia;
        this.imagen_experiencia = imagen_experiencia;
        this.inicio_experiencia = inicio_experiencia;
        this.fin_experiencia = fin_experiencia;
        this.tiempo_experiencia = tiempo_experiencia;
    }

}
