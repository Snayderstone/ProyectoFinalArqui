import { Injectable } from '@angular/core';
import {HttpClientModule, HttpClient} from "@angular/common/http";
import {Product} from "../model/product";
import {Customer} from "../model/customer";
import {Invoice} from "../model/invoce";

@Injectable({
  providedIn: 'root'
})
export class AppService {


  protected port: string = '8091'
  protected urlProducts = `http://localhost:${this.port}/products`
  // protected urlCustomers = `http://localhost:${this.port}/customers`
  //protected urlShopping = `http://localhost:${this.port}/invoices`

  protected urlCustomers = 'http://localhost:8080/customers'
  protected urlShopping = 'http://localhost:8092/invoices'

  constructor(
    protected http: HttpClient) { }


  findAllProduct(){
    return this.http.get<Product[]>(this.urlProducts)
  }

  findAllCustomers(){
    return this.http.get<Customer[]>(this.urlCustomers)
  }

  findAllShopping(){
    return this.http.get<Invoice[]>(this.urlShopping)
  }

}
