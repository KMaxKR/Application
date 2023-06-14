import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { environment } from "src/environments/environment";
import { User } from "./user";

@Injectable({
    providedIn: 'root'
})
export class UserService{
    
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient){}

    public getUser(): Observable<User[]>{
        return this.http.get<User[]>(`${this.apiServerUrl}/users/all`)
    }

    public addUser(user: User): Observable<User[]>{
        return this.http.post<User[]>(`${this.apiServerUrl}/users/add`, user)
    }

    public findById(user_id: number): Observable<any>{
        return this.http.get(`${this.apiServerUrl}/users/find/${user_id}`)
    }

    public deleteUser(user_id: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}/users/delete/${user_id}`)
    }
}