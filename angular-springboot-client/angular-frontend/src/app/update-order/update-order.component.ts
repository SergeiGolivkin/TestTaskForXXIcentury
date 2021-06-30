import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-update-order',
  templateUrl: './update-order.component.html',
  styleUrls: ['./update-order.component.css']
})
export class UpdateOrderComponent implements OnInit {

   id!: number;
  order: Order = new Order();
  constructor(private orderService: OrderService,
    private route: ActivatedRoute,
  private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.orderService.getOrderById(this.id).subscribe(data => {
      this.order = data;
    }, error => console.log(error));
  }

   onSubmit(){
    this.orderService.updateOrder(this.id, this.order).subscribe( data => {
      this.goToOrderList();
    }
    , error => console.log(error));
  }

  goToOrderList(){
    this.router.navigate(['/orders']);
  }


}
