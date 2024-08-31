/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot? - Colombia)
 * Programa de Ingenier?a de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Gu?a 2 - Actividad 2
 * Ejercicio: tienda
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package mundo;

/**
 * Tienda que maneja 4 productos.
 */
public class Tienda {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Producto 1 de la tienda.
     */
    private Producto producto1;

    /**
     * Producto 2 de la tienda.
     */
    private Producto producto2;

    /**
     * Producto 3 de la tienda.
     */
    private Producto producto3;

    /**
     * Producto 4 de la tienda.
     */
    private Producto producto4;

    /**
     * Dinero total recibido por las ventas.
     */
    private double dineroEnCaja;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la tienda con sus 4 productos. <br>
     * <b> post: </b> El dinero en caja fue inicializado en 0.<br>
     * Los 4 productos fueron inicializados con los siguientes valores: <br>
     * Producto 1 - Tipo: PAPELERIA, Nombre: L?piz, Valor unitario: 550.0, Cantidad en bodega: 18, Cantidad m?nima: 5, Imagen: lapiz.png. <br>
     * Producto 2 - Tipo: DROGUERIA, Nombre: Aspirina, Valor unitario: 109.5, Cantidad en bodega: 25, Cantidad m?nima: 8, Imagen: aspirina.png. <br>
     * Producto 3 - Tipo: PAPELERIA, Nombre: Borrador, Valor unitario: 207.3, Cantidad en bodega: 30, Cantidad m?nima: 10, Imagen: borrador.png. <br>
     * Producto 4 - Tipo: SUPERMERCADO, Nombre: Pan, Valor unitario: 150.0, Cantidad en bodega: 15, Cantidad m?nima: 20, Imagen: pan.png. <br>
     */
    public Tienda() {
        producto1 = new Producto("papeleria", "Lapiz", 550.0, 18, 5, "lapiz.png");
        producto2 = new Producto("drogueria", "Aspirina", 109.5, 25, 8, "aspirina.png");
        producto3 = new Producto("papeleria", "Borrador", 207.3, 30, 10, "borrador.png");
        producto4 = new Producto("supermercado", "Pan", 150.0, 15, 20, "pan.png");
        dineroEnCaja = 0;
    }

    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Retorna el producto 1.
     *
     * @return Producto 1 de la tienda.
     */
    public Producto darPrimerProducto() {
        return producto1;
    }

    /**
     * Retorna el producto 2.
     *
     * @return Producto 2 de la tienda.
     */
    public Producto darSegundoProducto() {
        return producto2;
    }

    /**
     * Retorna el producto 3.
     *
     * @return Producto 3 de la tienda.
     */
    public Producto darTercerProducto() {
        return producto3;
    }

    /**
     * Retorna el producto 4.
     *
     * @return Producto 4 de la tienda.
     */
    public Producto darCuartoProducto() {
        return producto4;
    }

    /**
     * Retorna el dinero en caja.
     *
     * @return Dinero en caja.
     */
    public double darDineroEnCaja() {
        return dineroEnCaja;
    }

    /**
     * Retorna el producto con el nombre dado por par?metro.
     *
     * @param pNombre Nombre del producto buscado. pNombre != null && pNombre != "".
     * @return Producto con el nombre dado por par?metro, null si no lo encuentra.
     */
    public Producto darProducto(String pNombre) {
        Producto buscado = null;

        // Buscar el producto con el nombre dado
        // Asumimos que los productos están almacenados en variables individuales
        // Cambia 'producto1', 'producto2', etc., por los nombres de tus variables de producto
        if (producto1 != null && producto1.darNombre().equals(pNombre)) {
            buscado = producto1;
        } else if (producto2 != null && producto2.darNombre().equals(pNombre)) {
            buscado = producto2;
        } else if (producto3 != null && producto3.darNombre().equals(pNombre)) {
            buscado = producto3;
        } else if (producto4 != null && producto4.darNombre().equals(pNombre)) {
            buscado = producto4;
        }

        // Retorna el producto encontrado o null si no se encuentra
        return buscado;
    }

