package tallerweb.supermercado.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Carrito {

    private static Carrito instance = new Carrito();
    private List<Producto> productos = new LinkedList<Producto>();
    private List<Descuento> descuentos = new LinkedList<Descuento>();

    private Carrito() {
    }

    public static Carrito getInstance() {
        return instance;
    }

    /**
     * Elimina todos los productos del carrito.<br>
     */
    public void vaciar() {
        // Implementar
    	// Limpia los productos y los descuentos echos en el carrito
    	Carrito.getInstance().productos.clear();
    	Carrito.getInstance().descuentos.clear();
    }

    /**
     * Agrega un producto al carrito.<br>
     * 
     * @param ingrediente
     */
    public void agregarProducto(Producto producto) {
        // Implementar
    	// Verifica que el producto exista en el stock y que haya cantidad disponible (mayor a 0)  
    	if(Stock.getInstance().obtenerStockDisponible(producto) > 0 && Stock.getInstance().obtenerStockDisponible(producto) != null)
    		Carrito.getInstance().productos.add(producto);
    }

    /**
     * Permite agregar un descuento que será aplicado al carrito.<br>
     * 
     * @param descuento
     */
    public void aplicarDescuento(Descuento descuento) {
        // Implementar
    	
    }

    /**
     * Lista todos los productos que forman parte del carrito.<br>
     * 
     * @return
     */
    public List<Producto> verProductos() {
        // Implementar
    	// Creo la lista de productos que va a retornar el metodo
    	List<Producto> listita = new ArrayList<Producto>();
    	
    	// El foreach va agregando los productos del carrito a mi listita
    	for(Producto prod : productos) {
    		listita.add(prod);
    	}
    	
        return listita;
    }

    /**
     * Devuelve el precio total del carrito aplicando descuentos si los hubiese,
     * primero aplica los descuentos de monto y luego los de porcentaje.<br>
     * 
     * @return
     */
    public Double total() {
        // Implementar
    	// Inicializo los totales para despues sumarlos
    	Double totalMonto = 0.00;
    	Double totalPorcentaje = 0.00;
    	Double totalSinDescuento = 0.00;
    	
    	Iterator<Descuento> iteradorDesc = Carrito.getInstance().descuentos.iterator();
    	Iterator<Producto> iteradorProd = Carrito.getInstance().productos.iterator();
    	
    	while(iteradorDesc.hasNext()) {
    		
    		if (iteradorDesc.next().getMonto() != null) { // Si tiene algun valor quiere decir que el descuento fue por monto
    			totalMonto += (iteradorProd.next().getPrecio() - iteradorDesc.next().getMonto());
    		}
    		else if (iteradorDesc.next().getPorcentaje() != null) { // Si tiene algun valor quiere decir que el descuento por porcentaje
    			totalPorcentaje += (iteradorProd.next().getPrecio() * iteradorDesc.next().getPorcentaje());
    		}
    		else
    			totalSinDescuento += iteradorProd.next().getPrecio(); // Si no tiene descuento se suma el precio normal
    	}
    	
    	// Sumo todos los totales
        return (totalMonto + totalPorcentaje + totalSinDescuento);
    }

    /**
     * Devuelve el precio sin descuentos del carrito.<br>
     * 
     * @return
     */
    public Double totalSinDescuentos() {
        // Implementar
    	Double totalSinDescuento = 0.00;
    	
    	for(Producto prod : productos) {
    		totalSinDescuento += prod.getPrecio();
    	}
    	
        return totalSinDescuento;
    }

    /**
     * Devuelve el dinero ahorrado gracias a los descuentos.<br>
     * 
     * @return
     */
    public Double totalAhorros() {
        // Implementar
        return null;
    }
    
}
