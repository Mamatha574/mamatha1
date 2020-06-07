import { Component, OnInit } from '@angular/core';
import { BooksService } from '../books.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-returnbook',
  templateUrl: './returnbook.component.html',
  styleUrls: ['./returnbook.component.css']
})
export class ReturnbookComponent implements OnInit {

  message: string;
  error: string;
  books;

  constructor(private libraryService: BooksService, private router: Router) { 
    this.showIssuseDetails();
  }

  ngOnInit(): void {
  }
  showIssuseDetails() {
    this.libraryService.showIssuedBooks().subscribe(response => {
      console.log(response);
      this.books =response.issueInfo;
    }, error => {
      console.log(error);
    }
    );
  }
  returnData(book) {
    this.libraryService.returnBook({ bid: book.bid,uid: book.uid}).subscribe(response => {
      console.log(response);
      if (!response.error) {
        this.message = 'Book  is returned ';
      } else {
        this.message = 'Book is not returned ';
      }
      this.showIssuseDetails();
      setTimeout(() => {
        this.message = null;
      }, 5000);
      this.showIssuseDetails();
    });
  }

}
