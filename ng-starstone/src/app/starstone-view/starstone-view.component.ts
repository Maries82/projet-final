import {Component, OnInit} from '@angular/core';
import {Card} from '../model/card';
import {DataService} from '../data-service.service';

@Component({
  selector: 'app-starstone-view',
  templateUrl: './starstone-view.component.html',
  styleUrls: ['./starstone-view.component.css']
})
export class StarstoneViewComponent implements OnInit {
  ngOnInit(): void {
  }

  cards: Card[];

  constructor(public dataService: DataService) {
  }

  // ngOnInit() {
  //   this.dataService.fetchZergDeck()
  //     .then(cards => this.cards = cards);
  // }

  /*  getZergDeck() {
      this.dataService.fetchZergDeck()
        .then(cards => this.cards = cards);
    }*/


}
