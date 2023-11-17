import { Component, OnInit } from '@angular/core';
import {StockService} from '../stock.service';
import { Router } from '@angular/router';
import { Observable } from "rxjs";
import {StockId} from '../stockId';
import {Stock} from '../stock';
@Component({
  selector: 'app-view-stock',
  templateUrl: './view-stock.component.html',
  styleUrls: ['./view-stock.component.css']
})
export class ViewStockComponent implements OnInit {
  stocks: Observable<Stock[]>;

  constructor(private stockService: StockService, private router: Router) { }
 
  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.stocks = this.stockService.getStocksList();
  }
  deleteStock(stockId :any)
  {
    console.log(stockId.supplierId);
    console.log(stockId);
    this.stockService.deleteStock(stockId) .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
    

  }
  stockIdDetails(stockId :any)
  {
this.router.navigate(['stockDetail',stockId]);
  }
  addStock()
  {
    this.router.navigate(['addStock']);
  }
  
  gotoList()
  {
    this.router.navigate(['stocks']);
  }
}
