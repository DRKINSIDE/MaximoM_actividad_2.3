package modelo;

/**
 * Clase Producto representa un producto dentro del inventario de la bodega.
 * Contiene el nombre y la cantidad de stock disponible.
 */

public class Producto {
    // Nombre del producto
    private String nombre;
    // Cantidad de unidades disponibles en stock
    private int stock;

    /**
     * Constructor: crea un producto con nombre y stock inicial.
     * @param nombre Nombre del producto
     * @param stockInicial Cantidad inicial de stock
     */
    public Producto(String nombre, int stockInicial) {
        this.nombre = nombre;
        this.stock = stockInicial;
    }

    /**
     * Devuelve el nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del producto.
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la cantidad de stock disponible.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Modifica la cantidad de stock disponible.
     * @param stock Nuevo valor de stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Devuelve una representación en texto del producto.
     */
    @Override
    public String toString() {
        return "Producto: " + nombre + " | Stock: " + stock;
    }
}