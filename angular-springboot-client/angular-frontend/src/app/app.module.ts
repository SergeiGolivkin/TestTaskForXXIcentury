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
import { DeleteGoodsComponent } from './delete-goods/delete-goods.component';

@NgModule({
  declarations: [
    AppComponent,
    GoodsListComponent,
    CreateGoodsComponent,
    UpdateGoodsComponent,
    GoodsDetailsComponent,
    DeleteGoodsComponent
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
