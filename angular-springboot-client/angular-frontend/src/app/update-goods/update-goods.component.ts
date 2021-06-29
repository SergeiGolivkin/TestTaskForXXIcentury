import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Goods } from '../goods';
import { GoodsService } from '../goods.service';

@Component({
  selector: 'app-update-goods',
  templateUrl: './update-goods.component.html',
  styleUrls: ['./update-goods.component.css']
})
export class UpdateGoodsComponent implements OnInit {

  id!: number;
  goods: Goods = new Goods();
  constructor(private goodsService: GoodsService,
    private route: ActivatedRoute,
  private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.goodsService.getGoodsById(this.id).subscribe(data => {
      this.goods = data;
    }, error => console.log(error));
  }

   onSubmit(){
    this.goodsService.updateGoods(this.id, this.goods).subscribe( data => {
      this.goToGoodsList();
    }
    , error => console.log(error));
  }

  goToGoodsList(){
    this.router.navigate(['/goodses']);
  }

}
