package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	private static final String SEPARATOR = " ";
	static int [] prices;
	static int money;
	
	public static void readData () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		do{
			if(!line.equals("")) {
				line = br.readLine();
				String[] parts = line.split(SEPARATOR);
				prices = new int [parts.length];
				for (int j = 0; j < parts.length; j++) {
					prices[j] = Integer.parseInt(parts[j]);
				}
				line = br.readLine();
				money = Integer.parseInt(line);
				bw.write(writeData());
				
			}
			line = br.readLine();
			
		}while (line != null);
			
			
			
		br.close();
		bw.close();

	}
	public static String writeData () throws IOException {

		int minRest = 1000001;
		int bookX = 0;
		int bookY = 0;
		int rest;
		Arrays.sort(prices);
		
		for (int i = 0; i < prices.length; i++) {
			int priceToMoney = money - prices[i];
			int bookIndex = Arrays.binarySearch(prices, priceToMoney);
			if (bookIndex >= 0 && bookIndex != i) {
				rest = (prices[i] - prices[bookIndex]) > 0 ? (prices[i] - prices[bookIndex]) : -(prices[i] - prices[bookIndex]);
				if (rest < minRest) {
					minRest = rest;
					bookX = prices[i];
					bookY = prices[bookIndex];
				}
			}			
		}
		return "Peter should buy books whose prices are " + bookX + " and " + bookY + ".\n\n";
	}
	public static void main(String[] args) throws IOException {
		
		readData();
    	
	}		

}
