import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ChatboxService {
 

  constructor(private http:HttpClient) { }

  public addMsg(ChatboxDto){
    alert('Your Chats added successfully..')
    return this.http.post<any>("http://localhost:6061/Addmsg",ChatboxDto);
  }

  
  public getMsgDetails(msgId){
    return this.http.get("http://localhost:6061/fetchById/"+msgId);
  }

  deleteMsg(msgId:String): Observable<any> {
    alert("Ok, Message Removed...");
    return this.http.delete("http://localhost:6061/deleteById/"+msgId, { responseType: 'text' });
  }
  getAllMsg(): Observable<any> {
    return this.http.get("http://localhost:6061/Allmsg");
  }
}
