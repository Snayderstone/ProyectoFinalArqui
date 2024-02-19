import {Product} from "./product";

export class InvoiceItem {
  id: number;
  quantity: number;
  price: number;
  productId: number;
  subTotal: number;
  product: Product;
}
