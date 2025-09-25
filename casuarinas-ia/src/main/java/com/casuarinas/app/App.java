package com.casuarinas.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * CLASE PRINCIPAL DE LA APLICACIÓN - PROGRAMACIÓN ORIENTADA A OBJETOS
 * 
 * Esta clase representa el punto de entrada de la aplicación Spring Boot.
 * 
 * RELACIÓN CON POO:
 * - @SpringBootApplication: Anotación que implementa el patrón de configuración automática (POO)
 * - Encapsula toda la configuración de la aplicación en una sola anotación
 * - Utiliza reflexión para escanear y configurar automáticamente los componentes
 * - Implementa el patrón Singleton para el contexto de la aplicación
 * 
 * RELACIÓN CON SQL:
 * - Spring Boot configura automáticamente la conexión a la base de datos H2
 * - Habilita JPA para mapeo objeto-relacional
 * - Configura el pool de conexiones SQL automáticamente
 * - Inicializa las tablas SQL basadas en las entidades JPA
 */
@SpringBootApplication
public class App {
    
    /**
     * MÉTODO MAIN - PUNTO DE ENTRADA DE LA APLICACIÓN (POO)
     * 
     * Este método inicia la aplicación Spring Boot.
     * 
     * RELACIÓN CON POO:
     * - Método estático que actúa como punto de entrada (patrón Factory)
     * - SpringApplication.run() crea e inicializa el contexto de la aplicación
     * - Utiliza inyección de dependencias para configurar todos los componentes
     * 
     * RELACIÓN CON SQL:
     * - Al iniciar, Spring Boot configura automáticamente la base de datos
     * - Crea las tablas SQL basadas en las entidades @Entity
     * - Establece la conexión JDBC con la base de datos H2
     * - Ejecuta scripts de inicialización de datos si existen
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
