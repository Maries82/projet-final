import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Card} from "./model/card";


@Injectable()
export class DataService {

  constructor(public http: HttpClient) { }


  fetchPrincessDeck(): Promise<Card[]> {

    let url = 'http://localhost:8080/starstone/api/general/princess' ;
    return this.http
      .get(url)
      .toPromise()
      .then(data => {

        console.log('princess\'s deck: ', data);
        return data as Card[];
      })


  }
}
