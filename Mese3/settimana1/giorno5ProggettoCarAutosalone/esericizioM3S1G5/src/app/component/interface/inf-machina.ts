export interface InfMachina {
    name: string;
    anno:number;
    data: {
      id: number;/* fa riferimento alla macchina */
      make: { id: number; name: string };/* fa riferimento alla concessionaria */
      make_id: number;
      name: string;
    }[];
  
}
