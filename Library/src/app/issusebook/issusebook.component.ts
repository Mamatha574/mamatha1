import { Component, OnInit } from '@angular/core';
import { BooksService } from '../books.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-issusebook',
  templateUrl: './issusebook.component.html',
  styleUrls: ['./issusebook.component.css']
})
export class IssusebookComponent implements OnInit {
  message: string;
  requests;
  constructor(private libraryService: BooksService, private router: Router) {
      this.getRequestDetails();
    }

  ngOnInit(): void {
  }

  getRequestDetails(){
    this.libraryService.showRequests().subscribe(response => {
      console.log(response);
      this.requests = response.requests;
    }, error => {
      console.log(error);
    }
    );
  }
  issueData(request){
    this.libraryService.issueData({uid: request.uid, bid: request.bid}).subscribe(response => {
      console.log(response);
      if ( !response.error){
        this.message = 'Book Issued successfully';
      }else{
        this.message = 'Book not Issued';
      }
      this.getRequestDetails();
      setTimeout(() => {
        this.message = null;
      }, 5000);

    });
  }

}
