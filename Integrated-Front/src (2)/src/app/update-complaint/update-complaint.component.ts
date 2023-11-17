import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ComplaintService } from '../complaint.service';
@Component({
  selector: 'app-update-complaint',
  templateUrl: './update-complaint.component.html',
  styleUrls: ['./update-complaint.component.css']
})
export class UpdateComplaintComponent implements OnInit {

  constructor(private route: ActivatedRoute,private router: Router,private complaintService: ComplaintService) { }
id:any;
complaint:any;
  ngOnInit(): void {
    this.id = this.route.snapshot.params['complainId'];
   
    this.complaintService.getComplant(this.id)
      .subscribe(data => {
        console.log(data);
        this.complaint = data;
      }, error => console.log(error));
  }
  updateComplaint() {
    this.complaintService.updateComplaint(this.complaint)
      .subscribe(data => {
        console.log(data);
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateComplaint();    
  }

  gotoList() {
    this.router.navigate(['/complaints']);
  }

}
