import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Advertisement } from '../Advertisement';
import { AdvertisementService } from '../advertisement.service';
import { LoginService } from '../login.service';
import { ViewAdvertisementComponent } from '../view-advertisement/view-advertisement.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private adService : AdvertisementService,private router:Router,private loginService : LoginService) { }
  adArr:Advertisement[]=[];
  myAdsArr:Advertisement[]=[];
  userId:string;
  role:string;
  response:string;
  cropPic:string;
  description:string;

  ngOnInit(): void {
    this.cropPic='wheat';
    this.viewAdvertisements(this.loginService.userId,this.loginService.role);
    this.userId=this.loginService.userId;
    console.log(this.userId);
    // this.viewMyAdvertisements('S10001');
    // this.deleteAdvertisement('Ad10003');
  }
viewAdvertisements(userId:string,role:string)
{
  this.adService.viewAdvertisements(userId,role).subscribe(data=>
    {
      console.log(data)
      this.adArr=data;
      for(let i=0;i<this.adArr.length;i++)
      {
        if(this.adArr[i].advertisementCropId.localeCompare('C10001')==0)
        {
          this.adArr[i].description="The crop name is wheat. Wheat, any of several species of cereal grasses of the genus Triticum and their edible grains. Wheat is one of the oldest and most important of the cereal crops. It is used to make bread, pasta, cake, crackers, cookies, pastries, flour, and many other foodstuffs";
          this.adArr[i].cropName="Wheat";
          this.adArr[i].cropImage="../assets/Wheat.jpg";
        }
        else if(this.adArr[i].advertisementCropId.localeCompare('C10002')==0)
        {
          this.adArr[i].description="The crop name is Rice. the starchy seeds of an annual southeast Asian cereal grass ( Oryza sativa ) that are cooked and used for food also : this cereal grass that is widely cultivated in warm climates for its seeds and by-products — compare wild rice It's about 1.2 metres (4 feet) in height.";
          this.adArr[i].cropName="Rice";
          this.adArr[i].cropImage="../assets/Rice.jpg";
        }
        else if(this.adArr[i].advertisementCropId.localeCompare("C10004")==0)
        {
          this.adArr[i].description="Corn is a tall annual cereal grass (Zea mays) that is widely grown for its large elongated ears of starchy seeds. The seeds, which are also known as corn, are used as food for humans and livestock and as a source of biofuel and can be processed into a wide range of useful chemicals.";
          this.adArr[i].cropName="Corn";
          this.adArr[i].cropImage="../assets/Corn.jpg";
        }
        else if(this.adArr[i].advertisementCropId.localeCompare("C10006")==0)
        {
          this.adArr[i].description="Barley (Hordeum vulgare), a member of the grass family, is a major cereal grain grown in temperate climates globally. ... It is used in soups and stews, and in barley bread of various cultures. Barley grains are commonly made into malt in a traditional and ancient method of preparation.";
          this.adArr[i].cropName="Barley";
          this.adArr[i].cropImage="../assets/Barley.jpg";
        }
      }
    })
}

viewMyAdvertisements(userId:string)
{
  this.adService.viewMyAdvertisements(userId).subscribe(data=>
    {
      this.myAdsArr=data;
      console.log(this.myAdsArr)
    })
}

addAdvertisement()
{
  this.router.navigate(['addAd']);
}

deleteAdvertisement(advertisementId:string)
{
  this.adService.deleteAdvertisement(advertisementId).subscribe(data=>
    {
      this.response=data;
      console.log(this.response)
    })
}

viewAdvertisement(ad:Advertisement)
{

    this.adService.advertisementId=ad.advertisementId;
    console.log(this.adService.advertisementId)
    this.router.navigate(['/viewAd']);
    
}

viewProfile()
{
  this.router.navigate(['view-profile',this.userId])
}

}
