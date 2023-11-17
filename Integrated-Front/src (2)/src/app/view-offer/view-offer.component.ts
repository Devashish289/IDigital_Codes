import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from '../login.service';
import { offer } from '../offer';
import { OfferService } from '../offer.service';

@Component({
  selector: 'app-view-offer',
  templateUrl: './view-offer.component.html',
  styleUrls: ['./view-offer.component.css']
})
export class ViewOfferComponent implements OnInit {

  offer1:offer[]=[];
  
  person:string;
  msg:string;
  constructor(private offerSer:OfferService,private loginService:LoginService) { }

  ngOnInit() {
      this.person=this.loginService.role;
    this.offerSer.getOffers(this.person).subscribe(data=>{this.offer1=data;this.msg=undefined,console.log(this.offer1)},
    error=>{console.log(error);this.msg=error.error.message;});
      console.log(this.offer1);
    
  }



}
