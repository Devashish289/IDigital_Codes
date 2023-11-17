import { Injectable } from '@angular/core';
import{ HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Msp } from './Msp';
import { retry, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MspService {
  public localurl='http://localhost:9090/msp';
  public tempMsp:Msp;
  public flag:Boolean=false;
  public mspDb:any[]=[];

  constructor(private http:HttpClient) { }
  httpOptions={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
  getMsp(){
    this.mspDb=[];
    this.http.get<Msp[]>(this.localurl+'/viewAll').pipe(retry(0), catchError((error: HttpErrorResponse) => {
      window.alert(error.error.message);
      return throwError('Error fetching data from serve ');})).subscribe(resp=>{
      for(const msp of(resp as any)){
          this.mspDb.push({
            cropId:msp.cropId,
            cropName:msp.cropName,
            mspPrice:msp.mspPrice
          })
      }
    });
  }
  addMsp(Msp:Msp){
    return this.http.post(this.localurl+'/addCrop',Msp).pipe(retry(0), catchError((error: HttpErrorResponse) => {
      window.alert(error.error.message);
      return throwError('Error fetching data from serve');}));
  }
  deleteMsp(cropId:any){
    return this.http.delete(this.localurl+'/deleteCropById/'+cropId).pipe(retry(0), catchError((error: HttpErrorResponse) => {
      window.alert(error.error.message);
      return throwError('Error fetching data from serve');}));
  }
  updateMsp(Msp:Msp){
    return this.http.put(this.localurl+'/update',Msp);
  }
  getById(cropId:string){
    return this.http.get(this.localurl+'/viewByCropId/'+cropId).pipe(retry(0), catchError((error: HttpErrorResponse) => {
      window.alert(error.error.message);
      return throwError('Error fetching data from serve');}));
  }
}
