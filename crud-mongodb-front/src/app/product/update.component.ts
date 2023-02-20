import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Subscription } from 'rxjs';
import { Product } from '../model/product';
import { MessageService } from '../services/message.service';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit, OnDestroy{

  product!: Product;

  subscription: Subscription | undefined;

  constructor(
    private productService: ProductService,
    private toast: ToastrService,
    private router: Router,
    private messageService: MessageService
  ) {}
  
  ngOnInit(): void {
    this.getProduct();
  }

  onUpdate(): void {
    this.productService.update(this.product.id, this.product).subscribe(
      data => {
        this.toast.success(data.message, 'OK', { timeOut: 30000, positionClass: 'toast-top-center' });
        this.router.navigate(['']);
      },
      err => {
        this.toast.error(err.error.message, 'Error', { timeOut: 30000, positionClass: 'toast-top-center' });
      }
    );
  }

  getProduct(): void {
    this.subscription = this.messageService.getMessage().subscribe(
      data => {
        this.product = data.product; 
        console.log(data.product);
      },
      err => {
        console.log(err);
      }
    );
  }

  ngOnDestroy(): void {
    this.subscription?.unsubscribe;
  }
}