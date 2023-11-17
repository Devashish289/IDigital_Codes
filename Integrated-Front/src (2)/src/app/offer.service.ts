import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { offer } from './offer';

@Injectable({
  providedIn: 'root'
})
export class OfferService {
  constructor(private http:HttpClient) { }

  public getOffers(person:string):Observable<any>{
    return this.http.get("http://localhost:8082/getoffers/"+person);

  }

  public viewOffer(offerId:string):Observable<any>{
    return this.http.get("http://localhost:8082/viewoffer/"+offerId);

  }

  public deleteOffer(offerId:string):Observable<any>{
    return this.http.delete("http://localhost:8082/deleteoffer/"+offerId,{responseType:'text'});
  }

  public editOffer(offer:offer):Observable<any>{
    return this.http.put("http://localhost:8082/editoffer",offer,{responseType:'text'});

  }

  public addOffer(offer:offer):Observable<any>{
    return this.http.post("http://localhost:8082/addoffer",offer,{responseType:'text'});

  }


}
