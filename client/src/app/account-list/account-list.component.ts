import { Component, OnInit } from '@angular/core';
import { AccountService } from '../shared/account/account.service';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit {
  accounts: Array<any>;

  constructor(private router: Router,
    private accountService: AccountService) { }

  ngOnInit() {
    this.accountService.getAll().subscribe(data => {
      this.accounts = data;
    });
  }

  removeAccount(id) {
    this.accountService.removeAccount(id).subscribe(result => {
      location.reload();
    }, error => console.error(error));
  }

}
