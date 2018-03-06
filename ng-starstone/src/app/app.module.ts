import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { StarstoneViewComponent } from './starstone-view/starstone-view.component';


@NgModule({
  declarations: [
    AppComponent,
    StarstoneViewComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
