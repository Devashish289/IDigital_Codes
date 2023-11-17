package com.cog.stockapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.cog.stockapi.entities.Stock;
import com.cog.stockapi.entities.StockId;
@Component
public interface StockRepository extends CrudRepository<Stock,StockId> {
	@Query("select stock from Stock stock where stock.stockId.supplierId= :n")
	public List<Stock> getBySupplierId(@Param("n") String id);
	
}
