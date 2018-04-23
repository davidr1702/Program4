/*	
 * Authors: David Rodriguez and Jacob Hargiss 
 * Date: 04/24/2018
 * Overview: Dynamic Programming
*/
package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utils.CoinSystem;

class JUnit {

	@Test
	void testGetAmountEmptyArray() {
		int array[]= {};
		int amount=42;
		Exception e=assertThrows(IllegalArgumentException.class, ()->{CoinSystem.getAmount(array, amount);});
		assertEquals("Array of size 0 is not allowed", e.getMessage());
	}
	@Test
	void testGetAmountUSCurrency() {
		int array[]= {25,10,5,1};
		int amount=42;
		int[] expected=new int[]{1,1,5,10,25};
		int[] coins=CoinSystem.getAmount(array, amount);
		for(int i=0; i<expected.length;i++) {
			assertEquals(expected[i], coins[i]);
		}
	}
	@Test
	void testGetAmountArgentinianCurrency() {
		int array[]= {50,25,10,5};
		int amount=60;
		int[] expected={10,50};
		int[] coins=CoinSystem.getAmount(array, amount);
		for(int i=0; i<expected.length;i++) {
			assertEquals(expected[i],coins[i]);
		}
		
	}
	@Test
	void testGetAmountBrazilianCurrency() {
		int array[]= {50,25,10,5,1};
		int amount=40;
		int[] expected={5,10,25};
		int[] coins=CoinSystem.getAmount(array, amount);
		for(int i=0; i<expected.length;i++) {
			assertEquals(expected[i],coins[i]);
		}
	}
}
