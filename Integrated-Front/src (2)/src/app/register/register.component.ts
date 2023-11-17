import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FarmingAssistantService, Login, Profile } from '../farming-assistant.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  data:any={};
  lastUserId:any;
  Role:any=['Farmer','Supplier','Retailer'];
  roleName:any=[];
  password:String;
  constructor(private router:Router, private farmingAssistantService:FarmingAssistantService) {}

  ngOnInit(): void {
  }

  changeRole(e) {
    this.roleName.setValue(e.target.value, {
      onlySelf: true
    })
  }

getUserId(register:Profile,login:Login)
{
  this.farmingAssistantService.getUserIdbyRole(login.role).subscribe(data=>
    {
      var a;
      this.lastUserId=data
      if(login.role=='Farmer'){
      a=this.lastUserId.split("F");
      var s = parseInt(a[1]);
      var k= s+1;
      this.lastUserId ="F"+k;
    }
      else if(login.role=='Supplier'){
      a = this.lastUserId.split("S");
      var s = parseInt(a[1]);
      var k= s+1;
      this.lastUserId ="S"+k;
    }
      else if(login.role=='Retailer'){
      a = this.lastUserId.split("R");
      var s = parseInt(a[1]);
      var k= s+1;
      this.lastUserId ="R"+k;
    }
      console.log(this.lastUserId);
      register.userId = this.lastUserId;
      login.userId = this.lastUserId;
      this.submit(register, login);
    })
    
} 

  submit(register:Profile, login:Login){
    console.log(register.userId, login.userId);
    this.farmingAssistantService.addLoginDetails(login.userId,login.password,login.role).subscribe((res:any) => {
    })
      this.farmingAssistantService.registerUser(register).subscribe ((res: any) => {
        alert("User creation initiated successfully, your userId is " +this.lastUserId)
        this.router.navigate(['/view-profile',this.lastUserId]);
      },
      (error) =>{
        alert("User creation is not successful, please try again")
      });
    }
}
