import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowborrowComponent } from './showborrow.component';

describe('ShowborrowComponent', () => {
  let component: ShowborrowComponent;
  let fixture: ComponentFixture<ShowborrowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowborrowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowborrowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
