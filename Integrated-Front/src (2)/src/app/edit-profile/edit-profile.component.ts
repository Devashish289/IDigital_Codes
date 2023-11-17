import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FarmingAssistantService } from '../farming-assistant.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  data:any={};
  userId:any;
  huhu:any;
  resss:any;
  Role:any=['Farmer','Supplier','Retailer'];
  showDiv=false;
  roleName:any=[];
  profileData:any=[];
  constructor(private router:Router, private route:ActivatedRoute, private farmingAssistantService:FarmingAssistantService) { }

  ngOnInit(): void {
    this.userId = this.route.snapshot.params['userId'];
    this.viewProfile(this.userId);
  }
  
  viewProfile(userId){
    this.farmingAssistantService.viewProfile(userId).subscribe((res:any) =>{
      this.resss = res;
      console.log(this.resss);
      });
  }
  changeRole(e) {
    this.roleName.setValue(e.target.value, {
      onlySelf: true
    })
  }

  updateProfile(resss){
    console.log('updating',resss)
    this.showDiv=true;
    this.resss=resss;
  }
  update() {
    console.log(this.resss)
    this.farmingAssistantService.updateProfile(this.resss).subscribe((res:any) => {
      alert("Profile updation initiated successfully");
      this.showDiv = false;
      this.router.navigate(['/home']);
    },
    (error) =>{
      alert("User details are not updated,please try again");
    })
    console.log(this.resss)
  }
}
