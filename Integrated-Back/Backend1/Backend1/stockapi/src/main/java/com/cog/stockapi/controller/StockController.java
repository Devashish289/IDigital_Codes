package com.cog.stockapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cog.stockapi.entities.Stock;
import com.cog.stockapi.entities.StockId;
import com.cog.stockapi.service.StockService;
import java.util.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StockController {
    @Autowired
	public StockService stockService;
    @GetMapping("/stocks")
     public List<Stock> getStocks()
     {
    	return stockService.getStocks();
     }
    @GetMapping("/stocks/{sid}/{cid}")
    public Stock getStocksByStockId(@PathVariable("sid") String sid,@PathVariable("cid") String cid)
    {StockId stockId=new StockId(sid,cid);
    System.out.println(stockId);
   	return stockService.getStock(stockId);
    }
    @GetMapping("/stocks/{id}")
    public List<Stock> getStockBySupplierId(@PathVariable("id") String id)
    {
   	return stockService. getStockById(id);
    }
    @PostMapping("/stocks")
    public Stock addStock(@RequestBody Stock stock)
    {
   	return stockService. addStock(stock);
    }
    @DeleteMapping("/stocks/{sid}/{cid}")
    public void deleteStockByCropId(@PathVariable("sid") String sid,@PathVariable("cid") String cid)
    {StockId stockId=new StockId(sid,cid);
    	System.out.println(stockId);
   	 stockService.deleteStockByCropId(stockId);
    }
    
    
     
}
