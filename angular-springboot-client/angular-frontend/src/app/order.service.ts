import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

   private orderURL = "http://localhost:8090/api/v1/order";
  constructor(private httpClient: HttpClient) { }

  getOrdersList(): Observable<Order[]> {
    return this.httpClient.get<Order[]>(`${this.orderURL}/all`);
  }

  createOrder(order: Order): Observable<Object>{
    return this.httpClient.post(`${this.orderURL}/add`, order);
  }

  updateOrder(id: number, order: Order): Observable<Object>{
    return this.httpClient.put(`${this.orderURL}/update/${id}`, order);
  }

  getOrderById(id: number): Observable<Order>{
    return this.httpClient.get<Order>(`${this.orderURL}/${id}`);
  }

  deleteOrder(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.orderURL}/delete/${id}`);
  }
}
