import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { User } from './user';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Application';
  public idElement: number;
  public test: Product;
  public id: number;

  myimage:string = "assets/images/back_header.jpg";

  public products: Product[];
  public deleteProduct: Product;
  public buyProduct: Product;
  public productById: Product;

  public users: User[];
  public onAddUSer(addUser: NgForm): void{
    this.productService.addProducts(addUser.value).subscribe(
      (response: Product[]) => {
        console.log(response);
        this.getProducts();
        this.onOpenModal( this.test, 'close');
        addUser.reset();
      }, 
      (error: HttpErrorResponse) => {
        alert(error.message);
      } 
    );
  }

  constructor(private productService: ProductService){}
  
  ngOnInit(): void {
    this.getProducts();
  }
  public getId(id: number): void{
    this.idElement = id;
  }

  public getProducts(): void{
    this.productService.getProducts().subscribe(
      (response: Product[]) => {
        this.products = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  public onOpenModal(product: Product, mode: string): void{
    const main_header = document.getElementById('main_header');
    const button = document.createElement('button');
    const cont = document.getElementById('addProductForm');
    const updateedit = document.getElementById('updateProductForm');
    const close = document.getElementById('close');
    const all = document.getElementById('body');
    const buydetails = document.getElementById('buydetails');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode === 'add' && cont && all){
      button.setAttribute('data-target', '#addProductForm');
      cont.style.visibility = 'visible';
      cont.style.opacity = '1';
      all.style.opacity = '0.2';
    }
    if(mode === 'delete'){
      this.deleteProduct = product;
      button.setAttribute('data-target', '#buttondelete');
    }
    if(mode === 'edit' && updateedit && all){
      button.setAttribute('data-target', '#updateProductForm');
      updateedit.style.visibility = 'visible';
      updateedit.style.opacity = '1';
      all.style.opacity = '0.2';
    }
    if(mode === 'details' && buydetails && all){
      button.setAttribute('data-target', '#detailsorbuy');
      buydetails.style.visibility='visible';
      buydetails.style.opacity= '1';
      all.style.opacity = '0.2';
    }
    if(mode === 'close' && cont && all && updateedit && buydetails){
      close?.setAttribute('data-target','#close');
      cont.style.visibility = 'hidden';
      updateedit.style.visibility = 'hidden';
      buydetails.style.visibility = 'hidden';
      cont.style.opacity = '0';
      updateedit.style.opacity = '0';
      buydetails.style.opacity = '0';
      all.style.opacity = '1';
      all.style.transition = '1s';
    }
    main_header?.appendChild(button);
    button.click();
  }

  
  public onAddProduct(addForm: NgForm): void{
    this.productService.addProducts(addForm.value).subscribe(
      (response: Product[]) => {
        console.log(response);
        this.getProducts();
        this.onOpenModal( this.test, 'close');
        addForm.reset();
      }, 
      (error: HttpErrorResponse) => {
        alert(error.message);
      } 
    );
  }
  public updateProducts(product: NgForm): void{
    this.productService.updateProducts(product.value, this.idElement).subscribe(
      (response: Product[]) => {
        console.log(response);
        this.getProducts();
        this.onOpenModal(this.test, 'close');
      }, 
      (error: HttpErrorResponse) => {
        alert(error.message);
      } 
    );
  }

  public onDeleteProduct(product_id: number): void{
    this.productService.deleteProducts(product_id).subscribe(
      (response: void) => {
        this.getProducts();
      }, 
      (error: HttpErrorResponse) => {
        alert(error.message);
      } 
    );
  }

  public onBuyProduct(product: Product): void{
    this.buyProduct = product;
  }
}
