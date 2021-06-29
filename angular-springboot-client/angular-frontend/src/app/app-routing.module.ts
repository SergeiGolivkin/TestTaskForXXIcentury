import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateGoodsComponent } from './create-goods/create-goods.component';
import { GoodsListComponent } from './goods-list/goods-list.component';
import { UpdateGoodsComponent } from './update-goods/update-goods.component';
import {GoodsDetailsComponent} from './goods-details/goods-details.component';

const routes: Routes = [
  { path: 'goodses', component: GoodsListComponent },
  { path: 'goodses/create-goods', component: CreateGoodsComponent},
  {path: 'update-goods/:id', component: UpdateGoodsComponent},
  {path: 'goods-details/:id', component: GoodsDetailsComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
