import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Card} from './model/card';


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
}
