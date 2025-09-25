package com.casuarinas.app.model;

import jakarta.persistence.*;

/**
 * CLASE ENTIDAD HUEVOS 24 - PROGRAMACIÓN ORIENTADA A OBJETOS
 * 
 * Esta clase representa un producto específico de huevos tamaño 24 en el sistema.
 * Implementa el patrón de mapeo objeto-relacional (ORM) usando JPA.
 * Es una especialización de producto con valores predefinidos.
 * 
 * RELACIÓN CON POO:
 * - @Entity: Convierte la clase en una entidad persistente (patrón Active Record)
 * - @Table: Especifica el nombre de la tabla SQL (personalización del mapeo)
 * - Encapsulación: Campos privados con getters/setters públicos
 * - Valores por defecto: Inicialización de campos con valores específicos (patrón Builder implícito)
 * - Representa un concepto específico del dominio de negocio (patrón Domain Model)
 * - Especialización: Clase específica para un tipo de producto
 * 
 * RELACIÓN CON SQL:
 * - @Entity + @Table: Genera una tabla SQL llamada "huevos_24"
 * - @Id + @GeneratedValue: Crea una columna ID auto-incremental en SQL
 * - Cada campo privado se mapea a una columna en la tabla SQL
 * - Los valores por defecto se establecen al crear registros en la base de datos
 * - Hibernate genera automáticamente las consultas SQL (INSERT, UPDATE, DELETE, SELECT)
 */
@Entity
@Table(name = "huevos_24")
public class Huevos24 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre = "Huevos 24";
    private Double precio = 360.0;
    private Integer stock = 25;
    private String comentario = "Tamaño 24";
    private String categoria = "Huevos";
    private String unidad = "docena";
    private Boolean activo = true;

    public Huevos24() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    
    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }
    
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}
