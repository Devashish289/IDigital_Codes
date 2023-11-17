import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FarmingAssistantService } from '../farming-assistant.service';

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profile.component.html',
  styleUrls: ['./view-profile.component.css']
})
export class ViewProfileComponent implements OnInit {
  userId : String;
  loginD:any;
  password:String;
  viewP : any;
  huhu:any;
  constructor(private farmingAssistantService : FarmingAssistantService, private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.userId = this.route.snapshot.params['userId'];
    console.log(this.userId);
    this.farmingAssistantService.getLoginDetails(this.userId).subscribe(data => {
      this.loginD=data;
      console.log(this.loginD);
    });
    this.viewProfile(this.userId);
  }
  viewProfile(userId : String){
    this.farmingAssistantService.viewProfile(userId)
    .subscribe(data=>{
      this.viewP=data;
      console.log(this.viewP);
    });
  }
  

  updateProfile(userId : String) {
    this.router.navigate(['edit-profile',userId]);
  }

  cancel(){
    this.router.navigate(['/home']);
  }
}
