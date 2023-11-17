import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdvertisementEntity } from './add-advertisement/AdvertisementEntity';
import { Advertisement } from './Advertisement';

@Injectable({
  providedIn: 'root'
})
export class AdvertisementService {

  constructor(private http:HttpClient) { }
  public url:string = "http://localhost:6060";
  public advertisementId:string;

  viewAdvertisements(userId:string, role:string):Observable<Advertisement[]>
  {
    return this.http.get<Advertisement[]>(this.url+'/ads/'+userId+'/'+role);
  }

  viewMyAdvertisements(userId:string):Observable<Advertisement[]>
  {
    return this.http.get<Advertisement[]>(this.url+'/myAds/'+userId);
  }
  addAdvertisement(ad:AdvertisementEntity):Observable<AdvertisementEntity>
  {
    return this.http.post<AdvertisementEntity>(this.url+"/addAdvertisement",ad);
  }

  deleteAdvertisement(advertisementId:string):Observable<string>
  {
    return this.http.delete<string>(this.url+'/deleteAdvertisement/'+advertisementId);
  }

  getAdvertisementId():Observable<string>
  {
    return this.http.get<string>(this.url+"/getId");
  }
  viewAd(adId:String):Observable<Advertisement>
  {
    return this.http.get<Advertisement>(this.url+'/getAd/'+adId);
  }

  
}
