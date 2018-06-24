import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from '../shared/account/account.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-account-edit',
  templateUrl: './account-edit.component.html',
  styleUrls: ['./account-edit.component.css']
})
export class AccountEditComponent implements OnInit, OnDestroy {

  account: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
             private router: Router,
             private accountService: AccountService) {
 }

 ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.accountService.get(id).subscribe((account: any) => {
          if (account) {
            this.account = account;
            this.account.href = account._links.self.href;
          } else {
            console.log(`Account with id '${id}' not found, returning to list`);
            this.goToList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  goToList() {
   this.router.navigate(['/account-list']);
 }

 save(form: NgForm) {
   this.accountService.save(form).subscribe(result => {
     this.goToList();
   }, error => window.alert("Account number must be four digits exact"));
 }

 remove(href) {
   this.accountService.remove(href).subscribe(result => {
     this.goToList();
   }, error => console.error(error));
 }

}
