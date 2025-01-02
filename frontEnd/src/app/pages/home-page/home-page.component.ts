import { Component, AfterViewInit, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RouterLink } from '@angular/router';
import { NavigationBarComponent } from '../navigation-bar/navigation-bar.component';
import { FooterComponent } from '../footer/footer.component';
import { NewDesignComponent } from '../new-design/new-design.component';
declare var Flowbite: any;

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [RouterLink, NavigationBarComponent, FooterComponent, NewDesignComponent],
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements AfterViewInit, OnInit {
  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.fragment.subscribe(fragment => {
      if (fragment) {
        this.scrollToFragment(fragment);
      }
    });
  }

  ngAfterViewInit() {
    // Initialize Flowbite Carousel after view is initialized
    this.initializeCarousel();
  }

  private initializeCarousel() {
    const carouselElement = document.getElementById('default-carousel');
    if (carouselElement) {
      new Flowbite.Carousel(carouselElement);  // Initialize Flowbite carousel
    }
  }

  private scrollToFragment(fragment: string): void {
    const element = document.getElementById(fragment);
    if (element) {
      element.scrollIntoView({ behavior: 'smooth', block: 'start' });
    }
  }
}
