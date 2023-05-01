
package com.portfolio.JoseLuisVilches.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proyecto")
@Getter
@Setter
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nombre_proyecto;
    private String url_repositorio;
    private String url_deploy;
    private String descripcion_proyecto;
    private String imagen_proyecto;

    public Proyecto() {
    }

    public Proyecto(long id, String nombre_proyecto, String url_repositorio, String url_deploy, String descripcion_proyecto, String imagen_proyecto) {
        this.id = id;
        this.nombre_proyecto = nombre_proyecto;
        this.url_repositorio = url_repositorio;
        this.url_deploy = url_deploy;
        this.descripcion_proyecto = descripcion_proyecto;
        this.imagen_proyecto = imagen_proyecto;
    }
    
}
