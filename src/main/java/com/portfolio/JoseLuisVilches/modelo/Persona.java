package com.portfolio.JoseLuisVilches.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

    private String nombre;
    private String apellido;
    private String imagen;
    private String puesto;
    private String compania;
    private String ubicacion;
    private String telefono;
    private String email;
    private String titulo_acerca_de;
    private String acerca_de;
    private String user;
    private String password;

    public Persona() {
    }

    public Persona(long id, String nombre, String apellido, String imagen, String puesto, String compania, String ubicacion, String telefono, String email, String titulo_acerca_de, String acerca_de, String user, String password) {
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
        this.user = user;
        this.password = password;
    }

}
