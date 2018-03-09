import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class PageServiceService {
  page: string ='game';

  constructor(public http: HttpClient) { }


  toggle(){
    // ternary operator
    this.page =  this.page === 'game' ? 'achat' : 'game';
  }


  isGame(){
    return this.page === 'game';
  }

  isAchat(){
    return this.page === 'achat';
  }
}
