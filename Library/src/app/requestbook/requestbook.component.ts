import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BooksService } from '../books.service';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-requestbook',
  templateUrl: './requestbook.component.html',
  styleUrls: ['./requestbook.component.css']
})
export class RequestbookComponent implements OnInit {
  
  books;
  message: string;
  error: string;

  constructor(private booksService: BooksService) {
    this.getBooks();
  }

  ngOnInit(): void { }


  getBooks() {
    this.booksService.getData().subscribe(response => {
      console.log(response);
      this.books = response.booksInfo;
    }, error => {
      console.log(error);
    }
    );
  }

  requestBook(bid) {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    let userId = userDetails.userInfo.uid;
    this.booksService.requestData({ uid: userId, bid: bid }).subscribe(response => {
      console.log(response);
      if (response.error) {
        this.message = 'already requested the book';
        this.error = response.booksInfo;
        setTimeout(() => {
          this.error = null;
        }, 5000);
      } else {
        this.message = 'request sent to admin successfully';
        setTimeout(() => {
          this.error = null;
        }, 5000);
      }
 });
  }
}
