import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { StarstoneViewComponent } from './starstone-view/starstone-view.component';
import {HttpClientModule} from "@angular/common/http";
import {DataService} from "./data-service.service";


@NgModule({
  declarations: [
    AppComponent,
    StarstoneViewComponent
  ],
  imports: [
    BrowserModule, HttpClientModule,
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
