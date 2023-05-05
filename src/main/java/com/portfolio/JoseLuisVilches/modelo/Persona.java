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
@Table(name = "persona")
@Getter
@Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 3, max = 30, message = "no cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 3, max = 30, message = "no cumple con la longitud")
    private String apellido;
    
    @NotNull
    @Size(min = 5, max = 100, message = "no cumple con la longitud")
    private String imagen;
    
    @NotNull
    @Size(min = 3, max = 50, message = "no cumple con la longitud")
    private String puesto;
    
    @NotNull
    @Size(min = 3, max = 30, message = "no cumple con la longitud")
    private String compania;
    
    @NotNull
    @Size(min = 3, max = 100, message = "no cumple con la longitud")
    private String ubicacion;
    
    @NotNull
    @Size(min = 6, max = 20, message = "no cumple con la longitud")
    private String telefono;
    
    @NotNull
    @Size(min = 5, max = 50, message = "no cumple con la longitud")
    private String email;
    
    @NotNull
    @Size(min = 10, max = 100, message = "no cumple con la longitud")
    private String titulo_acerca_de;
    
    @NotNull
    @Size(min = 10, max = 500, message = "no cumple con la longitud")
    private String acerca_de;

    public Persona() {
    }

    public Persona(long id, String nombre, String apellido, String imagen, String puesto, String compania, String ubicacion, String telefono, String email, String titulo_acerca_de, String acerca_de) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
        this.puesto = puesto;
        this.compania = compania;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.email = email;
        this.titulo_acerca_de = titulo_acerca_de;
        this.acerca_de = acerca_de;
    }

}
