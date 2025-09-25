package com.casuarinas.app.model;

import jakarta.persistence.*;

/**
 * CLASE ENTIDAD CLIENTE - PROGRAMACIÓN ORIENTADA A OBJETOS
 * 
 * Esta clase representa un cliente en el sistema de gestión.
 * Implementa el patrón de mapeo objeto-relacional (ORM) usando JPA.
 * 
 * RELACIÓN CON POO:
 * - @Entity: Convierte la clase en una entidad persistente (patrón Active Record)
 * - Encapsulación: Campos privados con getters/setters públicos
 * - Constructor: Permite crear instancias con diferentes parámetros (sobrecarga)
 * - Representa un concepto del dominio de negocio (patrón Domain Model)
 * - Getters/Setters: Implementan el patrón de acceso controlado a datos
 * 
 * RELACIÓN CON SQL:
 * - @Entity: Genera automáticamente una tabla SQL llamada "CLIENTE"
 * - @Id + @GeneratedValue: Crea una columna ID auto-incremental en SQL
 * - Cada campo privado se mapea a una columna en la tabla SQL
 * - Hibernate genera automáticamente las consultas SQL (INSERT, UPDATE, DELETE, SELECT)
 * - La localidad se almacena como un valor de texto en la base de datos
 */
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String localidad; // Pocitos, Carrasco, Solymar/La Tahona

    public Cliente() {}
    public Cliente(Long id, String nombre, String telefono, String direccion, String localidad) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.localidad = localidad;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getLocalidad() { return localidad; }
    public void setLocalidad(String localidad) { this.localidad = localidad; }
}
