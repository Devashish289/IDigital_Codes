import { Component, OnInit } from '@angular/core';
import { StockService } from '../stock.service';
import {StockId} from '../stockId';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-stock-detail',
  templateUrl: './stock-detail.component.html',
  styleUrls: ['./stock-detail.component.css']
})
export class StockDetailComponent implements OnInit {
sid:string;
cid:string;
stock:any;
stockId:StockId;
  constructor(private route: ActivatedRoute,private router: Router, private stockService: StockService) { }

  ngOnInit(): void {
    this.sid = this.route.snapshot.params['supplierId'];
    this.cid = this.route.snapshot.params['cropId'];
    this.stockId=new StockId();
    this.stockId.setSupplierId(this.sid);
    this.stockId.setCropId(this.cid);
    this.stockService.getStock(this.stockId)
      .subscribe(data => {
        console.log(data)
        this.stock = data;
      }, error => console.log(error));
  }
  list(){
    this.router.navigate(['stocks']);
  }


}
