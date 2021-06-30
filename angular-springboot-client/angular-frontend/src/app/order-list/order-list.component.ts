import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

   orders!: Order[];

  constructor(private orderService: OrderService,
    private router: Router) { }

  ngOnInit(): void {
    this.getOrders();
  }

  private getOrders(){
    this.orderService.getOrdersList().subscribe(data => {
      this.orders = data;
    });
  }

  orderDetails(id: number){
    this.router.navigate(['order-details', id]);
  }

  updateOrder(id: number){
    this.router.navigate(['update-order', id]);
  }

  deleteOrder(id: number){
     this.orderService.deleteOrder(id).subscribe( data => {
       console.log(data);
       this.getOrders();
     })
   }
}
