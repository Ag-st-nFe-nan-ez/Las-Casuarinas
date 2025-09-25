package com.casuarinas.app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * CLASE ENTIDAD PEDIDO - PROGRAMACIÓN ORIENTADA A OBJETOS
 * 
 * Esta clase representa un pedido en el sistema de gestión.
 * Implementa el patrón de mapeo objeto-relacional (ORM) usando JPA.
 * 
 * RELACIÓN CON POO:
 * - @Entity: Convierte la clase en una entidad persistente (patrón Active Record)
 * - Encapsulación: Campos privados con getters/setters públicos
 * - Constructor: Permite crear instancias con diferentes parámetros (sobrecarga)
 * - Representa un concepto del dominio de negocio (patrón Domain Model)
 * - @Lob: Maneja datos grandes como objetos (patrón Value Object)
 * 
 * RELACIÓN CON SQL:
 * - @Entity: Genera automáticamente una tabla SQL llamada "PEDIDO"
 * - @Id + @GeneratedValue: Crea una columna ID auto-incremental en SQL
 * - @Lob: Mapea a un campo CLOB/TEXT en SQL para almacenar JSON
 * - Cada campo privado se mapea a una columna en la tabla SQL
 * - Hibernate genera automáticamente las consultas SQL (INSERT, UPDATE, DELETE, SELECT)
 * - El campo itemsJson almacena el carrito como JSON en la base de datos
 */
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCliente;
    private String telefono;
    private String direccion;
    private String localidad;
    @Lob
    private String itemsJson;
    private Double total;
    private String ubicacion;
    private LocalDateTime creado;

    public Pedido() {}
    
    public Pedido(Long id, String nombreCliente, String telefono, String direccion, String localidad, 
                  String itemsJson, Double total, String ubicacion, LocalDateTime creado) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.localidad = localidad;
        this.itemsJson = itemsJson;
        this.total = total;
        this.ubicacion = ubicacion;
        this.creado = creado;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getLocalidad() { return localidad; }
    public void setLocalidad(String localidad) { this.localidad = localidad; }
    
    public String getItemsJson() { return itemsJson; }
    public void setItemsJson(String itemsJson) { this.itemsJson = itemsJson; }
    
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
    
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    
    public LocalDateTime getCreado() { return creado; }
    public void setCreado(LocalDateTime creado) { this.creado = creado; }
}
