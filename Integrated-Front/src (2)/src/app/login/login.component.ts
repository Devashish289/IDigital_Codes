import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FarmingAssistantService } from '../farming-assistant.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userId:String;
  public model:any = {};
  constructor(private router:Router,private farmingAssistantService:FarmingAssistantService, private route:ActivatedRoute, private loginService:LoginService) {}

  ngOnInit(): void {
    this.userId = this.route.snapshot.params['userId'];
  }

  login(){
    console.log(this.model);
    console.log(this.model.userId);
    if(this.model.userId && this.model.password && this.model.role){
      this.validate();
    } else{
      alert("Either of User Id / Password is NULL");
    }
    this.router.navigate(['']);
  }
  validate(){
   this.farmingAssistantService.login(this.model.userId,this.model.password,this.model.role).subscribe((res:any) => {
    console.log('The user obj is ', res);
      this.farmingAssistantService.user=res;
      console.log(this.model.role);
      if (this.model.role === 'Farmer') {
        this.loginService.userId=this.model.userId;
      this.loginService.role=this.model.role;
        this.router.navigate(['/home']);
      } else if (this.model.role === 'Supplier') {
        this.loginService.userId=this.model.userId;
      this.loginService.role=this.model.role;
        this.router.navigate(['/home']);
      } else if(this.model.role === 'Retailer') {
        this.loginService.userId=this.model.userId;
      this.loginService.role=this.model.role;
        this.router.navigate(['/home']);
      } else if(this.model.role === 'Authority') {
        this.loginService.userId=this.model.userId;
      this.loginService.role=this.model.role;
        this.router.navigate(['/authority']);
      }
      this.loginService.userId=this.model.userId;
      this.loginService.role=this.model.role;
      //this.router.navigate(['/home']);
      
    },
    (error)=>{
     alert("Invalid login credentials")
    }
    )
  }

}
