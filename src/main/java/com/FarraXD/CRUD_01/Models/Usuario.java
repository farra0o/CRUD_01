package com.FarraXD.CRUD_01.Models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Usuarios")
@ToString  @EqualsAndHashCode
public class Usuario {
    @Getter @Setter @Column(name = "Id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long ID ;

    @Getter @Setter @Column (name = "Nombre")
    private  String Nombre;

    @Getter @Setter @Column (name = "Apellido")
    private  String Apellido;

    @Getter @Setter @Column (name = "Email")
    private  String Email;

    @Getter @Setter @Column (name = "Contraseña")
    private  String Contrasena;

    @Getter @Setter @Column (name = "Telefono")
    private  String Telefono;


}
