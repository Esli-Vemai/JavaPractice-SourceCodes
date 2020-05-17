package com.sorted.set.stock;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Basket {
	private final String name;
	private final Map<StockItem, Integer> list;

	public Basket(String name) {
		this.name = name;
		this.list = new TreeMap<>();
	}
	
	
	public int addToBasket(StockItem item, int quantity) {
		if(item != null) {
			//get() returns null if not found, so better use getOrDefault() and return a default as 0
			int quantityIn = list.getOrDefault(item, 0);
			if(quantityIn >= 0 && quantity >= 0) {
				quantity += quantityIn;
			}
			list.put(item, quantity);
			return quantity;
		}
		
		return 0;
		
	}
	
	
	public Map<StockItem, Integer> items() {
		return Collections.unmodifiableMap(list);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("\nShopping basket ");
		builder.append(name).append("contains").append(list.size() + ((list.size() == 1) ? " item" : " items"))
							.append("\n");
		
		double totalCost = 0.0;
		for (Entry<StockItem, Integer> stock : list.entrySet()) {
			builder.append(stock.getKey()).append(stock.getValue()).append(" purchased\n");
			totalCost = stock.getKey().getPrice() * stock.getValue();	
		}
		
		return builder.append("Total cost: " + totalCost).toString();

	}
	
	
	
}
