import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthguardGuard implements CanActivate {
  canActivate(route: ActivatedRouteSnapshot): boolean{
    const expectedRoles = route.data.roles;
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    let role;
    for (const index in expectedRoles){
      if (userDetails && expectedRoles[index] === userDetails.role){
        role = expectedRoles[index];
      }
    }
    if (userDetails && userDetails.role === role){
      return true;
    } else {
      return false;
    }
  }
}
