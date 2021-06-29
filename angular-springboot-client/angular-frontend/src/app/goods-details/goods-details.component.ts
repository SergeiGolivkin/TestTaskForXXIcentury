import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Goods } from '../goods';
import { GoodsService } from '../goods.service';

@Component({
  selector: 'app-goods-details',
  templateUrl: './goods-details.component.html',
  styleUrls: ['./goods-details.component.css']
})
export class GoodsDetailsComponent implements OnInit {

   id!: number
  goods!: Goods
  constructor(private route: ActivatedRoute, private goodsService: GoodsService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.goods = new Goods();
    this.goodsService.getGoodsById(this.id).subscribe( data => {
      this.goods = data;
    });
  }

}
