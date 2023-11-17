import { Component, OnInit } from '@angular/core';
import { Msp } from '../Msp';
import { MspService } from '../msp.service';

@Component({
  selector: 'app-view-msp',
  templateUrl: './view-msp.component.html',
  styleUrls: ['./view-msp.component.css']
})
export class ViewMspComponent implements OnInit {

  msp:Msp[]=[];
  flag:boolean;
  constructor(private mspSer:MspService ) { }

  ngOnInit(): void {
    this.msp=[];
      
          this.msp=this.mspSer.mspDb;
          this.flag=true;
          console.log(this.msp+"view component");
    if(this.flag!=true){
      this.flag=false;
    }
  }

}
