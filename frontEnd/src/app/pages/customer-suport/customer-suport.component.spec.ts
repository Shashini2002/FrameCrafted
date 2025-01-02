import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerSuportComponent } from './customer-suport.component';

describe('CustomerSuportComponent', () => {
  let component: CustomerSuportComponent;
  let fixture: ComponentFixture<CustomerSuportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CustomerSuportComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerSuportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
