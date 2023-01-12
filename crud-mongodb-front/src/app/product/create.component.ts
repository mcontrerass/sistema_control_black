import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Product } from '../model/product';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  nombre!: string;
  precio!: number;

  constructor(
    private productService: ProductService,
    private toast: ToastrService,
    private router: Router
  ) {}

  ngOnInit(): void {
  }

  onCreate(): void {
    const product = new Product(this.nombre, this.precio);
    this.productService.create(product).subscribe(
      data => {
        this.toast.success(data.message, 'OK', { timeOut: 30000, positionClass: 'toast-top-center' });
        this.router.navigate(['']);
      },
      err => {
        this.toast.error(err.error.message, 'Error', { timeOut: 30000, positionClass: 'toast-top-center' });
      }
    );
  }
}
