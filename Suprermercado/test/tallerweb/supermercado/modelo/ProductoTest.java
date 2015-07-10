package tallerweb.supermercado.modelo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ProductoTest {
	
	@Before
	public void crearProductos() {
		
		Carrito.getInstance().vaciar();
    	// Creo un producto nuevo
    	Producto nuevoProducto = new Producto();
    	nuevoProducto.setNombre("Cereal");
    	nuevoProducto.setPrecio(21.00);
    	
    	// Agrego el producto nuevo a la lista de stock y le asigno una cantidad disponible
    	Stock.getInstance().agregarProducto(nuevoProducto);
    	Stock.getInstance().agregarStock(nuevoProducto, 50);
    	
    	// Agrego el producto al carrito
    	Carrito.getInstance().agregarProducto(nuevoProducto);
    	
    	// Cambio los valores de nuevoProducto por unos nuevos y lo agrego al stock
    	nuevoProducto = new Producto();
    	nuevoProducto.setNombre("Chocolate");
    	nuevoProducto.setPrecio(10.00);
    	Stock.getInstance().agregarProducto(nuevoProducto);
    	Stock.getInstance().agregarStock(nuevoProducto, 1000);
    	
    	// Agrego el segundo producto al carrito
    	Carrito.getInstance().agregarProducto(nuevoProducto);
	}
	
    @Test
    public void testVaciar() {
        // Implementar
    	
    	Carrito.getInstance().vaciar();
    	
    	// Verifico que se haya limpiado la lista del carrito
    	assertTrue(Carrito.getInstance().verProductos().isEmpty());
    }

    @Test
    public void testAgregarProducto() {
        // Implementar
    	// Verifico que se hayan asignado los 2 productos a la lista del carrito
    	assertEquals(2, Carrito.getInstance().verProductos().size());
    }

    @Test
    public void testAplicarDescuento() {
        // Implementar
    }

    @Test
    public void testVerProductos() {
        // Implementar
    	List<Producto> listaDeProductos = Carrito.getInstance().verProductos();
    	
    	assertNotNull(listaDeProductos);
    	assertEquals(2, listaDeProductos.size());
    	
    	Producto producto = listaDeProductos.get(0);
    	assertEquals("Cereal", producto.getNombre());
    	
    	producto = listaDeProductos.get(1);
    	assertEquals("Chocolate", producto.getNombre());
    }

    @Test
    public void testTotal() {
        // Implementar
    }

    @Test
    public void testTotalSinDescuentos() {
        // Implementar
    	Double totalSinDescuento = Carrito.getInstance().totalSinDescuentos();
    	
    	assertEquals(31.00, totalSinDescuento, 0.01);
    }

    @Test
    public void testTotalAhorros() {
        // Implementar
    }
    
}
