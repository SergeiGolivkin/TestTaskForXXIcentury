import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DeleteGoodsComponent } from './delete-goods.component';

describe('DeleteGoodsComponent', () => {
  let component: DeleteGoodsComponent;
  let fixture: ComponentFixture<DeleteGoodsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteGoodsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteGoodsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
