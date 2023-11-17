import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddAdvertisementComponent } from './add-advertisement/add-advertisement.component';
import { AddChatsComponent } from './add-chats/add-chats.component';
import { AddMspComponent } from './add-msp/add-msp.component';
import { AddOfferComponent } from './add-offer/add-offer.component';
import { AddStockComponent } from './add-stock/add-stock.component';
import { AuthorityComponent } from './authority/authority.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { FarmerComponent } from './farmer/farmer.component';
import { HomeComponent } from './home/home.component';
import { ListComponent } from './list/list.component';
import { LoginComponent } from './login/login.component';
import { MyAdvertisementsComponent } from './my-advertisements/my-advertisements.component';
import { RegisterComponent } from './register/register.component';
import { RetailerComponent } from './retailer/retailer.component';
import { SearchChatsComponent } from './search-chats/search-chats.component';
import { StockDetailComponent } from './stock-detail/stock-detail.component';
import { UpdateComplaintComponent } from './update-complaint/update-complaint.component';
import { UpdateDeleteMspComponent } from './update-delete-msp/update-delete-msp.component';
import { ViewAdvertisementComponent } from './view-advertisement/view-advertisement.component';
import { ViewComplaintComponent } from './view-complaint/view-complaint.component';
import { ViewMspComponent } from './view-msp/view-msp.component';
import { ViewOfferByIdComponent } from './view-offer-by-id/view-offer-by-id.component';
import { ViewOfferComponent } from './view-offer/view-offer.component';
import { ViewProfileComponent } from './view-profile/view-profile.component';
import { ViewStockComponent } from './view-stock/view-stock.component';

const routes: Routes = [
  { path:'', component:LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path:'edit-profile/:userId', component:EditProfileComponent},
  { path:'view-profile/:userId', component:ViewProfileComponent},
  {path : 'home', component : HomeComponent},
  {path : 'addAd', component : AddAdvertisementComponent},
  {path : 'myAds', component : MyAdvertisementsComponent},
  {path : 'viewAd', component : ViewAdvertisementComponent},
  {path : 'farmer', component : FarmerComponent},
  {path : 'retailer', component : RetailerComponent},
  {path : 'authority', component : AuthorityComponent},
  {path : 'addMsp', component : AddMspComponent},
  {path : 'viewMsp', component : ViewMspComponent},
  {path : 'updateDeleteMsp', component : UpdateDeleteMspComponent},
  {path : 'getoffers', component : ViewOfferComponent},
  {path : 'addoffer', component : AddOfferComponent},
  {path : 'viewById/:offer_Id', component : ViewOfferByIdComponent},
  {path : 'addStock', component : AddStockComponent},
  {path : 'viewStock', component : ViewStockComponent},
  {path : 'stockDetail', component : StockDetailComponent},
  {path : 'updateComplaint', component : UpdateComplaintComponent},
  {path : 'viewComplaint', component : ViewComplaintComponent},
  {path : 'search', component :SearchChatsComponent},
  {path : 'list', component :ListComponent },
  {path : 'AddChats', component : AddChatsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
