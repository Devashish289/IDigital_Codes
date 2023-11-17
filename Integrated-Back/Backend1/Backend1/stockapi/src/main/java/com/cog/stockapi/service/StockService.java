package com.cog.stockapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cog.stockapi.entities.Stock;
import com.cog.stockapi.entities.StockId;
import com.cog.stockapi.repository.StockRepository;

@Component
public class StockService {
	@Autowired
	public StockRepository stockRepo;

	public List<Stock> getStocks() {
		// TODO Auto-generated method stub
		return (List<Stock>) stockRepo.findAll();
	}

	public List<Stock> getStockById(String id) {
		// TODO Auto-generated method stub
		return  stockRepo.getBySupplierId(id);
	}

	public Stock addStock(Stock stock) {
		// TODO Auto-generated method stub
		stockRepo.save(stock);
		return stock;
	}

	public void deleteStockByCropId(StockId id) {
		System.out.println("data base "+id.getSupplierId());
		stockRepo.deleteById(id);
		
		
	}

	public Stock getStock(StockId stockId) {
		// TODO Auto-generated method stub
		return stockRepo.findById(stockId).get();
	}

	

}
