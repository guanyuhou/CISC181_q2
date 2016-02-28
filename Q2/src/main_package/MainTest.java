package main_package;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	double rates[] = {10.0, 20.0, 30.0};
	@Test
	public void testTotalTuition() {
		assertTrue(Main.totalTuition(15000.0, rates) == 77040);
	}

	@Test
	public void testTotalPayment() {
		assertTrue(Main.totalPayment(15000, rates, 13.0) == 90826.305);
	}

	@Test
	public void testMonthPay() {
		assertTrue(Main.monthPayment(90826.305, 5) == 630.7382291666667);
	}

}
