export interface Autosalone1 {
  id: number;
  make_model_id: number;
  year: number;
  name: string;
  description: string;
  msrp: number;
  invoice: number;
  created: string;
  modified: string;
  make_model: {
    id: number;
    make_id: number;
    name: string;
    make: {
      id: number;
      name: string;
    };
  };
}
