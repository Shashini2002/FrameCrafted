import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WallArtsComponent } from './wall-arts.component';

describe('WallArtsComponent', () => {
  let component: WallArtsComponent;
  let fixture: ComponentFixture<WallArtsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WallArtsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WallArtsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
