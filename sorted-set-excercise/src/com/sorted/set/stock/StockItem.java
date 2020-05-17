package com.sorted.set.stock;

public final class StockItem implements Comparable<StockItem>{
	private final String name;
	private double price;
	private int stockQuantity;
	
	public StockItem(String name, double price) {
		this.name = name;
		this.price = price;
		this.stockQuantity = 0;
	}

	public StockItem(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}

	public int quantityInStock() {
		return stockQuantity;
	}

	public void setPrice(double price) {
		if(price > 0.0) {
			this.price = price;
		}
		
	}
	
	public void adjustStock(int stockQuantity) {
		int newQuantity = this.stockQuantity + stockQuantity;
		if(newQuantity >= 0) {
			this.stockQuantity = newQuantity;
		}
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode() + 31;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		StockItem other = (StockItem) obj;
		return this.name.equals(other.name);
	}

	@Override
	public int compareTo(StockItem o) {
		if(this == o) {
			return 0;
		}
		if(o != null) {
			return this.name.compareTo(o.name);
		}
		
		throw new NullPointerException();
	}

	@Override
	public String toString() {
		return "StockItem: (" + name + ", " + price + ", " + stockQuantity + ") ";
	}

	
}
