import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Card, CardOption} from './model/card';
import {Zerg} from "./model/zerg";

import {Princess} from "./model/princess";
import {Winner} from './model/winner';
import {any} from "codelyzer/util/function";




@Injectable()
export class DataService {




  constructor(public http: HttpClient) {

  }


  fetchPrincessDeck(): Promise<Card[]> {
    return this.http
      .get('http://localhost:8080/starstone/api/general/princess' )
      .toPromise()
      .then(data => {
        console.log('princess\'s deck: ', data);
        return data as Card[];
      });
  }

  fetchZergDeck(): Promise<Card[]> {
    return this.http
      .get('http://localhost:8080/starstone/api/general/zerg')
      .toPromise()
      .then(data => {
        console.log(data);
        return data as Card[];
      });

  }

  fetchWinner(): Promise<Winner[]>{
    return this.http
      .get('http://localhost:8080/starstone/api/game/winner')
      .toPromise()
      .then(data => {
        console.log(data);
        return data as Winner[];
      });

  }

  fetchGlobalDeck() : Promise<Card[]>{
    return this.http
      .get('http://localhost:8080/starstone/api/general/global' )
      .toPromise()
      .then((data : any) => {
        console.log('Result dataservice: ', data.cards);
        return data.cards as Card[];
      });
  }


  sendHands(princessHand : Card[], zergHand : Card[]){

    let url = 'http://localhost:8080/starstone/api/general/two';
    let handOfPrincess : Card[] = [];
    let handOfZerg : Card[] = [];


    //console.log("Princess : " + princess.princessHand[3].name + " - " + princess.princessHand[3].color + " - " + princess.princessHand[3].order);


/*    for (let i = 0; i < 8; i++){
      let card : Card = {

      }
    }*/


for (let i = 0; i < 8; i++) {
  let princessCard : Card = {
    name: princessHand[i].name,
    order: princessHand[i].order,
    up: princessHand[i].up,
    right: princessHand[i].right,
    down: princessHand[i].down,
    left: princessHand[i].left,
    color: princessHand[i].color
  }

  handOfPrincess.push(princessCard);

      let zergCard: Card = {
        name: zergHand[i].name,
        order: zergHand[i].order,
        up: zergHand[i].up,
        right: zergHand[i].right,
        down: zergHand[i].down,
        left: zergHand[i].left,
        color: zergHand[i].color
      };
      handOfZerg.push(zergCard);
    }

console.log(handOfZerg[0]);
console.log(handOfPrincess);


    let dto = [handOfPrincess, handOfZerg];




    console.log('Sending DTO : ' + dto);



    return this.http.post(url, dto)
      .toPromise()
      .then(data => console.log('Success :) ', data))
  }


  getResultWinner(): Promise<Winner> {
    return this.http
      .get('http://localhost:8080/starstone/api/game/winner')
      .toPromise()
      .then(data => {
        console.log('Winner: ', data);
        return data as Winner;
      });
  }

  getResultList() : Promise<Card[]>{
    return this.http
      .get('http://localhost:8080/starstone/api/result/list' )
      .toPromise()
      .then(data => {
        console.log('Result: ', data);
        return data as Card[];
      });
  }


  /*sendZergHand(zerg: Zerg) {
    let url = 'http://localhost:8080/starstone/api/general';




    let dto = { // Data Transfer Object pour Jax-B
      zergHand : zerg.zergHand
    };


    console.log('Sending topicDTO' + dto);

    return this.http.post(url, dto)
      .toPromise()
      .then(data => console.log('Success :) ', data))
  }*/

/*  createTopic(topic: Topic) {
    let url = 'http://localhost:8080/forum/api/topics';
    let dto = { // Data Transfer Object pour Jax-B
      title: topic.title,
      admin: topic.admin
    }

    console.log('Sending topicDTO' + dto);

    return this.http.post(url, dto)
      .toPromise()
      .then(data => console.log('Success :) ', data))

  }*/
}
