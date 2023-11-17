import { Component, OnInit } from '@angular/core';
import { ChatboxDto } from '../chatbox-dto';
import { ChatboxService } from '../chatbox.service';

@Component({
  selector: 'app-search-chats',
  templateUrl: './search-chats.component.html',
  styleUrls: ['./search-chats.component.css']
})
export class SearchChatsComponent implements OnInit {
  msgId: String;
  ChatboxDto: any=new ChatboxDto();
  reloadData: any;

  constructor(private service:ChatboxService) { }

 
  public Search(){
    let resp= this.service.getMsgDetails(this.msgId);
    resp.subscribe((data)=>this.ChatboxDto=data);
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

    ngOnInit() {
    }
}
