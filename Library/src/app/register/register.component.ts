import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BooksService } from '../books.service';
import { FormBuilder, NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {


  message: string;
  error;


  constructor(private fb: FormBuilder, private router: Router, private authService: BooksService) { }


  ngOnInit() {

  }
  registerUser(form: NgForm) {
    this.authService.registeration(form.value).subscribe(response => {
      console.log(response);
      if (response.error) {
        this.error = response.message;
        setTimeout(() => {
          this.error = null;
        }, 5000);
      } else {
        this.message = 'User registered successfully,Please Login';
         setTimeout(() => {
          this.message = null;
        }, 5000);
      }

      form.reset();
    });
  }

}
