import { Component, OnInit } from '@angular/core';
import { Advertisement } from '../Advertisement';
import { AdvertisementService } from '../advertisement.service';

@Component({
  selector: 'app-view-advertisement',
  templateUrl: './view-advertisement.component.html',
  styleUrls: ['./view-advertisement.component.css']
})
export class ViewAdvertisementComponent implements OnInit {

  constructor(private adservice :AdvertisementService) { }

  advertisement:Advertisement;

  ngOnInit(): void {
     this.viewAd(this.adservice.advertisementId)
  }

  viewAd(advertisementId:string)
  {
    this.adservice.viewAd(advertisementId).subscribe(data=>
      {
        this.advertisement=data;
        if(this.advertisement.advertisementCropId.localeCompare("C10001")==0)
        {
          this.advertisement.description="The crop name is wheat. Wheat, any of several species of cereal grasses of the genus Triticum and their edible grains. Wheat is one of the oldest and most important of the cereal crops. It is used to make bread, pasta, cake, crackers, cookies, pastries, flour, and many other foodstuffs";
          this.advertisement.cropName="Wheat";
          this.advertisement.cropImage="../assets/Wheat.jpg";
        }
        else if(this.advertisement.advertisementCropId.localeCompare("C10002")==0)
        {
          this.advertisement.description="The crop name is Rice. the starchy seeds of an annual southeast Asian cereal grass ( Oryza sativa ) that are cooked and used for food also : this cereal grass that is widely cultivated in warm climates for its seeds and by-products — compare wild rice It's about 1.2 metres (4 feet) in height.";
          this.advertisement.cropName="Rice";
          this.advertisement.cropImage="../assets/Rice.jpg";
        }
        else if(this.advertisement.advertisementCropId.localeCompare("C10004")==0)
        {
          this.advertisement.description="Corn is a tall annual cereal grass (Zea mays) that is widely grown for its large elongated ears of starchy seeds. The seeds, which are also known as corn, are used as food for humans and livestock and as a source of biofuel and can be processed into a wide range of useful chemicals.";
          this.advertisement.cropName="Corn";
          this.advertisement.cropImage="../assets/Corn.jpg";
        }
        else if(this.advertisement.advertisementCropId.localeCompare("C10006")==0)
        {
          this.advertisement.description="Barley (Hordeum vulgare), a member of the grass family, is a major cereal grain grown in temperate climates globally. ... It is used in soups and stews, and in barley bread of various cultures. Barley grains are commonly made into malt in a traditional and ancient method of preparation.";
          this.advertisement.cropName="Barley";
          this.advertisement.cropImage="../assets/Barley.jpg";
        }

      })
  }

}
