/*	
 * Authors: David Rodriguez and Jacob Hargiss 
 * Date: 04/24/2018
 * Overview: Dynamic Programming
*/
package utils;


public final class CoinSystem {
	public static int[] getAmount(int[] array, int amount) {
		
		if(array.length==0) {
			throw new IllegalArgumentException("Array of size 0 is not allowed");
		}

		int[] table= new int[amount+1];
		
		
		for(int i=1; i<=amount; i++) {
			table[i]=Integer.MAX_VALUE;
		}
		
		table[0]=1;
		int[] check=new int[amount+1];
		
		for (int i=0; i<amount;i++) {
			for(int j=0;j<array.length;j++) {
				int temp=i+array[j];
				if(temp<=amount) {
					if(table[temp]==0 || table[temp]>table[i]+1) {
						check[temp]=j;
						table[temp]=table[i]+1;
					}
				}
			}
		}
		
		int[] coins=new int[table[amount]-1];
		
		while(amount>0) {
			coins[table[amount]-2]=array[check[amount]];
			amount=amount-array[check[amount]];
		}
		
		return coins;
	}
}


		
