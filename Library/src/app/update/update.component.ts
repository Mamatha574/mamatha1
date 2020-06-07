import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  message: string;

  constructor(private bookService: BooksService) { }

  ngOnInit(): void {
  }
  postUpdate(form: NgForm) {
    this.bookService.postUpdateBoook(form.value).subscribe(response => {
      console.log(response);


      if (!response.error) {
        this.message = 'Book Updated Successfully';

      }
    }, error => {
      console.log(error);
    });

  }
}
