import { Component, OnInit } from '@angular/core';
import { BooksService } from '../books.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-showrequests',
  templateUrl: './showrequests.component.html',
  styleUrls: ['./showrequests.component.css']
})
export class ShowrequestsComponent implements OnInit {
  showrequest;
  message: string;

  constructor(private libraryService: BooksService, private router: Router) {
    this.showRequestDetails();
  }

  ngOnInit(): void {
  }

  showRequestDetails() {
    this.libraryService.showRequests().subscribe(response => {
      console.log(response);
      this.showrequest =response.requests;
    }, error => {
      console.log(error);
    }
    );
  }

}
