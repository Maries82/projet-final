import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { StarstoneViewComponent } from './view/starstone-view/starstone-view.component';
import {HttpClientModule} from "@angular/common/http";
import {DataService} from "./data-service.service";
import { GameViewComponent } from './view/game-view/game-view.component';


@NgModule({
  declarations: [
    AppComponent,
    StarstoneViewComponent,
    GameViewComponent
  ],
  imports: [
    BrowserModule, HttpClientModule,
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
