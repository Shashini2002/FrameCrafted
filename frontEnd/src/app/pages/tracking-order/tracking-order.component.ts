import { Component } from '@angular/core';
import { NavigationBarComponent } from '../navigation-bar/navigation-bar.component';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-tracking-order',
  imports: [NavigationBarComponent,FooterComponent],
  templateUrl: './tracking-order.component.html',
  styleUrl: './tracking-order.component.css'
})
export class TrackingOrderComponent {

}
