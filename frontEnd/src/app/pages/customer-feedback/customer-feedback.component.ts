import { Component } from '@angular/core';
import { NavigationBarComponent } from '../navigation-bar/navigation-bar.component';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-customer-feedback',
  imports: [NavigationBarComponent,FooterComponent],
  templateUrl: './customer-feedback.component.html',
  styleUrl: './customer-feedback.component.css'
})
export class CustomerFeedbackComponent {

}
