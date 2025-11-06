package controlador;

import modelo.Bodega;
import modelo.Producto;
import vista.Consola;



// Controlador principal que conecta la vista y el modelo del sistema de inventario.
public class ControladorInventario {
    private final Bodega bodega; // Modelo: almacena productos y stock
    private final Consola vista; // Vista: interfaz con el usuario

     // Constructor: recibe modelo y vista, y configura los eventos de la interfaz
    public ControladorInventario(Bodega bodega, Consola vista) {
        this.bodega = bodega;
        this.vista = vista;
        configurarListeners();
        System.out.println("---  GESTIÓN DE INVENTARIO---");
        System.out.println("Los resultados se mostrarán en esta terminal\n");
    }

     // Asocia los botones de la vista con los métodos del controlador
    private void configurarListeners() {
        vista.setAgregarProductoListener(e -> agregarProducto());
        vista.setAgregarStockListener(e -> agregarStock());
        vista.setRestarStockListener(e -> restarStock());
        vista.setReporteInventarioListener(e -> generarReporteInventario());
        vista.setSalirListener(e -> {
            System.out.println("--- SISTEMA APAGADO ---");
            System.exit(0);
        });
    }
    
         // Agrega un producto nuevo o suma stock si ya existe
    private void agregarProducto() {
        System.out.println("\n--- AGREGAR PRODUCTO ---");
        // Solicita el nombre del producto al usuario
        String nombre = vista.mostrarInputDialog("Ingrese el nombre del producto:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            // Solicita el stock inicial
            int stock = vista.mostrarInputDialogEntero("Ingrese el stock inicial:");
            if (stock >= 0) {
                // Busca si el producto ya existe en la bodega
                Producto productoExistente = bodega.buscarProducto(nombre);
                if (productoExistente != null) {
                    // Si existe, suma el stock ingresado al stock actual
                    int stockAnterior = productoExistente.getStock();
                    bodega.agregarStock(nombre, stock);
                    int stockNuevo = productoExistente.getStock();
                    System.out.println(" Producto '" + nombre + "' ya existía. Stock actualizado:");
                    System.out.println(" Stock anterior: " + stockAnterior);
                    System.out.println(" Stock agregado: " + stock);
                    System.out.println(" Stock nuevo: " + stockNuevo);
                } else {
                    // Si no existe, crea un nuevo producto y lo agrega a la bodega
                    bodega.agregarProducto(nombre, stock);
                    System.out.println(" Nuevo producto '" + nombre + "' agregado con stock inicial: " + stock);
                }
            } else {
                // El stock ingresado es negativo
                System.out.println(" Error: El stock no puede ser negativo");
            }
        } else {
            // El nombre ingresado está vacío o es nulo
            System.out.println(" Error: El nombre del producto no puede estar vacío");
        }
    }
    
    // Suma stock a un producto existente, validando nombre y cantidad
    private void agregarStock() {
        System.out.println("\n--- AGREGAR STOCK ---");
        // Solicita el nombre del producto al usuario
        String nombre = vista.mostrarInputDialog("Ingresar el nombre del producto:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            // Solicita la cantidad de stock a agregar
            int cantidad = vista.mostrarInputDialogEntero("Ingrese la cantidad a agregar:");
            if (cantidad > 0) {
                // Intenta agregar el stock al producto
                boolean exito = bodega.agregarStock(nombre, cantidad);
                if (exito) {
                    // Si el producto existe, muestra mensaje de éxito y el stock actual
                    System.out.println(" Stock agregado: " + cantidad + " unidades a '" + nombre + "'");
                    Producto producto = bodega.buscarProducto(nombre);
                    if (producto != null) {
                        System.out.println(" Stock actual: " + producto.getStock());
                    }
                } else {
                    // Si el producto no existe, muestra mensaje de error
                    System.out.println(" Error: Producto '" + nombre + "' no encontrado");
                }
            } else {
                // La cantidad ingresada no es válida
                System.out.println(" Error: La cantidad debe ser mayor a 0");
            }
        }
    }
    
    // Resta stock a un producto, validando existencia y cantidad suficiente
    private void restarStock() {
        System.out.println("\n--- RESTAR STOCK ---");
        // Solicita el nombre del producto al usuario
        String nombre = vista.mostrarInputDialog("Ingrese el nombre del producto:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            // Solicita la cantidad de stock a restar
            int cantidad = vista.mostrarInputDialogEntero("Ingrese la cantidad a restar:");
            if (cantidad > 0) {
                // Intenta restar el stock al producto
                boolean exito = bodega.restarStock(nombre, cantidad);
                if (exito) {
                    // Si el producto existe y hay suficiente stock, muestra mensaje de éxito y el stock actual
                    System.out.println(" Stock restado: " + cantidad + " unidades de '" + nombre + "'");
                    Producto producto = bodega.buscarProducto(nombre);
                    if (producto != null) {
                        System.out.println(" Stock actual: " + producto.getStock());
                    }
                } else {
                    // Si el producto no existe o no hay suficiente stock, muestra mensaje de error detallando posibles causas
                    System.out.println(" Error: No se pudo restar stock. Verifique:");
                    System.out.println(" - Que el producto exista");
                    System.out.println(" - Que haya suficiente stock disponible");
                }
            } else {
                // La cantidad ingresada no es válida
                System.out.println(" Error: La cantidad debe ser mayor a 0");
            }
        }
    }
    
    // Muestra en consola el reporte completo del inventario
    private void generarReporteInventario() {
        System.out.println("\n" + bodega.generarReporteInventario());
    }
}