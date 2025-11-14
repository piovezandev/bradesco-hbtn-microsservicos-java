package com.example.calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTest {

	private Calculator calculator = new Calculator();

	@Test
	void sumTest() {
		Double result = calculator.sum(1.0, 3.0);
		assertEquals(result, 4.0);
	}

	@Test
	public void numbersNullSumTest() {
		assertThrows(NullPointerException.class, () -> {
			calculator.sum(null, 1.0);
		});

		assertThrows(NullPointerException.class, () -> {
			calculator.sum(3.0, null);
		});
	}

	@Test
	void subTest() {
		Double result = calculator.sub(10.0, 3.0);
		assertEquals(result, 7.0);
	}

	@Test
	void divideTest() {
		Double result = calculator.divide(100.0, 2.0);
		assertEquals(result, 50.0);
	}

	@Test
	public void divisionByZeroTest() {
		assertThrows(ArithmeticException.class, () -> {
			calculator.divide(3.0, 0.0);
		});
	}

	@Test
	void factorialTest() {
		assertEquals(calculator.factorial(31), 738197504);
		assertEquals(calculator.factorial(0), 1);
	}

	@Test
	void integerToBinaryTest() {
		assertEquals(calculator.integerToBinary(12), 1100);
	}

	@Test
	void integerToHexadecimalTest() {
		assertEquals(calculator.integerToHexadecimal(2026), "7ea");
	}

	@Test
	void calculeDayBetweenDateTest() {
		LocalDate date1 = LocalDate.of(2025, 11, 01);
		LocalDate date2 = LocalDate.of(2025, 11, 30);

		assertEquals(calculator.calculeDayBetweenDate(date1, date2), 29);
	}
}