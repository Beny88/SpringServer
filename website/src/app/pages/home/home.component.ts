import { Component, OnInit } from '@angular/core';
import {Product, ProductService} from "../../service/product.service";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private productService: ProductService) { }

  listaProduktow: Product[] = [];

  ngOnInit() {
    this.productService.getProductList().subscribe((response: Product[]) => {

      this.listaProduktow = response;

      response.forEach((product: Product)=> {
        console.log('name', product.name);
        console.log('brand', product.brand);
        console.log('dateCreated', product.dateCreated.seconds, product.dateCreated.nanos);
      })
    });
  }
}
