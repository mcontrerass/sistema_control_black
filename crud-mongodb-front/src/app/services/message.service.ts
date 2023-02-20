import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  subject = new BehaviorSubject<any>('null');

  public sendMessage(product: Product): void {
    this.subject.next({product: product});
  }

  public getMessage(): Observable<any> {
    return this.subject.asObservable();
  }

  constructor() { }
}
