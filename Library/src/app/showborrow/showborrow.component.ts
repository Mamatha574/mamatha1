import { Component, OnInit } from '@angular/core';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-showborrow',
  templateUrl: './showborrow.component.html',
  styleUrls: ['./showborrow.component.css']
})
export class ShowborrowComponent implements OnInit {

  books;
  move=true;
  move1=false;
  constructor(private bookService: BooksService){
    this.getBooks();

  }

  ngOnInit() {
      }
      getBooks() {
        this.bookService.getBorrowedData().subscribe(response => {
          console.log(response);
          this.books = response.booksInfo;
        }, error => {
          console.log(error);
        }
        );
      }

}
