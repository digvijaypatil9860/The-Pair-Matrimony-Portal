import { ComponentFixture, TestBed } from '@angular/core/testing';

import { YourGroomComponent } from './your-groom.component';

describe('YourGroomComponent', () => {
  let component: YourGroomComponent;
  let fixture: ComponentFixture<YourGroomComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [YourGroomComponent]
    });
    fixture = TestBed.createComponent(YourGroomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
