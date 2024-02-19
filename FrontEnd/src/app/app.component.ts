import {Component, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Chart}  from "chart.js";
import {AppService} from "./service/app.service";
import {HttpClientModule} from "@angular/common/http";
import { NgChartsModule } from 'ng2-charts';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,HttpClientModule,NgChartsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'analisis-datos-services';
  chartProducts: any
  chartCustomers: any
  chartShopping: any
  constructor(
    private appService: AppService
  ) {
  }

  ngOnInit() {
    this.drawProducts()
    this.drawCustomers()
    this.drawShopping()
  }

  drawProducts() {
    this.appService.findAllProduct().subscribe(p => {
      let stock = p.map(x => x.stock)
      let producto = p.map(x => x.name)

      this.chartProducts = new Chart('canvasProducts', {
        type: 'polarArea',
        data: {
          labels: producto,
          datasets: [{
            label: 'Productos',
            data: stock,
            backgroundColor: [
              'rgba(255, 99, 132, 0.2)',
              'rgba(54, 162, 235, 0.2)',
              'rgba(255, 206, 86, 0.2)',
              'rgba(75, 192, 192, 0.2)',
              'rgba(153, 102, 255, 0.2)',
              'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
              'rgba(255, 99, 132, 1)',
              'rgba(54, 162, 235, 1)',
              'rgba(255, 206, 86, 1)',
              'rgba(75, 192, 192, 1)',
              'rgba(153, 102, 255, 1)',
              'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
          }]
        },
        options: {
          plugins: {
            legend: {
              display: false
            },
            title:{
              display: true,
              text: 'Stock de Productos'
            }
          }
        }
      });
    })
  }

  drawCustomers() {
    this.appService.findAllCustomers().subscribe(c => {
      const customerCountsByRegion: { [key: string]: number } = {};
      c.forEach(customer => {
        const regionName = customer.region.name;
        customerCountsByRegion[regionName] = (customerCountsByRegion[regionName] || 0) + 1;
      });

      const regions = Object.keys(customerCountsByRegion);
      const customerCounts = Object.values(customerCountsByRegion);


      this.chartCustomers = new Chart('canvasCustomer', {
        type: 'bar',
        data: {
          labels: regions,
          datasets: [{
            label: 'Customers',
            data: customerCounts,
            backgroundColor: [
              'rgba(255, 99, 132, 0.2)',
              'rgba(54, 162, 235, 0.2)',
              'rgba(255, 206, 86, 0.2)',
              'rgba(75, 192, 192, 0.2)',
              'rgba(153, 102, 255, 0.2)',
              'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
              'rgba(255, 99, 132, 1)',
              'rgba(54, 162, 235, 1)',
              'rgba(255, 206, 86, 1)',
              'rgba(75, 192, 192, 1)',
              'rgba(153, 102, 255, 1)',
              'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
          }]
        },
        options: {
          plugins: {
            legend: {
              display: false
            },
            title:{
              display: true,
              text: 'Clientes por Region'
            }
          }
        }
      });
    })
  }

  drawShopping() {
    this.appService.findAllShopping().subscribe(c => {
      let dates = c.map(x => new Date(x.createAt).toLocaleDateString()); // Obtener solo la fecha

      // Ordenar las fechas de manera ascendente
      dates.sort((a, b) => new Date(a).getTime() - new Date(b).getTime());

      let total = c.map(x => x.items.reduce((acc, item) => acc + item.subTotal, 0));

      this.chartShopping = new Chart('canvasShopping', {
        type: 'line',
        data: {
          labels: dates,
          datasets: [{
            label: 'Total',
            data: total,
            backgroundColor: [
              'rgba(255, 99, 132, 0.2)',
              'rgba(54, 162, 235, 0.2)',
              'rgba(255, 206, 86, 0.2)',
              'rgba(75, 192, 192, 0.2)',
              'rgba(153, 102, 255, 0.2)',
              'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
              'rgba(255, 99, 132, 1)',
              'rgba(54, 162, 235, 1)',
              'rgba(255, 206, 86, 1)',
              'rgba(75, 192, 192, 1)',
              'rgba(153, 102, 255, 1)',
              'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
          }]
        },
        options: {
          plugins: {
            legend: {
              display: false
            },
            title:{
              display: true,
              text: 'Precio Facturas'
            }
          }
        }
      });
    })
  }
}