    /**
     * Retorna el promedio de las ventas.
     *
     * @return Dinero promedio obtenido por unidad de producto vendida.
     */
    public double darPromedioVentas() {
        double totalVentas = 0.0;
        int totalUnidadesVendidas = 0;

        // Array de productos para iterar fácilmente
        Producto[] productos = {producto1, producto2, producto3, producto4};

        // Iterar sobre cada producto
        for (Producto producto : productos) {
            if (producto != null) {
                // Sumar el valor total de ventas usando el precio final con IVA
                totalVentas += producto.darCantidadUnidadesVendidas() * producto.calcularPrecioFinal();
                // Sumar la cantidad de unidades vendidas
                totalUnidadesVendidas += producto.darCantidadUnidadesVendidas();
            }
        }

        // Calcular el promedio de ventas
        double respuesta = (totalUnidadesVendidas > 0) ? totalVentas / totalUnidadesVendidas : 0.0;

        // Retornar el promedio de ventas
        return respuesta;
    }

    /**
     * Retorna el producto con m?s unidades vendidas.
     *
     * @return Producto con m?s unidades vendidas. Null si ning?n producto tiene unidades vendidas.
     */
    public Producto darProductoMasVendido() {
        Producto masVendido = null;

        // Array de productos para iterar fácilmente
        Producto[] productos = {producto1, producto2, producto3, producto4};

        // Inicializa la cantidad máxima vendida en 0
        int maxUnidadesVendidas = 0;

        // Iterar sobre cada producto
        for (Producto producto : productos) {
            if (producto != null) {
                // Verificar si el producto tiene más unidades vendidas que el máximo actual
                if (producto.darCantidadUnidadesVendidas() > maxUnidadesVendidas) {
                    maxUnidadesVendidas = producto.darCantidadUnidadesVendidas();
                    masVendido = producto;
                }
            }
        }

        // Retorna el producto más vendido
        return masVendido;
    }

    /**
     * Retorna el producto con menos unidades vendidas.
     *
     * @return Producto con menos unidades vendidas. Null si ning?n producto tiene unidades vendidas.
     */
    public Producto darProductoMenosVendido() {
        Producto menosVendido = null;

        // Array de productos para iterar fácilmente
        Producto[] productos = {producto1, producto2, producto3, producto4};

        // Inicializa la cantidad mínima vendida en un valor alto (puede ser infinito)
        int minUnidadesVendidas = Integer.MAX_VALUE;

        // Iterar sobre cada producto
        for (Producto producto : productos) {
            if (producto != null) {
                // Verificar si el producto tiene menos unidades vendidas que el mínimo actual
                if (producto.darCantidadUnidadesVendidas() < minUnidadesVendidas) {
                    minUnidadesVendidas = producto.darCantidadUnidadesVendidas();
                    menosVendido = producto;
                }
            }
        }

        // Retorna el producto con menos unidades vendidas
        // Null si ningún producto tiene unidades vendidas (minUnidadesVendidas sigue siendo Integer.MAX_VALUE)
        return menosVendido;
    }

    /**
     * Vende una cantidad de unidades de producto de la tienda, dado su nombre por par?metro. <br>
     * <b>post: </b> Disminuy? la cantidad de unidades del producto dado
     * y se actualiz? el dinero de la caja a partir de la cantidad real vendida multiplicada
     * por el precio final (con IVA) del producto vendido..
     *
     * @param pNombreProducto Nombre del producto a vender.
     * @param pCantidad       Cantidad de unidades del producto a vender. pCantidad > 0.
     * @return Cantidad que fue efectivamente vendida.
     */
    public int venderProducto(String pNombreProducto, int pCantidad) {
        // Buscar el producto en la tienda por su nombre
        Producto producto = darProducto(pNombreProducto);

        // Si el producto no se encuentra, lanzar una excepción
        if (producto == null) {
            throw new IllegalArgumentException("Producto no encontrado: " + pNombreProducto);
        }

        // Vender la cantidad solicitada del producto y obtener la cantidad realmente vendida
        int cantidadVendida = producto.vender(pCantidad);

        // Calcular el precio final del producto después de aplicar el IVA
        double precioFinal = producto.calcularPrecioFinal();

        // Calcular el total de la venta
        double totalVenta = cantidadVendida * precioFinal;

        // Actualizar el dinero en caja con el total de la venta
        dineroEnCaja += totalVenta;

        // Retornar la cantidad de unidades vendidas
        return cantidadVendida;
    }


