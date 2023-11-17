import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { FarmingAssistantService } from './farming-assistant.service';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ViewProfileComponent } from './view-profile/view-profile.component';
import { AddAdvertisementComponent } from './add-advertisement/add-advertisement.component';
import { HomeComponent } from './home/home.component';
import { MyAdvertisementsComponent } from './my-advertisements/my-advertisements.component';
import { ViewAdvertisementComponent } from './view-advertisement/view-advertisement.component';
import { FarmerComponent } from './farmer/farmer.component';
import { AuthorityComponent } from './authority/authority.component';
import { RetailerComponent } from './retailer/retailer.component';
import { ViewMspComponent } from './view-msp/view-msp.component';
import { AddMspComponent } from './add-msp/add-msp.component';
import { UpdateDeleteMspComponent } from './update-delete-msp/update-delete-msp.component';
import { MspService } from './msp.service';
import { ViewOfferComponent } from './view-offer/view-offer.component';
import { AddOfferComponent } from './add-offer/add-offer.component';
import { ViewOfferByIdComponent } from './view-offer-by-id/view-offer-by-id.component';
import { AddStockComponent } from './add-stock/add-stock.component';
import { StockDetailComponent } from './stock-detail/stock-detail.component';
import { StockService } from './stock.service';
import { ViewStockComponent } from './view-stock/view-stock.component';
import { CommonModule } from '@angular/common';
import { ComplaintService } from './complaint.service';
import { UpdateComplaintComponent } from './update-complaint/update-complaint.component';
import { ViewComplaintComponent } from './view-complaint/view-complaint.component';
import { ListComponent } from './list/list.component';
import { AddChatsComponent } from './add-chats/add-chats.component';
import { SearchChatsComponent } from './search-chats/search-chats.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    EditProfileComponent,
    RegisterComponent,
    LoginComponent,
    ViewProfileComponent,
    AddAdvertisementComponent,
    HomeComponent,
    MyAdvertisementsComponent,
    ViewAdvertisementComponent,
    FarmerComponent,
    AuthorityComponent,
    RetailerComponent,
    ViewMspComponent,
    AddMspComponent,
    UpdateDeleteMspComponent,
    ViewOfferComponent,
    AddOfferComponent,
    ViewOfferByIdComponent,
    ViewStockComponent,
    AddStockComponent,
    StockDetailComponent,
    UpdateComplaintComponent,
    ViewComplaintComponent,
    ListComponent,
    AddChatsComponent,
    SearchChatsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    CommonModule
  
  ],
  providers: [FarmingAssistantService,MspService,StockService,ComplaintService],
  bootstrap: [AppComponent]
})
export class AppModule { }
