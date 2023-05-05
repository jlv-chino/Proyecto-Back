
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
@Table(name = "educacion")
@Getter
@Setter
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 2, max = 50, message = "no cumple con la longitud")
    private String establecimiento_educacion;
    
    @NotNull
    @Size(min = 2, max = 50, message = "no cumple con la longitud")
    private String titulo_educacion;
    
    @NotNull
    @Size(max = 10, message = "no cumple con la longitud")
    private String fin_educacion;
    
    @NotNull
    @Size(min = 5, max = 100, message = "no cumple con la longitud")
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