    /**
     * Abastece un producto dado su nombre, con la cantidad de unidades dadas. <br>
     * <b>post: </b> Aument? la cantidad de unidades en bodega del producto dado.
     *
     * @param pNombreProducto Nombre del producto a abastecer.
     * @param pCantidad       La cantidad de unidades a abastecer. cantidad >= 0.
     * @return Retorna true si se pudo efectuar el abastecimiento, false en caso contrario.
     */
    public boolean abastecerProducto(String pNombreProducto, int pCantidad) {
        // Buscar el producto con el nombre dado
        Producto producto = darProducto(pNombreProducto);

        // Verificar si el producto fue encontrado
        if (producto == null || pCantidad < 0) {
            // Retornar false si el producto no se encuentra o la cantidad es negativa
            return false;
        }

        // Abastecer el producto con la cantidad dada
        producto.abastecer(pCantidad);

        // Retornar true indicando que el abastecimiento fue exitoso
        return true;
    }

    /**
     * Cambia el producto que tiene el nombre actual con los nuevos valores dados por par?metro. <br>
     * <b>post: </b> El nombre, tipo, valor unitario, cantidad en bodega y cantidad m?nima fueron cambiados con los valores dados por par?metro.
     *
     * @param pNombreActual   Nombre actual del producto.
     * @param pNombreNuevo    Nuevo nombre del producto.
     * @param pTipo           Tipo del producto.
     * @param pValorUnitario  Valor unitario del producto
     * @param pCantidadBodega Cantidad en bodega del producto.
     * @param pCantidadMinima Cantidad m?nima en bodega para hacer un pedido del producto.
     * @param pRutaImagen     Ruta de la imagen del producto.
     * @return Retorna true si cambi? la informaci?n del producto,
     * Retorna false si ya exist?a un producto con el nuevo nombre.
     */
    public boolean cambiarProducto(String pNombreActual, String pNombreNuevo, String pTipo, double pValorUnitario, int pCantidadBodega, int pCantidadMinima, String pRutaImagen) {
        // Buscar el producto con el nombre actual
        Producto productoActual = darProducto(pNombreActual);

        // Verificar si el producto con el nombre nuevo ya existe
        Producto productoNuevo = darProducto(pNombreNuevo);
        if (productoNuevo != null) {
            // El producto con el nombre nuevo ya existe
            return false;
        }

        // Si el producto con el nombre actual no existe, no se puede cambiar
        if (productoActual == null) {
            return false;
        }

        // Cambiar la información del producto
        productoActual.cambiarNombre(pNombreNuevo);
        productoActual.cambiarTipo(pTipo);
        productoActual.cambiarValorUnitario(pValorUnitario);
        productoActual.cambiarCantidadBodega(pCantidadBodega);
        productoActual.cambiarCantidadMinima(pCantidadMinima);
        productoActual.cambiarRutaImagen(pRutaImagen);

        return true;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi?n
    // -----------------------------------------------------------------

    /**
     * Obtiene la cantidad de productos que tienen un precio inferior al promedio de los precios
     */
    public int metodo1() {
        double sumaPrecios = 0.0;
        int cantidadProductos = 4; // Hay 4 productos fijos

        // Array de productos fijos
        Producto[] productos = {producto1, producto2, producto3, producto4};

        // Calcular la suma de los precios finales de todos los productos
        for (Producto producto : productos) {
            sumaPrecios += producto.calcularPrecioFinal();
        }

        // Calcular el precio promedio
        double promedioPrecios = (cantidadProductos > 0) ? sumaPrecios / cantidadProductos : 0.0;
        int cantidadInferiorPromedio = 0;

        // Contar los productos cuyo precio final es inferior al promedio
        for (Producto producto : productos) {
            if (producto.calcularPrecioFinal() < promedioPrecios) {
                cantidadInferiorPromedio++;
            }
        }

        return cantidadInferiorPromedio;
    }

    public String metodo2() {
        // Array que contiene los productos disponibles en la tienda
        Producto[] productos = {producto1, producto2, producto3, producto4};

        // Verifica si el array de productos está vacío
        if (productos.length == 0) {
            // Retorna un mensaje si no hay productos en la tienda
            return "No hay productos en la tienda.";
        }

        // Inicializa el producto más barato con el primer producto del array
        Producto productoMasBarato = productos[0];

        // Recorre el array a partir del segundo producto para encontrar el más barato
        for (int i = 1; i < productos.length; i++) {
            // Compara el precio final del producto actual con el precio final del producto más barato encontrado hasta ahora
            if (productos[i].calcularPrecioFinal() < productoMasBarato.calcularPrecioFinal()) {
                // Actualiza el producto más barato si el producto actual es más barato
                productoMasBarato = productos[i];
            }
        }

        // Retorna el nombre del producto más barato
        return productoMasBarato.darNombre();
    }
}