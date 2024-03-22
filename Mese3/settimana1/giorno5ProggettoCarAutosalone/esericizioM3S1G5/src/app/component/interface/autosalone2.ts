export interface Autosalone2 {
    id: number
    make_model_trim_id: number
    type: string
    doors: number
    length: string
    width: string
    seats: number
    height: string
    wheel_base: string
    front_track: any
    rear_track: any
    ground_clearance: any
    cargo_capacity: string
    max_cargo_capacity: string
    curb_weight: number
    gross_weight: number
    max_payload: any
    max_towing_capacity: any
    make_model_trim: {
        id: number
        make_model_id: number
        year: number
        name: string
        description: string
        msrp: number
        invoice: number
        created: string
        modified: string
        make_model:  {
            id: number
            make_id: number
            name: string
            make: {
                id: number
                name: string
              }
          }
      }
}
