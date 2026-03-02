import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Address } from 'src/app/models/address';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  constructor(private httpClient:HttpClient) { }
  getAllAddress():Observable<Address[]>
    {
      return this.httpClient.get<Address[]>(`${environment.apiUrl}/address-service/api/address/getAllAddress`)
    }

  save(address:Address):Observable<void>
    {
      return this.httpClient.post<any>(`${environment.apiUrl}/address-service/api/address/create`,address)
    }

  update(id: number, address: any): Observable<any> {
    return this.httpClient.put(
      `${environment.apiUrl}/address-service/api/address/update/${id}`,
      address
    );
  }

  delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${environment.apiUrl}/address-service/api/address/${id}`);
  }
}
