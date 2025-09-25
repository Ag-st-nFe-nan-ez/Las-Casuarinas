package com.casuarinas.app.model;

import jakarta.persistence.*;

/**
 * CLASE ENTIDAD QUESO COLONIA - PROGRAMACIÓN ORIENTADA A OBJETOS
 * 
 * Esta clase representa un producto específico de queso colonia en el sistema.
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
 * - @Entity + @Table: Genera una tabla SQL llamada "queso_colonia"
 * - @Id + @GeneratedValue: Crea una columna ID auto-incremental en SQL
 * - Cada campo privado se mapea a una columna en la tabla SQL
 * - Los valores por defecto se establecen al crear registros en la base de datos
 * - Hibernate genera automáticamente las consultas SQL (INSERT, UPDATE, DELETE, SELECT)
 */
@Entity
@Table(name = "queso_colonia")
public class QuesoColonia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre = "Queso Colonia 400g";
    private Double precio = 250.0;
    private Integer stock = 5;
    private String comentario = "Colonia";
    private String categoria = "Quesos";
    private String unidad = "400g";
    private Boolean activo = true;

    public QuesoColonia() {}

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
