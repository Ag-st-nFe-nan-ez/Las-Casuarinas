package com.casuarinas.app.repo;

import com.casuarinas.app.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * INTERFAZ REPOSITORIO PRODUCTO - PROGRAMACIÓN ORIENTADA A OBJETOS
 * 
 * Esta interfaz extiende JpaRepository para proporcionar operaciones CRUD automáticas.
 * Implementa el patrón Repository para el acceso a datos de productos.
 * 
 * RELACIÓN CON POO:
 * - Herencia: Extiende JpaRepository<Producto, Long> (herencia de interfaces)
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
public interface ProductoRepo extends JpaRepository<Producto, Long> {
    
    // MÉTODOS DE CONSULTA - SPRING DATA JPA GENERA SQL AUTOMÁTICAMENTE
    // El nombre del método se traduce a consultas SQL automáticamente
    
    /**
     * CONSULTA SQL GENERADA: SELECT * FROM producto WHERE nombre LIKE '%?%'
     * Busca productos por nombre (insensible a mayúsculas/minúsculas)
     */
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    
    /**
     * CONSULTA SQL GENERADA: SELECT * FROM producto WHERE categoria = ?
     * Busca productos por categoría
     */
    List<Producto> findByCategoria(String categoria);
    
    /**
     * CONSULTA SQL GENERADA: SELECT * FROM producto WHERE activo = true
     * Busca todos los productos activos
     */
    List<Producto> findByActivoTrue();
    
    /**
     * CONSULTA SQL GENERADA: SELECT * FROM producto WHERE nombre LIKE '%?%' AND activo = true
     * Busca productos por nombre (insensible a mayúsculas/minúsculas) que estén activos
     */
    List<Producto> findByNombreContainingIgnoreCaseAndActivoTrue(String nombre);
    
    /**
     * CONSULTA SQL GENERADA: SELECT * FROM producto WHERE categoria = ? AND activo = true
     * Busca productos por categoría que estén activos
     */
    List<Producto> findByCategoriaAndActivoTrue(String categoria);
    
    /**
     * CONSULTA SQL GENERADA: SELECT * FROM producto WHERE nombre LIKE '%?%' AND categoria = ? AND activo = true
     * Busca productos por nombre y categoría que estén activos
     */
    List<Producto> findByNombreContainingIgnoreCaseAndCategoriaAndActivoTrue(String nombre, String categoria);
}
