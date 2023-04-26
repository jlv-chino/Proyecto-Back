package com.portfolio.JoseLuisVilches.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
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
    Date tiempo_experiencia;

    public Experiencia() {
    }

    public Experiencia(long id, String puesto_experiencia, String compania_experiencia, String modalidad_experiencia, String imagen_experiencia, String inicio_experiencia, String fin_experiencia, Date tiempo_experiencia) {
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
