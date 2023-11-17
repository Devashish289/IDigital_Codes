import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FarmingAssistantService 
{
  public user:any;
  userId:string;
  role:string;
  constructor(private http: HttpClient) {}
  
  registerUser(register:Profile) { return this.http.post('http://localhost:8118/register',register)}
  
  updateProfile(body) { return this.http.put('http://localhost:8118/updateProfile',body)};

  viewProfile(userId) { return this.http.get('http://localhost:8118/viewProfile/' +userId)};

  deleteProfile(userId) { return this.http.delete('http://localhost:8118/deleteProfile/' +userId)};

  login(userId,password,role) { return this.http.get('http://localhost:8091/login/' +userId +'/' +password +'/' +role)};

  updateLoginDetails(body) { return this.http.put('http://localhost:8091/updateLoginDetails',body)};

  deleteLoginDetails(userId) { return this.http.delete('http://localhost:8091/deleteLoginDetails/' +userId)};

  getUserIdbyRole(role) { return this.http.get('http://localhost:8091/getUserIdbyRole/' +role)};

  getLoginDetails(userId) { return this.http.get('http://locahost:8091/getLoginDetails/' +userId)};

  addLoginDetails(userId:String, password:String, role:String) { 
    let data = {userId: userId, password: password, role: role};
    return this.http.post('http://localhost:8091/addLoginDetails/'+userId+'/'+password+'/'+role, data,{responseType: 'text' as 'json'})  };
  }
export class Login
{
  userId:String;
  password:String;
  role:String;
}
export class Profile
{
  userId:String;
  userName:String;
  phoneNumber:String;
  address:String;
  location:String;
  role:String;
}
