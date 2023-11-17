import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { offer } from '../offer';
import { OfferService } from '../offer.service';

@Component({
  selector: 'app-view-offer-by-id',
  templateUrl: './view-offer-by-id.component.html',
  styleUrls: ['./view-offer-by-id.component.css']
})
export class ViewOfferByIdComponent implements OnInit {
offerId:string
offer:offer;
msg:string;
  constructor(private offrSer:OfferService, private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params=>{let offerId=params.get("offer_Id");console.log();
    this.offrSer.viewOffer(offerId).subscribe(data=>{this.offer=data;console.log(this.offer);this.msg=undefined},
    error=>{console.log(error);this.msg=error.error.message;console.log(this.msg);this.offer=null});   
});
  }

  goToOffers(){
    this.router.navigateByUrl("/getoffers");
  }
}
