import { Component, OnInit } from '@angular/core';
import {Goods } from '../goods'
import { GoodsService } from '../goods.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-goods-list',
  templateUrl: './goods-list.component.html',
  styleUrls: ['./goods-list.component.css']
})
export class GoodsListComponent implements OnInit {

  goodses!: Goods[];

  constructor(private goodsService: GoodsService,
    private router: Router) { }

  ngOnInit(): void {
    this.getGoodses();
  }

  private getGoodses(){
    this.goodsService.getGoodsesList().subscribe(data => {
      this.goodses = data;
    });
  }

  goodsDetails(id: number){
    this.router.navigate(['goods-details', id]);
  }

  updateGoods(id: number){
    this.router.navigate(['update-goods', id]);
  }

  deleteGoods(id: number){
     this.goodsService.deleteGoods(id).subscribe( data => {
       console.log(data);
       this.getGoodses();
     })
   }
}