


export class Card {

  order: number
  up: number;
  right: number;
  down: number;
  left: number;
  name: string;
  color: string;
}

export class CardOption{
  selected = false;

  constructor(public card:Card){

  }
}
