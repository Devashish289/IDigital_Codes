import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComplaintService {

  private baseUrl = 'http://localhost:4086/complaints';

  constructor(private http: HttpClient) { }

  getComplantByStatus(status: any): Observable<any> {
    return this.http.get(`${this.baseUrl}/${status}`);
  }
  getComplant(id: any): Observable<any> {
    return this.http.get(`${this.baseUrl}/complain/${id}`);
  }

  createComplaint(complaint: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`,complaint);
  }

  updateComplaint(value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}`, value);
  }

  getComplaintsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
