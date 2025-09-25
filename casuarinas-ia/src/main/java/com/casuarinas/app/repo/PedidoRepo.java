package com.casuarinas.app.repo;

import com.casuarinas.app.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

/**
 * INTERFAZ REPOSITORIO PEDIDO - PROGRAMACIÓN ORIENTADA A OBJETOS
 * 
 * Esta interfaz extiende JpaRepository para proporcionar operaciones CRUD automáticas.
 * Implementa el patrón Repository para el acceso a datos de pedidos.
 * 
 * RELACIÓN CON POO:
 * - Herencia: Extiende JpaRepository<Pedido, Long> (herencia de interfaces)
 * - Polimorfismo: Spring Data JPA implementa automáticamente esta interfaz
 * - Encapsulación: Oculta la complejidad del acceso a datos
 * - Patrón Repository: Abstrae la lógica de acceso a datos
 * - Métodos de consulta: Utilizan convenciones de nomenclatura (Query Method)
 * 
 * RELACIÓN CON SQL:
 * - Spring Data JPA traduce los nombres de métodos a consultas SQL automáticamente
 * - Genera implementaciones que ejecutan SQL contra la base de datos
 * - Maneja la conexión JDBC y el mapeo de resultados a objetos Java
 * - Optimiza las consultas SQL automáticamente
 * - Proporciona transacciones SQL automáticas
 */
public interface PedidoRepo extends JpaRepository<Pedido, Long> {
    /**
     * CONSULTA SQL GENERADA: SELECT * FROM pedido WHERE creado BETWEEN ? AND ?
     * Busca pedidos creados entre dos fechas específicas
     */
    List<Pedido> findByCreadoBetween(LocalDateTime inicio, LocalDateTime fin);
    
    /**
     * CONSULTA SQL GENERADA: SELECT * FROM pedido WHERE total >= ?
     * Busca pedidos con total mayor o igual al valor especificado
     */
    List<Pedido> findByTotalGreaterThanEqual(Double total);
    
    /**
     * CONSULTA SQL GENERADA: SELECT * FROM pedido WHERE nombre_cliente LIKE '%?%'
     * Busca pedidos por nombre de cliente (insensible a mayúsculas/minúsculas)
     */
    List<Pedido> findByNombreClienteContainingIgnoreCase(String nombreCliente);
    
    /**
     * CONSULTA SQL GENERADA: SELECT * FROM pedido WHERE localidad = ?
     * Busca pedidos por localidad específica
     */
    List<Pedido> findByLocalidad(String localidad);
    
    /**
     * CONSULTA SQL GENERADA: SELECT * FROM pedido WHERE nombre_cliente LIKE '%?%' AND localidad = ?
     * Busca pedidos por nombre de cliente y localidad (insensible a mayúsculas/minúsculas)
     */
    List<Pedido> findByNombreClienteContainingIgnoreCaseAndLocalidad(String nombreCliente, String localidad);
}
