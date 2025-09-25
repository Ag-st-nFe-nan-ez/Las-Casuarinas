package com.casuarinas.app.repo;

import com.casuarinas.app.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * INTERFAZ REPOSITORIO CLIENTE - PROGRAMACIÓN ORIENTADA A OBJETOS
 * 
 * Esta interfaz extiende JpaRepository para proporcionar operaciones CRUD automáticas.
 * Implementa el patrón Repository para el acceso a datos de clientes.
 * 
 * RELACIÓN CON POO:
 * - Herencia: Extiende JpaRepository<Cliente, Long> (herencia de interfaces)
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
public interface ClienteRepo extends JpaRepository<Cliente, Long> {
    
    /**
     * CONSULTA SQL GENERADA: SELECT * FROM cliente WHERE localidad = ?
     * Busca clientes por localidad específica
     */
    java.util.List<Cliente> findByLocalidad(String localidad);
}
