package com.casuarinas.app.boot;

import com.casuarinas.app.model.Producto;
import com.casuarinas.app.repo.ProductoRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * COMPONENTE DE INICIALIZACIÓN - PROGRAMACIÓN ORIENTADA A OBJETOS
 * 
 * Esta clase implementa CommandLineRunner para ejecutar código al iniciar la aplicación.
 * Se encarga de cargar datos iniciales en la base de datos si esta está vacía.
 * 
 * RELACIÓN CON POO:
 * - @Component: Convierte la clase en un componente gestionado por Spring (patrón Component)
 * - CommandLineRunner: Implementa una interfaz para ejecutar código al inicio (patrón Strategy)
 * - Inyección de dependencias: @Autowired inyecta ProductoRepo (patrón Dependency Injection)
 * - Encapsulación: Lógica de inicialización encapsulada en un método específico
 * - Separación de responsabilidades: Solo se encarga de la inicialización de datos
 * 
 * RELACIÓN CON SQL:
 * - productoRepo.count(): Ejecuta consulta SQL SELECT COUNT(*) FROM producto
 * - productoRepo.save(): Ejecuta consultas SQL INSERT para cada producto
 * - Verifica si la base de datos está vacía antes de insertar datos
 * - Cada save() genera una transacción SQL automática
 */
@Component // ANOTACIÓN SPRING: Indica que esta clase es un componente de Spring
public class DataLoader implements CommandLineRunner {
    
    // INYECCIÓN DE DEPENDENCIAS - POO + SPRING
    @Autowired // ANOTACIÓN SPRING: Inyecta automáticamente la dependencia
    private ProductoRepo productoRepo;

    /**
     * MÉTODO DE INICIALIZACIÓN - POO
     * Se ejecuta automáticamente al iniciar la aplicación
     */
    @Override
    public void run(String... args) {
        // LÓGICA DE NEGOCIO - POO
        if(productoRepo.count() == 0) {
            // CONSULTA SQL: INSERT INTO producto (nombre, precio, comentario, categoria, unidad, activo, creado, actualizado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            // Huevos
            productoRepo.save(new Producto("Huevos 12", 220.0, "Tamaño 12", "Huevos", "docena"));
            productoRepo.save(new Producto("Huevos 15", 250.0, "Tamaño 15", "Huevos", "docena"));
            productoRepo.save(new Producto("Huevos 24", 360.0, "Tamaño 24", "Huevos", "docena"));
            productoRepo.save(new Producto("Huevos 30", 390.0, "Tamaño 30", "Huevos", "docena"));
            
            // Lácteos
            productoRepo.save(new Producto("Yogur griego 550mL", 310.0, "1 unidad 550mL", "Lácteos", "unidad"));
            productoRepo.save(new Producto("Queso Llanero 400g", 180.0, "Llanero", "Quesos", "400g"));
            productoRepo.save(new Producto("Queso Parmesano 400g", 310.0, "Parmesano", "Quesos", "400g"));
            productoRepo.save(new Producto("Queso Ricotta 400g", 75.0, "Ricotta", "Quesos", "400g"));
            productoRepo.save(new Producto("Queso Dambo 400g", 230.0, "Dambo", "Quesos", "400g"));
            productoRepo.save(new Producto("Queso Colonia 400g", 250.0, "Colonia", "Quesos", "400g"));
            productoRepo.save(new Producto("Queso Parrillero 400g", 280.0, "Parrillero", "Quesos", "400g"));
            
            // Miel
            productoRepo.save(new Producto("Miel", 330.0, "1kg", "Miel", "1kg"));
        }
    }
}
