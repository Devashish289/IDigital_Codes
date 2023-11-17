import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StockId } from './stockId';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  private baseUrl = 'http://localhost:9080/stocks';
  id:StockId;

  constructor(private http: HttpClient) { }

  getStock(stockId: any): Observable<any> {
    return this.http.get(`${this.baseUrl}/${stockId.supplierId}/${stockId.cropId}`);
  }

  createStock(stock: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`,stock);
  }



  deleteStock(stockId:any): Observable<any>  {
    console.log('service mukesh '+stockId.supplierId+' '+stockId.cropId);
  
     //this.http.delete(`${this.baseUrl}`,stockId);
     return this.http.delete(`${this.baseUrl}/${stockId.supplierId}/${stockId.cropId}`);
  }

  getStocksList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
  
}
