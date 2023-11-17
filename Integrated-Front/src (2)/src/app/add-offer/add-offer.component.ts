import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { offer } from '../offer';
import { OfferService } from '../offer.service';

@Component({
  selector: 'app-add-offer',
  templateUrl: './add-offer.component.html',
  styleUrls: ['./add-offer.component.css']
})
export class AddOfferComponent implements OnInit {

  offer:offer=new offer();
  myId:number;
  msg:string;
  errorMsg:string;
  constructor(private offerSer:OfferService) { }

  ngOnInit(): void {
  }

  
  addOffer(){
    this.offerSer.addOffer(this.offer).subscribe((data)=>{
      console.log("data",data);
      this.msg=data;this.errorMsg=undefined;this.offer=new offer();
    },
    error=>{this.errorMsg=JSON.parse(error.error).message;
    console.log(this.errorMsg);this.msg=undefined});
  }}


    

  








