import { Component, OnInit } from '@angular/core';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-deletebook',
  templateUrl: './deletebook.component.html',
  styleUrls: ['./deletebook.component.css']
})
export class DeletebookComponent implements OnInit {
  message: string;
  books;

  constructor(private bookService: BooksService) { 
    this.getBooks();
  }

  ngOnInit() {
  }
  getBooks() {
    this.bookService.getData().subscribe(response => {
      console.log(response);
      this.books = response.booksInfo;
    }, error => {
      console.log(error);
    }
    );
  }

  deleteBook(bookbean) {
    this.bookService.deleteData(bookbean).subscribe(response => {
      console.log(response);
      if (response.error) {
        this.message = 'Failed to delete the book';
      } else {
        this.message = 'book deleted successfully';
      }
      setTimeout(() => {
        this.message = null;
      }, 5000);
      this.getBooks();
    });
  }

}
