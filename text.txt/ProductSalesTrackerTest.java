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
	}

	@AfterEach
	void tearDown() throws Exception {
		product1 = null;
		product2 = null;
	}

	@Test
	void testAddSale() {
		assertEquals(product1.addSale(1294090.49),true);
		
		assertTrue(product2.addSale(16.67));
		assertTrue(product2.addSale(16.67));
		assertTrue(product2.addSale(16.67));
		assertFalse(product2.addSale(16.67));
	}

	@Test
	void testTotalSales(){
		product1.addSale(1294090.49);

		assertEquals(product1.totalSales(),1294090.49);
	}

	@Test
	void testLowestSale(){
		product1.addSale(1);
		product1.addSale(2);
		product1.addSale(3);
		product1.addSale(4);
		product1.addSale(5);
		assertEquals(product1.lowestSale(),1);
	}

	@Test
	void testFinalSalesTotal() {
		product1.addSale(1);
		product1.addSale(2);
		product1.addSale(3);
		product1.addSale(4);
		product1.addSale(5);
		assertEquals(product1.finalSalesTotal(),product1.totalSales()-product1.lowestSale());
	}
	
	@Test
	void testToString() {
		product2.addSale(16.67);
		product2.addSale(16.67);
		product2.addSale(16.67);
		assertEquals(product2.toString(),"16.67 16.67 16.67 ");
	}

}
