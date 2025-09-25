package com.casuarinas.app.web;

import com.casuarinas.app.model.Pedido;
import com.casuarinas.app.repo.PedidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * CONTROLADOR REST PEDIDO - PROGRAMACIÓN ORIENTADA A OBJETOS
 * 
 * Esta clase maneja las peticiones HTTP relacionadas con pedidos.
 * Implementa el patrón MVC (Model-View-Controller) para la capa web.
 * 
 * RELACIÓN CON POO:
 * - @RestController: Convierte la clase en un controlador REST (patrón Controller)
 * - Inyección de dependencias: @Autowired inyecta PedidoRepo (patrón Dependency Injection)
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
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoRepo repo;

    @GetMapping
    public List<Pedido> getAll(
        @RequestParam(required = false) String nombreCliente,
        @RequestParam(required = false) String localidad
    ) {
        if (nombreCliente != null && localidad != null && !nombreCliente.isEmpty() && !localidad.isEmpty()) {
            return repo.findByNombreClienteContainingIgnoreCaseAndLocalidad(nombreCliente, localidad);
        } else if (nombreCliente != null && !nombreCliente.isEmpty()) {
            return repo.findByNombreClienteContainingIgnoreCase(nombreCliente);
        } else if (localidad != null && !localidad.isEmpty()) {
            return repo.findByLocalidad(localidad);
        } else {
            return repo.findAll();
        }
    }

    @GetMapping("/{id}")
    public Optional<Pedido> getById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) {
        if (pedido.getCreado() == null) {
            pedido.setCreado(LocalDateTime.now());
        }
        return repo.save(pedido);
    }

    @PutMapping("/{id}")
    public Pedido update(@PathVariable Long id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        return repo.save(pedido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @GetMapping("/fecha")
    public List<Pedido> filtrarPorFecha(@RequestParam String fechaInicio, @RequestParam String fechaFin) {
        LocalDateTime inicio = LocalDateTime.parse(fechaInicio);
        LocalDateTime fin = LocalDateTime.parse(fechaFin);
        return repo.findByCreadoBetween(inicio, fin);
    }

    @GetMapping("/total")
    public List<Pedido> filtrarPorTotal(@RequestParam Double total) {
        return repo.findByTotalGreaterThanEqual(total);
    }
}
