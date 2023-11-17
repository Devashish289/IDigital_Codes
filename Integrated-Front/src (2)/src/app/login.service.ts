import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public userId:string;
  public role:string;

  constructor() { }
}
