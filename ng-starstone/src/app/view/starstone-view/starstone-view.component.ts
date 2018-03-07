import {Component, OnInit} from '@angular/core';
import {DataService} from '../../data-service.service';
import {Card} from '../../model/card';
import {Princess} from '../../model/princess';
import {Zerg} from "../../model/zerg";

@Component({
  selector: 'app-starstone-view',
  templateUrl: './starstone-view.component.html',
  styleUrls: ['./starstone-view.component.css']
})
export class StarstoneViewComponent implements OnInit {

  zergCards: Card[];
  princessCards: Card[];
  selectedZerg : boolean;
  selectedPrincess : boolean;
  princess: Princess;
  zerg: Zerg;

  constructor(public dataService: DataService) {

  }

  ngOnInit() {
  }

  fetchZergDeck(){
    this.selectedZerg = true;

    this.dataService.fetchZergDeck()
      .then(zCards => this.zergCards = zCards);
    //.then(cards => console.log('Cards : ', cards));
  }

  fetchPrincessDeck(){
    this.selectedPrincess = true;

    this.dataService.fetchPrincessDeck()
      .then(pCards => this.princessCards = pCards);
    //.then(cards => console.log('Cards : ', cards));
  }
}
