import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { StarstoneViewComponent } from './starstone-view/starstone-view.component';
import {HttpClientModule} from "@angular/common/http";
import {DataService} from "./data-service.service";
import {FormsModule} from "@angular/forms";
import {PageServiceService} from "./page-service.service";
import { AllcardsViewComponent } from './allcards-view/allcards-view.component';
//import { AllcardsViewComponent } from './allcards-view/allcards-view.component';


@NgModule({
  declarations: [
    AppComponent,
    StarstoneViewComponent,
    AllcardsViewComponent,
    //AllcardsViewComponent
  ],
  imports: [
    BrowserModule, HttpClientModule,FormsModule
  ],
  providers: [DataService,PageServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
