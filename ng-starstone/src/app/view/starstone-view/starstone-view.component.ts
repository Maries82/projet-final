import {Component, OnInit} from '@angular/core';
import {DataService} from '../../data-service.service';
import {Card, CardOption} from '../../model/card';
import {Princess} from '../../model/princess';
import {Zerg} from "../../model/zerg";

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
  princess: Princess;
  zerg: Zerg;

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


  getPrincessHand(): Card[]{


    //console.log(this.princessCards);
    const list = this.princessCards.filter(o => o.selected).map(o=>o.card);

    //console.log(list);

    if (list.length == 8){
      return list;
    } else if (list.length < 8) {
      console.log("You need to have 8 cards in your hand, please, keep going.")
    } else {
      console.log("You can't have more than 8 cards in your hand. Please drop the surplus");
    }

  }

  getZergHand(): Card[]{


    //console.log(this.zergCards);
    const list = this.zergCards.filter(o => o.selected).map(o=>o.card);

    //console.log(list);

    if (list.length == 8){
      return list;
    } else if (list.length < 8) {
      console.log("You need to have 8 cards in your hand, please, keep going.")
    } else {
      console.log("You can't have more than 8 cards in your hand. Please drop the surplus");
    }

  }

  startGame(){
    if (this.getPrincessHand() != [] && this.getZergHand() != []){
      console.log("Start Game !!!!");
      console.log(this.getPrincessHand());
      console.log(this.getZergHand());
      return this.dataService.sendHands(this.getPrincessHand(),this.getZergHand());
    }
  }

/*  sendZergHand() {
    if (this.princessHand.length == 8){
      this.filledHand = true;


    return this.dataService.sendZergHand(this.zerg)
      .then(() => this.selectedUser.topics.push(Object.assign({}, this.createdTopic)))
      .catch(e => alert(e.message));

    }
  }*/
}
/*
createTopic() {
  return this.dataService.createTopic(this.createdTopic)
    .then(() => this.selectedUser.topics.push(Object.assign({}, this.createdTopic)))
    .catch(e => alert(e.message));
}*/
