import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Advertisement } from '../Advertisement';
import { AdvertisementService } from '../advertisement.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-my-advertisements',
  templateUrl: './my-advertisements.component.html',
  styleUrls: ['./my-advertisements.component.css']
})
export class MyAdvertisementsComponent implements OnInit {

  constructor(private adService : AdvertisementService,private router:Router,private loginService:LoginService) { }
  myAdsArr:Advertisement[]=[];
  response:string;
  role:string;


  ngOnInit(): void {
    this.viewMyAdvertisements(this.loginService.userId);
    this.role=this.loginService.role;
  }

  viewMyAdvertisements(userId:string)
{
  this.adService.viewMyAdvertisements(userId).subscribe(data=>
    {
      this.myAdsArr=data;
      console.log(this.myAdsArr)
      for(let i=0;i<this.myAdsArr.length;i++)
      {
        if(this.myAdsArr[i].advertisementCropId.localeCompare('C10001')==0)
        {
          this.myAdsArr[i].description="The crop name is wheat. Wheat, any of several species of cereal grasses of the genus Triticum and their edible grains. Wheat is one of the oldest and most important of the cereal crops. It is used to make bread, pasta, cake, crackers, cookies, pastries, flour, and many other foodstuffs";
          this.myAdsArr[i].cropName="Wheat";
          this.myAdsArr[i].cropImage="../assets/Wheat.jpg";
        }
        else if(this.myAdsArr[i].advertisementCropId.localeCompare('C10002')==0)
        {
          this.myAdsArr[i].description="The crop name is Rice. the starchy seeds of an annual southeast Asian cereal grass ( Oryza sativa ) that are cooked and used for food also : this cereal grass that is widely cultivated in warm climates for its seeds and by-products — compare wild rice It's about 1.2 metres (4 feet) in height.";
          this.myAdsArr[i].cropName="Rice";
          this.myAdsArr[i].cropImage="../assets/Rice.jpg";
        }
        else if(this.myAdsArr[i].advertisementCropId.localeCompare("C10004")==0)
        {
          this.myAdsArr[i].description="Corn is a tall annual cereal grass (Zea mays) that is widely grown for its large elongated ears of starchy seeds. The seeds, which are also known as corn, are used as food for humans and livestock and as a source of biofuel and can be processed into a wide range of useful chemicals.";
          this.myAdsArr[i].cropName="Corn";
          this.myAdsArr[i].cropImage="../assets/Corn.jpg";
        }
        else if(this.myAdsArr[i].advertisementCropId.localeCompare("C10006")==0)
        {
          this.myAdsArr[i].description="Barley (Hordeum vulgare), a member of the grass family, is a major cereal grain grown in temperate climates globally. ... It is used in soups and stews, and in barley bread of various cultures. Barley grains are commonly made into malt in a traditional and ancient method of preparation.";
          this.myAdsArr[i].cropName="Barley";
          this.myAdsArr[i].cropImage="../assets/Barley.jpg";
        }
      }
    })
}

deleteAdvertisement(advertisementId:string)
{
  this.adService.deleteAdvertisement(advertisementId).subscribe(data=>
    {
      this.response=data;
      console.log(this.response)
      for(var i=0;i<this.myAdsArr.length;i++)
      {
        if(this.myAdsArr[i].advertisementId.localeCompare(advertisementId)==0)
        {
          this.myAdsArr.splice(i,1);
        }
      }
    })
}

viewAdvertisement(ad:Advertisement)
{
  this.adService.advertisementId=ad.advertisementId;
  this.router.navigate(['/viewAd']);
}

}
