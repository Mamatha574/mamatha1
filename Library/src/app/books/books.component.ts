import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {
  message: string;
  books;
  searchText;
  fieldName = 'bookName';
  constructor(private libraryService: BooksService, private router: Router) {
    this.getBooks();
  }

  ngOnInit(): void {
  }

  getBooks() {
    this.libraryService.getData().subscribe(response => {
      console.log(response);
      this.books = response.booksInfo;
    }, error => {
      console.log(error);
    }
    );
  }

}
