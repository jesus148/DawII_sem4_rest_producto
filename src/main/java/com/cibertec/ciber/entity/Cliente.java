package com.cibertec.ciber.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {


    // CLASE GUIA CLIENTE CAMPOS = EN LA BD
    // si los atributos son = a la bd entonces no es nesecario relacionar 
    
    @Id
    @Column(name = "idcliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcliente;
    private String nombres;
    private String dni;



    // en la bd solo es fecha por eso es date 
    // si es fecha + hora +miniuto y segundo (ES EL TIME) Y SI ES COMPLETO ES EL TIMESTAMP
    // timezone = "America/Lima" : la fecha o la zona horaria puede cambiar por el lugar donde estas  
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Lima")
    private Date fechaNacimiento;


}