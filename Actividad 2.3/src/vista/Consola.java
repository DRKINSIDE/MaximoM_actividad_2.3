package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;




public class Consola extends JFrame {
    // Botón para agregar un nuevo producto al inventario
    private JButton btnAgregarProducto;
    // Botón para aumentar el stock de un producto existente
    private JButton btnAgregarStock;
    // Botón para disminuir el stock de un producto existente
    private JButton btnRestarStock;
    // Botón para mostrar el reporte completo del inventario
    private JButton btnReporteInventario;
    // Botón para cerrar la aplicación
    private JButton btnSalir;

    /**
     * Constructor: inicializa la ventana y sus componentes gráficos.
     * Llama a métodos privados para separar la lógica de inicialización y configuración.
     */
    public Consola() {
        inicializarComponentes(); // Crea y organiza los botones y el título
        configurarVentana();      // Ajusta propiedades de la ventana principal
    }

    /**
     * Inicializa y organiza los componentes gráficos de la ventana.
     * Crea los botones, les asigna fuente, los agrega a un panel y coloca el título.
     */
    private void inicializarComponentes() {
        // Crear botones con el texto correspondiente a cada acción
        btnAgregarProducto = new JButton(" Agregar Producto");
        btnAgregarStock = new JButton(" Agregar Stock");
        btnRestarStock = new JButton(" Restar Stock");
        btnReporteInventario = new JButton(" Reporte Inventario");
        btnSalir = new JButton(" Salir");

        // Definir una fuente más grande y negrita para los botones
        Font fontBotones = new Font("Arial", Font.BOLD, 16);
        btnAgregarProducto.setFont(fontBotones);
        btnAgregarStock.setFont(fontBotones);
        btnRestarStock.setFont(fontBotones);
        btnReporteInventario.setFont(fontBotones);
        btnSalir.setFont(fontBotones);

        // Crear un panel con layout de 5 filas y 1 columna para los botones
        JPanel panelBotones = new JPanel(new GridLayout(5, 1, 10, 10));
        // Añadir un borde vacío para separar los botones de los bordes de la ventana
        panelBotones.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        // Agregar los botones al panel en orden
        panelBotones.add(btnAgregarProducto);
        panelBotones.add(btnAgregarStock);
        panelBotones.add(btnRestarStock);
        panelBotones.add(btnReporteInventario);
        panelBotones.add(btnSalir);

        // Usar BorderLayout para organizar el panel de botones y el título
        setLayout(new BorderLayout());
        add(panelBotones, BorderLayout.CENTER); // Panel de botones al centro

        // Crear y configurar el título de la ventana
        JLabel titulo = new JLabel("SISTEMA DE GESTIÓN DE INVENTARIO", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(titulo, BorderLayout.NORTH); // Título en la parte superior
    }

    /**
     * Configura las propiedades principales de la ventana JFrame.
     * Define el título, tamaño, cierre, posición y si es redimensionable.
     */
    private void configurarVentana() {
        setTitle("Sistema de Gestión de Inventario"); // Título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar aplicación al salir
        setSize(800, 1000); // Tamaño fijo de la ventana
        setLocationRelativeTo(null); // Centrar ventana en pantalla
        setResizable(false); // No permitir redimensionar
    }

    // ==================== MÉTODOS PARA ASOCIAR ACCIONES A LOS BOTONES ====================

    /**
     * Asocia un ActionListener al botón de agregar producto.
     * @param listener Acción a ejecutar cuando se presiona el botón
     */
    public void setAgregarProductoListener(ActionListener listener) {
        btnAgregarProducto.addActionListener(listener);
    }

    /**
     * Asocia un ActionListener al botón de agregar stock.
     * @param listener Acción a ejecutar cuando se presiona el botón
     */
    public void setAgregarStockListener(ActionListener listener) {
        btnAgregarStock.addActionListener(listener);
    }

    /**
     * Asocia un ActionListener al botón de restar stock.
     * @param listener Acción a ejecutar cuando se presiona el botón
     */
    public void setRestarStockListener(ActionListener listener) {
        btnRestarStock.addActionListener(listener);
    }

    /**
     * Asocia un ActionListener al botón de reporte de inventario.
     * @param listener Acción a ejecutar cuando se presiona el botón
     */
    public void setReporteInventarioListener(ActionListener listener) {
        btnReporteInventario.addActionListener(listener);
    }

    /**
     * Asocia un ActionListener al botón de salir.
     * @param listener Acción a ejecutar cuando se presiona el botón
     */
    public void setSalirListener(ActionListener listener) {
        btnSalir.addActionListener(listener);
    }

    // ==================== MÉTODOS PARA MOSTRAR DIÁLOGOS AL USUARIO ====================

    /**
     * Muestra un cuadro de diálogo para ingresar texto.
     * @param mensaje Mensaje a mostrar en el cuadro
     * @return Texto ingresado por el usuario
     */
    public String mostrarInputDialog(String mensaje) {
        return JOptionPane.showInputDialog(this, mensaje);
    }

    /**
     * Muestra un cuadro de diálogo para ingresar un número entero.
     * Si el usuario ingresa un valor no numérico, retorna -1.
     * @param mensaje Mensaje a mostrar en el cuadro
     * @return Número ingresado o -1 si hay error
     */
    public int mostrarInputDialogEntero(String mensaje) {
        try {
            String input = JOptionPane.showInputDialog(this, mensaje);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Muestra un cuadro de diálogo con un mensaje informativo.
     * @param mensaje Mensaje a mostrar
     */
    public void mostrarMensajeDialog(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}