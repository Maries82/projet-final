import {Component, OnInit} from '@angular/core';
import {DataService} from '../data-service.service';
import {Card, CardOption} from '../model/card';
import {Princess} from '../model/princess';
import {Zerg} from '../model/zerg';
import {Winner} from '../model/winner';
import {PageServiceService} from "../page-service.service";

@Component({
  selector: 'app-starstone-view',
  templateUrl: './starstone-view.component.html',
  styleUrls: ['./starstone-view.component.css']
})
export class StarstoneViewComponent implements OnInit {

  count: number = 0;
  zergCards: CardOption[];
  zergHand: Card[] = [];
  princessCards: CardOption[];
  princessHand: Card[] = [];
  selectedZerg: boolean;
  selectedPrincess: boolean;

  selectedZergHand: boolean = false;
  selectedPrincessHand: boolean = false;


  selectedPrincessRandom: boolean = false;
  selectedZergRandom: boolean = false;

  filledHand : boolean = false;

  gameStarted : boolean =false;

  resultWinners: Winner[] = [];
  resultWinner: Winner;
  resultList: Card[] = [];

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
    zergHand: []
  };

  constructor(public dataService: DataService, public pageService: PageServiceService) {

  }

  ngOnInit() {
  }

  fetchZergDeck(){
    this.selectedZerg = true;
    this.selectedZergHand = false;
    this.gameStarted = false;

    this.dataService.fetchZergDeck()
      .then(zCards => this.zergCards = zCards.map(c => new CardOption(c)));
    //.then(cards => console.log('Cards : ', cards));
  }

  fetchPrincessDeck(){
    this.selectedPrincess = true;
    this.selectedPrincessHand = false;
    this.gameStarted = false;

    this.dataService.fetchPrincessDeck()
      .then(pCards => this.princessCards = pCards.map(c => new CardOption(c)));

  }


  getPrincessHand(): Card[]{

    //console.log(this.princessCards);
    const list = this.princessCards.filter(o => o.selected).map(o => o.card);

    //console.log(list);

    if (list.length == 8){
      console.log("Ok for the Princess' hand !");
      this.selectedPrincessHand = true;
      this.selectedPrincess = false;
      this.princessHand = list;
      return list;
    } else if (list.length < 8) {
      console.log("You need to have 8 cards in your hand, please, keep going.")
    } else {
      console.log("You can't have more than 8 cards in your hand. Please drop the surplus");
    }

  }

  getZergHand(): Card[]{


      const list = this.zergCards.filter(o => o.selected).map(o => o.card);




    if (list.length == 8){
      console.log("Ok for the Zerg's hand !");
      this.selectedZergHand = true;
      this.selectedZerg = false;
      this.zergHand = list;
      return list;
    } else if (list.length < 8) {
      console.log("You need to have 8 cards in your hand, please, keep going.")
    } else {
      console.log("You can't have more than 8 cards in your hand. Please drop the surplus");
    }

  }

  selectRandomPrincessHand(){

    let r = 0;
    let list : Card[] = this.princessCards.filter(o => o.selected).map(o => o.card);

    for (let i = 0; i < (8 - list.length); ) {
      if (this.selectedPrincess) {
        r = Math.floor(Math.random() * this.princessCards.length);


        if (this.princessCards[r].selected == true) {
          continue;
        } else {
          this.princessCards[r].selected = true;
          //list.push(this.princessCards[r].card);
          i++

        }
      }
    }

    this.selectedPrincessRandom = true;

    //return list;
  }

  selectRandomZergHand(){

    let r = 0;
    let list : Card[] = this.zergCards.filter(o => o.selected).map(o => o.card);
    console.log("Taille de la liste : " + list.length);

    for (let i = 0; i < (8-list.length); ) {
      if (this.selectedZerg) {
        r = Math.floor(Math.random() * this.zergCards.length);


        if (this.zergCards[r].selected == true) {
          continue;
        } else {
          this.zergCards[r].selected = true;
          //list.push(this.zergCards[r].card);
          i++

        }
      }
    }

    this.selectedZergRandom = true;

    //return list;
  }



  launchGame() {

    this.gameStarted = true;
    if (this.getPrincessHand() != [] && this.getZergHand() != []) {
      console.log("Start Game !!!!");


      this.startGame()
        .then();
      this.getResultWinner()
        .then(resultWinner => this.resultWinner = resultWinner);
      this.getResultList()
        .then(resultList => this.resultList = resultList);

    }
  }

  startGame() {
/*        this.zerg.zergHand = this.getZergHand();
        this.princess.princessHand = this.getPrincessHand();
        console.log(this.princess.princessHand);*/

        return this.dataService.sendHands(this.getPrincessHand(), this.getZergHand())
          .catch(e => alert(e.message));
  }


  getResultWinner(){
    return this.dataService.getResultWinner();

  }

  getResultList(){
    return this.dataService.getResultList();
  }

}


