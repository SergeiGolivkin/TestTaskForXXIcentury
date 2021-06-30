import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css']
})
export class CreateOrderComponent implements OnInit {

order: Order = new Order();
  constructor(private orderService: OrderService,
   private router: Router) { }

  ngOnInit(): void {
  }

  saveOrder() {
    this.orderService.createOrder(this.order).subscribe(data => {
      console.log(data);
      this.goToOrderList();
    },
    error => console.log(console.error));
  }

  goToOrderList() {
    this.router.navigate(['/orders'])
  }

  onSubmit() {
    console.log(this.order);
    this.saveOrder();
  }

}
