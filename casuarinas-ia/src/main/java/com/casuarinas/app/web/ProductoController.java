package com.casuarinas.app.web;

import com.casuarinas.app.model.Producto;
import com.casuarinas.app.repo.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * CONTROLADOR REST PRODUCTO - PROGRAMACIÓN ORIENTADA A OBJETOS
 * 
 * Esta clase maneja las peticiones HTTP relacionadas con productos.
 * Implementa el patrón MVC (Model-View-Controller) para la capa web.
 * 
 * RELACIÓN CON POO:
 * - @RestController: Convierte la clase en un controlador REST (patrón Controller)
 * - Inyección de dependencias: @Autowired inyecta ProductoRepo (patrón Dependency Injection)
 * - Encapsulación: Métodos privados para lógica interna, públicos para endpoints
 * - Polimorfismo: Implementa la interfaz de controlador REST de Spring
 * - Separación de responsabilidades: Solo maneja peticiones HTTP, delega lógica de negocio
 * 
 * RELACIÓN CON SQL:
 * - Cada endpoint ejecuta consultas SQL a través del repositorio
 * - @GetMapping: Genera consultas SELECT SQL
 * - @PostMapping: Genera consultas INSERT SQL
 * - @PutMapping: Genera consultas UPDATE SQL
 * - @DeleteMapping: Genera consultas DELETE SQL
 * - Los filtros se traducen a cláusulas WHERE en SQL
 */
@RestController // ANOTACIÓN SPRING: Indica que esta clase es un controlador REST
@RequestMapping("/api/productos") // ANOTACIÓN SPRING: Define la ruta base para todas las operaciones
public class ProductoController {
    
    // INYECCIÓN DE DEPENDENCIAS - POO + SPRING
    @Autowired // ANOTACIÓN SPRING: Inyecta automáticamente la dependencia
    private ProductoRepo repo;

    /**
     * MÉTODO GET - OPERACIÓN CRUD (READ)
     * Maneja peticiones GET a /api/productos
     * Puede filtrar por nombre y/o categoría
     */
    @GetMapping // ANOTACIÓN SPRING: Mapea peticiones GET
    public List<Producto> getAll(
        @RequestParam(required = false) String nombre, // PARÁMETRO OPCIONAL
        @RequestParam(required = false) String categoria // PARÁMETRO OPCIONAL
    ) {
        // LÓGICA DE NEGOCIO - POO
        if (nombre != null && !nombre.isEmpty() && categoria != null && !categoria.isEmpty()) {
            // CONSULTA SQL: SELECT * FROM producto WHERE nombre LIKE '%?%' AND categoria = ? AND activo = true
            return repo.findByNombreContainingIgnoreCaseAndCategoriaAndActivoTrue(nombre, categoria);
        } else if (nombre != null && !nombre.isEmpty()) {
            // CONSULTA SQL: SELECT * FROM producto WHERE nombre LIKE '%?%' AND activo = true
            return repo.findByNombreContainingIgnoreCaseAndActivoTrue(nombre);
        } else if (categoria != null && !categoria.isEmpty()) {
            // CONSULTA SQL: SELECT * FROM producto WHERE categoria = ? AND activo = true
            return repo.findByCategoriaAndActivoTrue(categoria);
        } else {
            // CONSULTA SQL: SELECT * FROM producto WHERE activo = true
            return repo.findByActivoTrue();
        }
    }

    /**
     * MÉTODO GET POR ID - OPERACIÓN CRUD (READ)
     * Maneja peticiones GET a /api/productos/{id}
     */
    @GetMapping("/{id}") // ANOTACIÓN SPRING: Mapea peticiones GET con parámetro de ruta
    public Optional<Producto> getById(@PathVariable Long id) { // PARÁMETRO DE RUTA
        // CONSULTA SQL: SELECT * FROM producto WHERE id = ?
        return repo.findById(id);
    }

    /**
     * MÉTODO POST - OPERACIÓN CRUD (CREATE)
     * Maneja peticiones POST a /api/productos
     */
    @PostMapping // ANOTACIÓN SPRING: Mapea peticiones POST
    public Producto create(@RequestBody Producto producto) { // PARÁMETRO DEL CUERPO DE LA PETICIÓN
        // CONSULTA SQL: INSERT INTO producto (nombre, precio, comentario, categoria, unidad, activo, creado, actualizado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        return repo.save(producto);
    }

    /**
     * MÉTODO PUT - OPERACIÓN CRUD (UPDATE)
     * Maneja peticiones PUT a /api/productos/{id}
     */
    @PutMapping("/{id}") // ANOTACIÓN SPRING: Mapea peticiones PUT con parámetro de ruta
    public Producto update(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id);
        // CONSULTA SQL: UPDATE producto SET nombre = ?, precio = ?, comentario = ?, categoria = ?, unidad = ?, activo = ?, actualizado = ? WHERE id = ?
        return repo.save(producto);
    }

    /**
     * MÉTODO DELETE - OPERACIÓN CRUD (DELETE)
     * Maneja peticiones DELETE a /api/productos/{id}
     */
    @DeleteMapping("/{id}") // ANOTACIÓN SPRING: Mapea peticiones DELETE con parámetro de ruta
    public void delete(@PathVariable Long id) {
        // CONSULTA SQL: DELETE FROM producto WHERE id = ?
        repo.deleteById(id);
    }

    /**
     * MÉTODO GET ESPECÍFICO - FILTRO POR NOMBRE
     * Maneja peticiones GET a /api/productos/buscar
     */
    @GetMapping("/buscar") // ANOTACIÓN SPRING: Mapea peticiones GET con ruta específica
    public List<Producto> buscarPorNombre(@RequestParam String nombre) {
        // CONSULTA SQL: SELECT * FROM producto WHERE nombre LIKE '%?%' AND activo = true
        return repo.findByNombreContainingIgnoreCaseAndActivoTrue(nombre);
    }

    /**
     * MÉTODO GET ESPECÍFICO - FILTRO POR CATEGORÍA
     * Maneja peticiones GET a /api/productos/categoria
     */
    @GetMapping("/categoria") // ANOTACIÓN SPRING: Mapea peticiones GET con ruta específica
    public List<Producto> filtrarPorCategoria(@RequestParam String categoria) {
        // CONSULTA SQL: SELECT * FROM producto WHERE categoria = ? AND activo = true
        return repo.findByCategoriaAndActivoTrue(categoria);
    }

    /**
     * MÉTODO GET ESPECÍFICO - PRODUCTOS ACTIVOS
     * Maneja peticiones GET a /api/productos/activos
     */
    @GetMapping("/activos") // ANOTACIÓN SPRING: Mapea peticiones GET con ruta específica
    public List<Producto> getProductosActivos() {
        // CONSULTA SQL: SELECT * FROM producto WHERE activo = true
        return repo.findByActivoTrue();
    }

    /**
     * MÉTODO GET ESPECÍFICO - TODOS LOS PRODUCTOS (ADMIN)
     * Maneja peticiones GET a /api/productos/admin
     * Devuelve todos los productos (activos e inactivos) para el panel de administración
     */
    @GetMapping("/admin") // ANOTACIÓN SPRING: Mapea peticiones GET con ruta específica
    public List<Producto> getAllForAdmin() {
        // CONSULTA SQL: SELECT * FROM producto (sin filtro de activo)
        return repo.findAll();
    }
}
