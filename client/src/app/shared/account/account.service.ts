import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AccountService {

  public LOCALHOST = '//localhost:8080';
  public ACCOUNTS = this.LOCALHOST + '/accounts';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.ACCOUNTS);
  }

  get(id: string) {
    return this.http.get(this.ACCOUNTS + '/' + id);
  }


  saveAccount(account: any, accountId: string) {
    if (accountId == null) {
      console.log("Account successfully added");
      return this.http.post(this.ACCOUNTS, account);
    } else {
      var address = this.ACCOUNTS + "/" + accountId;
      return this.http.put(address, account);
    }
  }

  removeAccount(id) {
    var address = 'http:' + this.ACCOUNTS + '/' + id;
    console.log("Address of account to be deleted is " + address);
    return this.http.delete(address);
  }
}
