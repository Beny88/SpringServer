import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) { }

  public getProductList(): Observable<Product[]> {
    return this.httpClient.get<Product[]>('http://localhost:8555/product');
  }
}

export class Product {
   id;
   name;
   brand;
   imageUrl;
   type;
   kind;
   price;
   stockAmount;
   dateCreated;
}
