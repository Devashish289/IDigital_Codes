import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Msp } from '../Msp';
import { MspService } from '../msp.service';

@Component({
  selector: 'app-add-msp',
  templateUrl: './add-msp.component.html',
  styleUrls: ['./add-msp.component.css']
})
export class AddMspComponent implements OnInit {
  flagCropName=false;
  constructor(private mspSer:MspService,private router:Router) { }
  msp=new FormGroup({
  cropName:new FormControl('',[Validators.required,Validators.pattern(/^[A-Z][a-z]{3,10}[\.]{0,1}[A-Za-z\s]{0,10}$/)]),
  mspPrice:new FormControl('',[Validators.required,Validators.pattern(/^[0-9]{0,8}$/)])
});

  ngOnInit(): void {
  }
  addMsp(){
    if(this.msp.valid)
    {
    let cropName = this.msp.get('cropName').value;
    let mspPrice = this.msp.get('mspPrice').value;
    let cropId = this.mspSer.mspDb[this.mspSer.mspDb.length-1].cropId;
      let newCropId=parseInt(cropId.substring(1))+1;
      cropId='C'+newCropId;
      console.log(cropId)


    
        let tempMsp:Msp=new Msp(cropId,cropName,mspPrice);
        this.mspSer.tempMsp=tempMsp;
        this.mspSer.addMsp(tempMsp).subscribe(data=>{console.log(data)
        window.location.reload()}); 
        // this.router.navigateByUrl("/home"); 
        console.log("Done");
      
    }
  }


}
