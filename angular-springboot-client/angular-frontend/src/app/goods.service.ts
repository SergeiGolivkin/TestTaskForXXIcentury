import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Goods } from './goods';

@Injectable({
  providedIn: 'root'
})
export class GoodsService {

  private baseURL = "http://localhost:8090/api/v1/goods";
  constructor(private httpClient: HttpClient) { }

  getGoodsesList(): Observable<Goods[]>{
    return this.httpClient.get<Goods[]>(`${this.baseURL}/all`);
  }

  createGoods(goods: Goods): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/add`, goods);
  }
  
  getGoodsById(id: number): Observable<Goods>{
    return this.httpClient.get<Goods>(`${this.baseURL}/${id}`);
  }

  updateGoods(id: number, goods: Goods): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/update/${id}`, goods);
  }

  deleteGoods(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/delete/${id}`);
  }
}
