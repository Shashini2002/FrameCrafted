import { Component } from '@angular/core';
import { NavigationBarComponent } from '../navigation-bar/navigation-bar.component';
import { FooterComponent } from '../footer/footer.component';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-tracking-order',
  imports: [NavigationBarComponent,FooterComponent,FormsModule,CommonModule,HttpClientModule],
  templateUrl: './tracking-order.component.html',
  styleUrl: './tracking-order.component.css'
})
export class TrackingOrderComponent {
  orderId: string = '';
  email: string = '';
  showModal: boolean = false;
  orderDetails: string = '';

  constructor(private http: HttpClient) {}

  trackOrder() {
    if (!this.orderId || !this.email) {
      alert('Both Order ID and Email are required!');
      return;
    }

    const payload = {
      orderId: this.orderId,
      email: this.email,
    };

    this.http.post<any>('http://localhost:8080/order/track', payload).subscribe(
      (response) => {
        
     
        this.orderDetails = `
           ${response.itemCode} 
          ${response.price} 
           ${response.status|| 'Unknown'}
        `;
        this.showModal = true;
      },
      (error) => {
        alert('Invalid Order ID or Email. Please try again.');
      }
    );
  }

  closeModal() {
    this.showModal = false;
    this.orderDetails = '';
  }
}

