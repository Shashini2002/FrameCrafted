import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StandradFrameComponent } from './standrad-frame.component';

describe('StandradFrameComponent', () => {
  let component: StandradFrameComponent;
  let fixture: ComponentFixture<StandradFrameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StandradFrameComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StandradFrameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
