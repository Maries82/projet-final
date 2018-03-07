import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Card} from './model/card';
import {Zerg} from "./model/zerg";
import {forEach} from "@angular/router/src/utils/collection";
import {Princess} from "./model/princess";


@Injectable()
export class DataService {

  constructor(public http: HttpClient) { }


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


  sendHands(zergHand: Card[], princessHand : Card[]){

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
