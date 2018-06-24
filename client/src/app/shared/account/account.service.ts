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
    return this.http.get(this.LOCALHOST + '/select-accounts');
  }
  get(id: string) {
    return this.http.get(this.ACCOUNTS + '/' + id);
  }

  save(account: any): Observable<any> {
    let result: Observable<Object>;
    if (account['href']) {
      result = this.http.put(account.href, account);
    } else {
      result = this.http.post(this.ACCOUNTS, account);
    }
    return result;
  }
  remove(href: string) {
    console.log(href);
    return this.http.delete(href);
  }
  removeAccount(id) {
    var address = 'http:' + this.ACCOUNTS + '/' + id;
    console.log(address);
    return this.http.delete(address);
  }
}
