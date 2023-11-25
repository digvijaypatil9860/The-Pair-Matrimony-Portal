import { ComponentFixture, TestBed } from '@angular/core/testing';

import { YourBrideComponent } from './your-bride.component';

describe('YourBrideComponent', () => {
  let component: YourBrideComponent;
  let fixture: ComponentFixture<YourBrideComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [YourBrideComponent]
    });
    fixture = TestBed.createComponent(YourBrideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
