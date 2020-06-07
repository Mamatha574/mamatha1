import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IssusebookComponent } from './issusebook.component';

describe('IssusebookComponent', () => {
  let component: IssusebookComponent;
  let fixture: ComponentFixture<IssusebookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IssusebookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IssusebookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
