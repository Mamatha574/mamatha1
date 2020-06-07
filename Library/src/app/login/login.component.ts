import { Component, OnInit } from '@angular/core';
import { BooksService } from '../books.service';
import { Router } from '@angular/router';
import { NgForm, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  message: string;

  constructor(private builder: FormBuilder, private router: Router, private authService: BooksService) {

  }

  error: string;
  ngOnInit(): void {

  }

  loginUser(form: NgForm) {
    this.authService.login(form.value).subscribe(response => {
      console.log(response);
      if (response.error) {
        this.error = response.message;
        setTimeout(() => {
          this.error = null;
        }, 5000);
      } else {
        this.message = 'Login successfully';
        localStorage.setItem('userDetails', JSON.stringify(response));
        this.router.navigateByUrl('/');
        setTimeout(() => {
          this.message = null;
        }, 5000);
      }
      form.reset();
    });
  }


}
