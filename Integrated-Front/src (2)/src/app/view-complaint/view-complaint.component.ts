import { Component, OnInit } from '@angular/core';
import {ComplaintService} from '../complaint.service';
import { Router } from '@angular/router';
import { Observable } from "rxjs";

@Component({
  selector: 'app-view-complaint',
  templateUrl: './view-complaint.component.html',
  styleUrls: ['./view-complaint.component.css']
})
export class ViewComplaintComponent implements OnInit {
complaints :any;
  constructor(private complaintService: ComplaintService, private router: Router) { }
status:string;
  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.complaints = this.complaintService.getComplaintsList();
  }
  deleteComplaint(complainId : number)
  {

  }
  updateComplaint(complaint : any)
  {
    this.router.navigate(['updateComplaint',complaint]);
  }
  ComplaintDetails(complainId : number)
  {

  }
  reload()
  {this.reloadData();
    this.router.navigate(['complaints']);
  }
  onFilter()
  {console.log(this.status);
    this.complaints = this.complaintService.getComplantByStatus(this.status);
    
  }
}
