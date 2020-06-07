import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { StudentComponent } from './student/student.component';
import { BooksComponent } from './books/books.component';
import { LoginComponent } from './login/login.component';
import { AddbookComponent } from './addbook/addbook.component';
import { ShowusersComponent } from './showusers/showusers.component';
import { ShowrequestsComponent } from './showrequests/showrequests.component';
import { RequestbookComponent } from './requestbook/requestbook.component';
import { ReturnbookComponent } from './returnbook/returnbook.component';
import { IssusebookComponent } from './issusebook/issusebook.component';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';
import { DeletebookComponent } from './deletebook/deletebook.component';
import { AuthguardGuard } from './authguard.guard';
import { ShowborrowComponent } from './showborrow/showborrow.component';
import { HeaderComponent } from './header/header.component';



const routes: Routes = [
  { path: '', component: HomeComponent },

  { path: 'header', component: HeaderComponent },
  {
    path: 'user', component: StudentComponent,
    data: { roles: ['student'] }, canActivate: [AuthguardGuard]
  },
  { path: 'addbook', component: AddbookComponent },
  { path: 'showborrow', component: ShowborrowComponent },
  { path: 'showusers', component: ShowusersComponent },
  { path: 'showrequests', component: ShowrequestsComponent },
  { path: 'issusebook', component: IssusebookComponent },
  { path: 'requestbook', component: RequestbookComponent },
  { path: 'returnbook', component: ReturnbookComponent },
  { path: 'register', component: RegisterComponent },
  {
    path: 'admin', component: AdminComponent,
    data: { roles: ['admin'] }, canActivate: [AuthguardGuard]
  },
  { path: 'delete', component: DeletebookComponent },
  { path: 'books', component: BooksComponent },
  { path: 'login', component: LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
