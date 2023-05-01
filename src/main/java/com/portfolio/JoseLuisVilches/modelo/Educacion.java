
package com.portfolio.JoseLuisVilches.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "educacion")
@Getter
@Setter
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String establecimiento_educacion;
    private String titulo_educacion;
    private String fin_educacion;
    private String imagen_educacion;

    public Educacion() {
    }

    public Educacion(long id, String establecimiento_educacion, String titulo_educacion, String fin_educacion, String imagen_educacion) {
        this.id = id;
        this.establecimiento_educacion = establecimiento_educacion;
        this.titulo_educacion = titulo_educacion;
        this.fin_educacion = fin_educacion;
        this.imagen_educacion = imagen_educacion;
    }
    
}
