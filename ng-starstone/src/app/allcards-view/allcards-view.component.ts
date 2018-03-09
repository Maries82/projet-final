import { Component, OnInit } from '@angular/core';
import {DataService} from "../data-service.service";
import {Card} from "../model/card";

@Component({
  selector: 'app-allcards-view',
  templateUrl: './allcards-view.component.html',
  styleUrls: ['./allcards-view.component.css']
})
export class AllcardsViewComponent implements OnInit {


  allCards: Card[] = [];

  constructor(public dataService: DataService) {
    dataService.fetchGlobalDeck()
      .then(cards => this.allCards = cards)
      .then(cards => console.log("cards : " + cards));
  }

  ngOnInit() {
  }

  fetchGlobalDeck(){
    this.dataService.fetchGlobalDeck()
      .then(cards => this.allCards = cards)
      .then(cards => console.log("cards : " + cards));
    //.then(cards => this.allCards = cards);
    //.then(() => console.log("AllCards : " + this.allCards))
  }

}
