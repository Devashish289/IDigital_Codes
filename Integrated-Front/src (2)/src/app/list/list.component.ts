import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ChatboxDto } from '../chatbox-dto';
import { ChatboxService } from '../chatbox.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  
  
    chats: Observable<ChatboxDto[]>;
  
    constructor(private service:ChatboxService ,
      private router: Router) {}
  
    ngOnInit() {
      this.reloadData();
    }
  
    reloadData() {
      this.chats = this.service.getAllMsg();
    }
  
   
    RemoveMsg(msgId: String) {
      this.service.deleteMsg(msgId)
        .subscribe(
          data => {
            console.log(data);
            this.reloadData();
          },
          error => console.log(error));
    }
  
  
  
  }
