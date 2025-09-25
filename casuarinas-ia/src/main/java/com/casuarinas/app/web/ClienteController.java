package com.casuarinas.app.web;

import com.casuarinas.app.model.Cliente;
import com.casuarinas.app.repo.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * CONTROLADOR REST CLIENTE - PROGRAMACIÓN ORIENTADA A OBJETOS
 * 
 * Esta clase maneja las peticiones HTTP relacionadas con clientes.
 * Implementa el patrón MVC (Model-View-Controller) para la capa web.
 * 
 * RELACIÓN CON POO:
 * - @RestController: Convierte la clase en un controlador REST (patrón Controller)
 * - Inyección de dependencias: @Autowired inyecta ClienteRepo (patrón Dependency Injection)
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
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepo repo;

    @GetMapping
    public List<Cliente> getAll(@RequestParam(required = false) String localidad) {
        if (localidad != null && !localidad.isEmpty()) {
            return repo.findByLocalidad(localidad);
        } else {
            return repo.findAll();
        }
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return repo.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return repo.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
