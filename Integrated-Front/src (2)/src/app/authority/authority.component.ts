import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ComplaintService } from '../complaint.service';

@Component({
  selector: 'app-authority',
  templateUrl: './authority.component.html',
  styleUrls: ['./authority.component.css']
})
export class AuthorityComponent implements OnInit {

  complaints :any;
  constructor(private complaintService: ComplaintService, private router: Router) { }
status:string;
  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.complaints = this.complaintService.getComplaintsList();
  }
  
  updateComplaint(complaint : any)
  {
    this.router.navigate(['updateComplaint',complaint]);
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
