import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Address } from 'src/app/models/address';
import { AddressService } from 'src/services/address/address.service';
import { FormAddressDialogComponent } from '../form-address-dialog/form-address-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import {ConfirmDialogComponent} from "../../confirm-dialog/confirm-dialog.component";

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent {
  tabAddress: Address[] = [];
  dataSource = new MatTableDataSource<Address>();

  constructor(private addressService: AddressService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAddress();
  }

  getAddress() {
    this.addressService.getAllAddress().subscribe((r) => {

      this.tabAddress = r;
      console.log('Données récupérées :', r);
      this.dataSource = new MatTableDataSource<Address>(this.tabAddress);
      console.log(this.dataSource)
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  openDialog(): void {
    const dialogRef = this.dialog.open(FormAddressDialogComponent, {
      width: '500px',
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log('Form submitted successfully!');
        this.getAddress();
      } else {
        console.log('Form canceled.');
      }
    });
  }

  edit(address: Address): void {

    const dialogRef = this.dialog.open(FormAddressDialogComponent, {
      width: '500px',
      data: address
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.getAddress();
      }
    });
  }

  openDeleteDialog(id: number): void {

    const dialogRef = this.dialog.open(ConfirmDialogComponent);

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.addressService.delete(id).subscribe(() => {
          this.dataSource.data =
            this.dataSource.data.filter(address => address.id !== id);
        });
      }
    });
  }

  displayedColumns: string[] = ['city', 'street', 'action'];


}
