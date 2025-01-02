import { Component } from '@angular/core';
import { NavigationBarComponent } from '../navigation-bar/navigation-bar.component';
import { FooterComponent } from '../footer/footer.component';
import { NewDesignComponent } from '../new-design/new-design.component';
import { RouterLink,Router } from '@angular/router';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-standrad-frame',
  imports: [NavigationBarComponent,FooterComponent,NewDesignComponent,RouterLink,CommonModule],
  templateUrl: './standrad-frame.component.html',
  styleUrl: './standrad-frame.component.css'
})
export class StandradFrameComponent {
  showPopup = false;
  selectedFrame: any = {};  // To hold selected frame data
  framePhotos = [
    { src: 'path/to/photo1.jpg', code: 'ITEM001', price: 'Rs.1000.00', size: 'A4' },
    { src: 'path/to/photo2.jpg', code: 'ITEM002', price: 'Rs.1200.00', size: 'A3' },
    { src: 'path/to/photo3.jpg', code: 'ITEM003', price: 'Rs.1400.00', size: 'A2' },
    { src: 'path/to/photo4.jpg', code: 'ITEM004', price: 'Rs.1600.00', size: 'A1' },
    { src: 'path/to/photo5.jpg', code: 'ITEM005', price: 'Rs.1800.00', size: '24x36 inches' },
    { src: 'path/to/photo6.jpg', code: 'ITEM006', price: 'Rs.2000.00', size: 'A4' },
    { src: 'path/to/photo7.jpg', code: 'ITEM007', price: 'Rs.2200.00', size: 'A3' },
    { src: 'path/to/photo8.jpg', code: 'ITEM008', price: 'Rs.2400.00', size: 'A2' },
    { src: 'path/to/photo9.jpg', code: 'ITEM009', price: 'Rs.2600.00', size: 'A1' },
    { src: 'path/to/photo10.jpg', code: 'ITEM010', price: 'Rs.2800.00', size: '24x36 inches' }
  ];

  // Method to open popup
  openPopup(name: string, price: string, category: string, size: string) {
    this.selectedFrame = { name, price, category, size };
    this.showPopup = true;
  }

  // Method to close popup
  closePopup() {
    this.showPopup = false;
  }

  // Method to place an order
  placeOrder() {
    // Logic for placing an order
  }
}