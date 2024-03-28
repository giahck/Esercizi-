
export interface Product {
    id: number;
    title: string;
    description: string;
    price: number;
    discountPercentage: number;
    rating: number;
    stock: number;
    brand: string;
    category: string;
    thumbnail: string;
    images: string[];
  }
  
  export interface Card {
    total: number;
    skip: number;
    limit: number;
    products: Product[];
  }
  export interface Carello extends Product{
    amount:number//meglio evitare forse
  }