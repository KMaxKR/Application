import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Product } from "./product";
import { HttpClient } from "@angular/common/http";
import { environment } from "src/environments/environment";


@Injectable({
    providedIn: 'root'
})
export class ProductService{

    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient){}

    public getProducts(): Observable<Product[]>{
        return this.http.get<Product[]>(`${this.apiServerUrl}/products/all`)
    }

    public addProducts(product: Product): Observable<Product[]>{
        return this.http.post<Product[]>(`${this.apiServerUrl}/products/add`, product)
    }

    public updateProducts(product: Product, product_id: number): Observable<any>{
        return this.http.put(`${this.apiServerUrl}/products/update/id/${product_id}`, product)
    }

    public deleteProducts(product_id: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}/products/delete/${product_id}`)
    }
}