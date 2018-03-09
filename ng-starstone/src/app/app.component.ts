import { Component } from '@angular/core';
import {DataService} from "./data-service.service";
import {PageServiceService} from "./page-service.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Starstone';

  constructor(public pageService: PageServiceService) {

  }

}
