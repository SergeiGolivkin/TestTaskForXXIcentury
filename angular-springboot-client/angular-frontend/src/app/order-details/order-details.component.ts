import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

    id!: number
  order!: Order
  constructor(private route: ActivatedRoute, private orderService: OrderService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.order = new Order();
    this.orderService.getOrderById(this.id).subscribe( data => {
      this.order = data;
    });
  }

}
