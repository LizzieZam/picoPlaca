import { Injectable } from '@angular/core';
import { Auto } from './auto';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AutoServiceService {
                        
  private autosUrl: string;
   httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token',
      'Access-Control-Allow-Origin': '*',
    })
  };
  
  constructor(protected  http: HttpClient) {
    this.autosUrl = 'http://localhost:8080/auto/';
  }
  

  public search(placa,fecha,hora){
    return this.http.get(this.autosUrl+placa+"/"+fecha+"/"+hora+"/", {responseType: 'text'});
} 
 
  public save(auto: Auto) {
    return this.http.post<Auto>(this.autosUrl, auto,this.httpOptions);
  }
}
