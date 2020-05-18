package com.sorted.set.stock;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
	private final Map<String, StockItem> stockList;

	public StockList() {
		this.stockList = new LinkedHashMap<>();
	}

	
	
	public int addStock(StockItem stock) {
		if(stock != null) {
			//Check if stock is already in the map.
			StockItem stockIn = stockList.getOrDefault(stock.getName(), stock);
			//
			//if(stock != stockIn) { // Tim's
			// If there's already an item with the same id, increment the stock quantity for that item before adding
			if(!stock.equals(stockIn)) {
				stock.adjustStock(stockIn.availableQuantity());
			}
			stockList.put(stock.getName(), stock);
			return stock.availableQuantity();
		}
		return 0;
	}
	
	
	public int sellStock(String name, int quantity) {
		if(name != null) {
			StockItem inStock = stockList.getOrDefault(name, null);
			if(inStock != null && quantity > 0) //{
				return inStock.finalizedStock(quantity);
			//}
			
			/*
			 * if(inStock != null && quantity > 0 && inStock.availableQuantity() >=
			 * quantity) { inStock.adjustStock(-quantity); stockList.replace(name, inStock);
			 * return inStock.availableQuantity(); }
			 */
		}
		return 0;
		
	}
	
	public int reserveStock(String item, int quantity) {
		StockItem inStock = stockList.get(item);
		if(inStock != null && quantity > 0) {
			inStock.reserveStock(quantity);
			return quantity;
		}
		return 0;
	}
	
	public int unreserveStock(String item, int quantity) {
		StockItem inStock = stockList.get(item);
		if(inStock != null && quantity > 0) {
			inStock.unreserveStock(quantity);
			return quantity;
		}
		return 0;
	}
	
	
	
	public StockItem get(String name) {
		return stockList.get(name);
	}
	
	public Map<String, Double> priceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : stockList.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }
	
	public Map<String, StockItem> getItems() {
		// better alternative to previous approach of 
		// return new HashMap<>(stockList);
		// because it could possibly be still modified. But the below method returns 100% unmodifiable Map
		return Collections.unmodifiableMap(stockList);
	}
	
	@Override
	public String toString() {
		StringBuilder buildStr = new StringBuilder("\n List of Stocks \n");
		double totalCost = 0.0;
		//for (Map.Entry<String, StockItem> entry: stockList.entrySet()) {
		
		// better retrieve the values directly instead of using "entry.getValue()" for each iteration.
			for (StockItem value: stockList.values()) {
				double itemValue = value.getPrice() * value.availableQuantity();
				buildStr.append(value).append("There are " + value.availableQuantity() + "in stock")
						.append("Value of items: "  + String.format("%.2f", itemValue)).append("\n");
				totalCost += itemValue;
			}
			return buildStr.append("Total stock value: " + totalCost).toString();
		}


}
