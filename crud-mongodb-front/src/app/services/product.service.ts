import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  productUrl = environment.apiRestUrl + '/product';

  constructor(private httpClient: HttpClient) { }

  public list(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.productUrl);
  }

  public detail(id: number): Observable<Product> {
    return this.httpClient.get<Product>(this.productUrl + `/${id}`);
  }
}
