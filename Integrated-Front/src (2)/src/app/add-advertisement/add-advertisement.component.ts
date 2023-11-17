import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { strict } from 'assert';
import { AdvertisementService } from '../advertisement.service';
import { LoginService } from '../login.service';
import { AdvertisementEntity } from './AdvertisementEntity';

@Component({
  selector: 'app-add-advertisement',
  templateUrl: './add-advertisement.component.html',
  styleUrls: ['./add-advertisement.component.css']
})
export class AddAdvertisementComponent implements OnInit {

  constructor(private fb:FormBuilder,private adService:AdvertisementService,private router:Router,private loninService:LoginService) { }

  lastAdId:string;
  selectedPurpose:string;
  selectedtargetAudience:string;
  selectElement:any;
  quantity:string;
  price:string;
  cropId:string;
  advertisement:AdvertisementEntity;
  responseEntity:AdvertisementEntity;

  ngOnInit(): void {
    this.getAdvertisementId();
    

  }

  addAdvertisementForm = this.fb.group(
    {
      advertisementId : [''],
      advertisementPricePerQuintal : ['', Validators.required],
      advertisementCropId : ['', Validators.required],
      quantityInQuintals : ['', Validators.required],
      purpose : ['', Validators.required],
      targetedAudience : ['', Validators.required],
      advertisementOwnerId : ['', Validators.required],
    }
  );

  get advertisementId()
{
  return this.addAdvertisementForm.get('advertisementId');
}
  get advertisementPricePerQuintal()
{
  return this.addAdvertisementForm.get('advertisementPricePerQuintal');
}
  get quantityInQuintals()
{
  return this.addAdvertisementForm.get('quantityInQuintals');
}
  get advertisementCropId()
{
  return this.addAdvertisementForm.get('advertisementCropId');
}

getAdvertisementId()
{
  this.adService.getAdvertisementId().subscribe(data=>
    {
      this.lastAdId=data
      var a=this.lastAdId.split("d");
      var s = parseInt(a[1]);
      var k= s+1;
      this.lastAdId = a[0]+"d"+k;
      console.log(this.lastAdId);
    })
}

onSubmit()
{
  console.log("swbqnwdvvwh")
  console.log(this.addAdvertisementForm.value.advertisementId);
  console.log(this.addAdvertisementForm.value.advertisementPricePerQuintal);
  console.log(this.addAdvertisementForm.value.advertisementCropId);
  console.log(this.addAdvertisementForm.value.quantityInQuintals);
  console.log(this.addAdvertisementForm.value.purpose);
  console.log(this.addAdvertisementForm.value.targetedAudience);
    // this.selectElement = document.querySelector('#purpose');
    // this.selectedPurpose = this.selectElement.options[this.selectElement.selectedIndex].value;
    // console.log(this.selectedPurpose);
    // this.selectElement = document.querySelector('#targetAudience');
    // this.selectedtargetAudience = this.selectElement.options[this.selectElement.selectedIndex].value;
    // console.log(this.selectedtargetAudience)
    this.advertisement = new AdvertisementEntity(this.lastAdId,this.addAdvertisementForm.value.advertisementPricePerQuintal,this.addAdvertisementForm.value.advertisementCropId,this.addAdvertisementForm.value.quantityInQuintals,this.addAdvertisementForm.value.purpose,this.addAdvertisementForm.value.targetedAudience,this.loninService.userId);

    this.adService.addAdvertisement(this.advertisement).subscribe(data=>
      {
        this.responseEntity=data;
        if(this.responseEntity.advertisementId.localeCompare(this.lastAdId)==0)
        {
          this.router.navigate(['/myAds']);
        }
      });



}

 

}
