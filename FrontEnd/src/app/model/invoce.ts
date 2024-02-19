import {Customer} from "./customer";
import {InvoiceItem} from "./invoiceItem";

export class Invoice {
  id: number;
  numberInvoice: string;
  description: string;
  customerId: number;
  createAt: Date;
  items: InvoiceItem[];
  state: string;
  customer: Customer;
}
