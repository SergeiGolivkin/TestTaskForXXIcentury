import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { GoodsListComponent } from './goods-list/goods-list.component';
import { CreateGoodsComponent } from './create-goods/create-goods.component';
import { FormsModule } from '@angular/forms';
import { UpdateGoodsComponent } from './update-goods/update-goods.component';
import { GoodsDetailsComponent } from './goods-details/goods-details.component';
import { OrderListComponent } from './order-list/order-list.component';
import { UpdateOrderComponent } from './update-order/update-order.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import { OrderDetailsComponent } from './order-details/order-details.component';

@NgModule({
  declarations: [
    AppComponent,
    GoodsListComponent,
    CreateGoodsComponent,
    UpdateGoodsComponent,
    GoodsDetailsComponent,
    OrderListComponent,
    UpdateOrderComponent,
    CreateOrderComponent,
    OrderDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
