import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Stock } from '../stock';
import { StockService } from '../stock.service';

@Component({
  selector: 'app-add-stock',
  templateUrl: './add-stock.component.html',
  styleUrls: ['./add-stock.component.css']
})
export class AddStockComponent implements OnInit {

  stock:Stock = new Stock();
  submitted = false;

  constructor(private stockService: StockService,
    private router: Router) { }

  ngOnInit() {
  }

  newStock(): void {
    this.submitted = false;
    this.stock = new Stock();
  }

  save() {
    this.stockService
    .createStock(this.stock).subscribe(data => {
      console.log(data)
      this.stock = new Stock();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/stocks']);
  }


}
