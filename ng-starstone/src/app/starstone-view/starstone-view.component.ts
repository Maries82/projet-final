import {Component, OnInit} from '@angular/core';
import {DataService} from '../data-service.service';
import {Card, CardOption} from '../model/card';
import {Princess} from '../model/princess';
import {Zerg} from "../model/zerg";

@Component({
  selector: 'app-starstone-view',
  templateUrl: './starstone-view.component.html',
  styleUrls: ['./starstone-view.component.css']
})
export class StarstoneViewComponent implements OnInit {

  count: number = 0;
  zergCards: CardOption[];
  zergHand: CardOption[] = [];
  princessCards: CardOption[];
  princessHand: CardOption[] = [];
  selectedZerg : boolean;
  selectedPrincess : boolean;

  filledHand : boolean = false;

  selectedCard : Card;
  princess: Princess = {
    id: 1,
    name: "princess",
    princessCards: [],
    princessHand: []
  };

  zerg: Zerg = {
    id: 2,
    name: "zerg",
    zergCards: [],
    zergHand: []}

  constructor(public dataService: DataService) {

  }

  ngOnInit() {
  }

  fetchZergDeck(){
    this.selectedZerg = true;

    this.dataService.fetchZergDeck()
      .then(zCards => this.zergCards = zCards.map(c=>new CardOption(c)));
    //.then(cards => console.log('Cards : ', cards));
  }

  fetchPrincessDeck(){
    this.selectedPrincess = true;

    this.dataService.fetchPrincessDeck()
      .then(pCards => this.princessCards = pCards.map(c=>new CardOption(c)))

  }
