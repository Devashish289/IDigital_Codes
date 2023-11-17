import { Component } from '@angular/core';
import { MspService } from './msp.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'UserService';
  constructor(private mspSer:MspService)
  {
  }
  ngOnInit()
  {
    this.mspSer.getMsp();
  }
}
