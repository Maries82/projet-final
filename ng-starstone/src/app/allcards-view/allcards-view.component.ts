import { Component, OnInit } from '@angular/core';
import {DataService} from "../data-service.service";
import {Card, CardOption} from "../model/card";
import {PageServiceService} from "../page-service.service";

@Component({
  selector: 'app-allcards-view',
  templateUrl: './allcards-view.component.html',
  styleUrls: ['./allcards-view.component.css']
})
export class AllcardsViewComponent implements OnInit {


  allCards: CardOption[];

  cardBoughtHand : Card[] = [];

 selectedCardToBuy: boolean = false;


  constructor(public dataService: DataService, public pageService : PageServiceService) {
    dataService.fetchGlobalDeck()
      .then(cards => this.allCards = cards.map(c => new CardOption(c)))
      .then(cards => console.log("cards : " + cards));
  }

  ngOnInit() {
  }

  getCardsBought(): Card[] {
    console.log(this.cardBoughtHand);

    const boughtCard = this.allCards.filter(o => o.selected).map(o => o.card);


console.log(boughtCard);
    /*this.selectedCardToBuy = true;
    this.selectedCards = false;*/
    this.cardBoughtHand = boughtCard;
console.log(this.cardBoughtHand);
    return boughtCard;
  }

}
