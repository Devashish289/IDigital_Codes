import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Msp } from '../Msp';
import { MspService } from '../msp.service';

@Component({
  selector: 'app-update-delete-msp',
  templateUrl: './update-delete-msp.component.html',
  styleUrls: ['./update-delete-msp.component.css']
})
export class UpdateDeleteMspComponent implements OnInit {
  msp:Msp[]=[];
  flag:boolean;
  cropId:string;
  
  constructor(private mspSer:MspService) { }
  msp1=new FormGroup({
    cropName:new FormControl('',[Validators.required,Validators.pattern(/^[A-Z][a-z]{3,10}[\.]{0,1}[A-Za-z\s]{0,10}$/)]),
    mspPrice:new FormControl('',[Validators.required,Validators.pattern(/^[0-9]{0,8}$/)])
  });
  ngOnInit(): void {
    this.msp=[];
    this.msp=this.mspSer.mspDb;
          this.flag=true;
          if(this.flag!=true){
            this.flag=false;}
  }

  fetchValues(cropId){
    this.cropId=cropId;
    this.mspSer.getById(cropId).subscribe((data:any)=>{this.msp1.controls['cropName'].setValue(data.cropName);
    this.msp1.controls['mspPrice'].setValue(data.mspPrice)
  })
  }
  updateMsp(){

    this.mspSer.updateMsp(
      new Msp(this.cropId,this.msp1.controls['cropName'].value,
    this.msp1.controls['mspPrice'].value)).subscribe(data=>{
      console.log(data);
      window.location.reload()

    })

    
  }
  deleteMsp(cropId){
    this.mspSer.deleteMsp(cropId).subscribe(data=>{console.log(data)
      window.location.reload()});  
  }


}
