package modelo;

import java.util.ArrayList;

/**
 * Clase Bodega: gestiona el inventario de productos usando un ArrayList.
 * Permite agregar, buscar, modificar stock y generar reportes del inventario.
 */
public class Bodega {
    // Colección principal que almacena los productos
    private final ArrayList<Producto> inventario;

    // Constructor: inicializa la lista vacía de productos
    public Bodega() {
        this.inventario = new ArrayList<>();
    }

    /**
     * Agrega un nuevo producto al inventario.
     * @param nombre Nombre del producto
     * @param stockInicial Stock inicial del producto
     */
    public void agregarProducto(String nombre, int stockInicial) {
        Producto nuevoProducto = new Producto(nombre, stockInicial);
        inventario.add(nuevoProducto);
    }

    /**
     * Devuelve una copia de la lista de productos.
     */
    public ArrayList<Producto> listarProductos() {
        return new ArrayList<>(inventario);
    }



    /**
     * Suma stock a un producto existente.
     * @param nombreProducto Nombre del producto
     * @param cantidad Cantidad a agregar
     * @return true si se agregó stock, false si no se encontró el producto
     */
    public boolean agregarStock(String nombreProducto, int cantidad) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                producto.setStock(producto.getStock() + cantidad);
                return true;
            }
        }
        return false;
    }



    /**
     * Resta stock a un producto si hay suficiente cantidad.
     * @param nombreProducto Nombre del producto
     * @param cantidad Cantidad a restar
     * @return true si se restó stock, false si no hay suficiente o no existe
     */
    public boolean restarStock(String nombreProducto, int cantidad) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                if (producto.getStock() >= cantidad) {
                    producto.setStock(producto.getStock() - cantidad);
                    return true;
                }
                return false;
            }
        }
        return false;
    }



    /**
     * Genera un reporte de todo el inventario usando un iterador.
     * @return String con el listado de productos y su stock
     */
    public String generarReporteInventario() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== REPORTE DE INVENTARIO TOTAL ===\n");

        for (Producto producto : inventario) {
            reporte.append(producto.toString()).append("\n");
        }

        return reporte.toString();
    }

    /**
     * Genera un reporte de productos con stock menor al mínimo usando for-each.
     * @param stockMinimo Límite inferior de stock
     * @return String con los productos críticos
     */
    public String generarReporteStockCritico(int stockMinimo) {
        StringBuilder reporte = new StringBuilder();
        reporte.append("--- REPORTE DE STOCK CRÍTIQUISIMOOOO (Stock < " + stockMinimo + ") ---\n");

        for (Producto producto : inventario) {
            if (producto.getStock() < stockMinimo) {
                reporte.append(producto.toString()).append("\n");
            }
        }

        return reporte.toString();
    }

    /**
     * Busca un producto por nombre (ignora mayúsculas/minúsculas).
     * @param nombre Nombre del producto a buscar
     * @return Producto encontrado o null si no existe
     */
    public Producto buscarProducto(String nombre) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
}