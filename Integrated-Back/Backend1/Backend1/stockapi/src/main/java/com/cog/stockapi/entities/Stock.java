package com.cog.stockapi.entities;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Stock {
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", cropName=" + cropName + ", stockInQuintal=" + stockInQuintal + "]";
	}
	@EmbeddedId
	private StockId stockId;
	private  String cropName;
	private int stockInQuintal;
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(StockId stockId, String cropName, int stockInQuintal) {
		super();
		this.stockId = stockId;
		this.cropName = cropName;
		this.stockInQuintal = stockInQuintal;
	}
	public StockId getStockId() {
		return stockId;
	}
	public void setStockId(StockId stockId) {
		this.stockId = stockId;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public int getStockInQuintal() {
		return stockInQuintal;
	}
	public void setStockInQuintal(int stockInQuintal) {
		this.stockInQuintal = stockInQuintal;
	}
	

}
