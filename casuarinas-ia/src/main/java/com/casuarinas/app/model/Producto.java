package com.casuarinas.app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * CLASE ENTIDAD PRODUCTO - PROGRAMACIÓN ORIENTADA A OBJETOS
 * 
 * Esta clase representa un producto en el sistema de gestión.
 * Implementa el patrón de mapeo objeto-relacional (ORM) usando JPA.
 * 
 * RELACIÓN CON POO:
 * - @Entity: Convierte la clase en una entidad persistente (patrón Active Record)
 * - Encapsulación: Campos privados con getters/setters públicos
 * - Constructor: Inicializa valores por defecto (patrón Builder implícito)
 * - @PreUpdate: Método de callback que se ejecuta antes de actualizar (patrón Observer)
 * - Representa un concepto del dominio de negocio (patrón Domain Model)
 * 
 * RELACIÓN CON SQL:
 * - @Entity: Genera automáticamente una tabla SQL llamada "PRODUCTO"
 * - @Id + @GeneratedValue: Crea una columna ID auto-incremental en SQL
 * - Cada campo privado se mapea a una columna en la tabla SQL
 * - @PreUpdate: Se ejecuta antes de un UPDATE SQL
 * - Hibernate genera automáticamente las consultas SQL (INSERT, UPDATE, DELETE, SELECT)
 */
@Entity // ANOTACIÓN JPA: Indica que esta clase es una entidad de base de datos
public class Producto {
    
    // CAMPOS PRIVADOS - ENCAPSULACIÓN (POO)
    @Id // ANOTACIÓN JPA: Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ANOTACIÓN JPA: Auto-incremento en SQL
    private Long id;
    
    private String nombre;
    private Double precio;
    private String comentario;
    private String categoria;
    private String unidad;
    private Boolean activo;
    private LocalDateTime creado;
    private LocalDateTime actualizado;

    // CONSTRUCTOR POR DEFECTO - POO
    public Producto() {
        this.activo = true;
        this.creado = LocalDateTime.now();
        this.actualizado = LocalDateTime.now();
    }
    
    // CONSTRUCTOR CON PARÁMETROS - SOBRECARGA DE MÉTODOS (POO)
    public Producto(String nombre, Double precio, String comentario, String categoria, String unidad) {
        this(); // Llamada al constructor por defecto
        this.nombre = nombre;
        this.precio = precio;
        this.comentario = comentario;
        this.categoria = categoria;
        this.unidad = unidad;
    }

    // MÉTODO DE CICLO DE VIDA - POO + JPA
    @PreUpdate // ANOTACIÓN JPA: Se ejecuta antes de actualizar en la base de datos
    public void preUpdate() {
        this.actualizado = LocalDateTime.now();
    }

    // MÉTODOS GETTER Y SETTER - ENCAPSULACIÓN (POO)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    
    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }
    
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    
    public LocalDateTime getCreado() { return creado; }
    public void setCreado(LocalDateTime creado) { this.creado = creado; }
    
    public LocalDateTime getActualizado() { return actualizado; }
    public void setActualizado(LocalDateTime actualizado) { this.actualizado = actualizado; }
}
