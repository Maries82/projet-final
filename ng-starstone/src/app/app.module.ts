import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { StarstoneViewComponent } from './starstone-view/starstone-view.component';
import {HttpClientModule} from "@angular/common/http";
import {DataService} from "./data-service.service";
import {FormsModule} from "@angular/forms";
import { AllcardsViewComponent } from './allcards-view/allcards-view.component';


@NgModule({
  declarations: [
    AppComponent,
    StarstoneViewComponent,
    AllcardsViewComponent
  ],
  imports: [
    BrowserModule, HttpClientModule,FormsModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
