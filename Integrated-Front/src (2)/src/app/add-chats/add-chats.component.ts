import { Component, OnInit } from '@angular/core';
import { ChatboxDto } from '../chatbox-dto';
import { ChatboxService } from '../chatbox.service';

@Component({
  selector: 'app-add-chats',
  templateUrl: './add-chats.component.html',
  styleUrls: ['./add-chats.component.css']
})
export class AddChatsComponent implements OnInit {
  message:any;
  ChatboxDto:ChatboxDto=new ChatboxDto();
  router:any;

  constructor(private service:ChatboxService) { }

  ngOnInit(){
  }
  public AddMsgNow(){
    let resp=this.service.addMsg(this.ChatboxDto);
    resp.subscribe((data)=>this.message=data);
    }

}
