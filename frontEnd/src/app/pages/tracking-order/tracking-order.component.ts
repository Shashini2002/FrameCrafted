import { Component } from '@angular/core';
import { NavigationBarComponent } from '../navigation-bar/navigation-bar.component';
import { FooterComponent } from '../footer/footer.component';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-tracking-order',
  imports: [NavigationBarComponent, FooterComponent, FormsModule, CommonModule, HttpClientModule],
  templateUrl: './tracking-order.component.html',
  styleUrls: ['./tracking-order.component.css'],
})
export class TrackingOrderComponent {
  orderId: string = '';
  email: string = '';
  showModal: boolean = false;
    showNewModal: boolean = false;
  orderDetails: any = { itemCode: '', price: '', status: '' };

  // Step titles mapping based on status, including isActive and isCompleted properties
  steps = [
    { status: "Non-Pay", label: "Non-Pay", isActive: false, isCompleted: false },
    { status: "Pending", label: "Pending", isActive: false, isCompleted: false },
    { status: "Processing", label: "Processing", isActive: false, isCompleted: false },
    { status: "Delivering", label: "Delivering", isActive: false, isCompleted: false },
    { status: "Delivered", label: "Delivered", isActive: false, isCompleted: false },
  ];

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
        this.orderDetails = response;

        // Update the order status dynamically
        this.updateStepperStatus(response.status);
        this.showModal = true;
      },
      (error) => {
        alert('Invalid Order ID or Email. Please try again.');
      }
    );
  }

  closeModal() {
    this.showModal = false;
    this.orderDetails = { itemCode: '', price: '', status: '' };
  }

  // Update the stepper based on the order status
  updateStepperStatus(status: string) {
    const formattedStatus = status.toLowerCase(); // Normalize the status to lowercase

    this.steps.forEach((step, index) => {
      // Set isActive to true if the current step matches the order status
      step.isActive = formattedStatus === step.status.toLowerCase();
      
      // Mark as completed if the step is before the current status
      step.isCompleted = index < this.steps.findIndex(s => s.status.toLowerCase() === formattedStatus);
    });
  }


  
  updateOrder(){
    

  }
  cancelOrder(){
    const confirmCancel = confirm("Are you sure you want to cancel this order?");
    if (confirmCancel) {
      const payload = { orderId: this.orderId };
      
      this.http.delete(`http://localhost:8080/order/delete-order/${this.orderId}`).subscribe(
        (response) => {
          alert('Order has been successfully cancelled.');
          this.closeModal();  // Close the modal after successful cancellation
        },
        (error) => {
          alert('Failed to cancel the order. Please try again.');
        }
      );
    }
  }
}
