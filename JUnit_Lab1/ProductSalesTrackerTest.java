import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductSalesTrackerTest {
	ProductSalesTracker product1;
	ProductSalesTracker product2;

	@BeforeEach
	void setUp() throws Exception {
		product1 = new ProductSalesTracker(5);
		product2 = new ProductSalesTracker(3);
		
		
		// 3/5 sales added
		product1.addSale(16.67);
		product1.addSale(31);
		product1.addSale(0.1337);

		//max sales added
		product2.addSale(0.5);
		product2.addSale(0.5);
		product2.addSale(0.5);

		
	}

	/**
	 *   Create at least two instances of ProductSalesTracker 
	 *   in the @BeforeEach method, with some sales added.
	 */

	@AfterEach
	void tearDown() throws Exception {
		product1 = null;
		product2 = null;
	}

	@Test
	void testAddSale() {
		assertEquals(product1.addSale(67),true);
		
		//false = not added
		assertFalse(product2.addSale(-0.1));
		assertFalse(product1.addSale(-1.1));
	}

	@Test
	void testTotalSales(){
		assertEquals(product2.totalSales(),1.50);
		assertEquals(product1.totalSales(),47.8037);

	}

	@Test
	void testLowestSale(){
	
		assertEquals(product1.lowestSale(),0.1337);
		assertEquals(product2.lowestSale(),0.5);

	}

	@Test
	void testFinalSalesTotal() {
		assertEquals(product1.finalSalesTotal(),47.67);
		assertEquals(product2.finalSalesTotal(),1);

 	}
	
	@Test
	void testToString() {
		assertEquals(product1.toString(),"16.67 31.0 0.1337 ");
		assertEquals(product2.toString(),"0.5 0.5 0.5 ");
	}

}
