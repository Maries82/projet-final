import {Component, OnInit} from '@angular/core';
import {DataService} from '../data-service.service';
import {Card} from '../model/card';
import {Princess} from '../model/princess';

@Component({
  selector: 'app-starstone-view',
  templateUrl: './starstone-view.component.html',
  styleUrls: ['./starstone-view.component.css']
})
export class StarstoneViewComponent implements OnInit {

  cards: Card[];

  constructor(public dataService: DataService) { }

  ngOnInit() {
    this.dataService.fetchZergDeck()
      .then(cards => this.cards = cards);
  }
}
