export interface Autosalone1 {
  id:                              number;
  make_model_id:                   number;
  year:                            number;
  name:                            string;
  description:                     string;
  msrp:                            number;
  invoice:                         number;
  created:                         Date;
  modified:                        Date;
  make_model_trim_interior_colors: string[];
  make_model_trim_exterior_colors: string[];
  make_model_trim_mileage:         MakeModelTrimMileage;
  make_model_trim_engine:          MakeModelTrimEngine;
  make_model_trim_body:            MakeModelTrimBody;
  make_model:                      MakeModel;
  __message:                       string;
}

export interface MakeModel {
  id:      number;
  make_id: number;
  name:    string;
  make:    Make;
}

export interface Make {
  id:   number;
  name: string;
}

export interface MakeModelTrimBody {
  id:                  number;
  make_model_trim_id:  number;
  type:                string;
  doors:               number;
  length:              string;
  width:               string;
  seats:               number;
  height:              string;
  wheel_base:          string;
  front_track:         null;
  rear_track:          null;
  ground_clearance:    string;
  cargo_capacity:      string;
  max_cargo_capacity:  string;
  curb_weight:         number;
  gross_weight:        number;
  max_payload:         number;
  max_towing_capacity: null;
}

export interface MakeModelTrimEngine {
  id:                 number;
  make_model_trim_id: number;
  engine_type:        string;
  fuel_type:          string;
  cylinders:          string;
  size:               string;
  horsepower_hp:      number;
  horsepower_rpm:     number;
  torque_ft_lbs:      number;
  torque_rpm:         number;
  valves:             number;
  valve_timing:       string;
  cam_type:           string;
  drive_type:         string;
  transmission:       string;
}

export interface MakeModelTrimMileage {
  id:                                  number;
  make_model_trim_id:                  number;
  fuel_tank_capacity:                  string;
  combined_mpg:                        number;
  epa_city_mpg:                        number;
  epa_highway_mpg:                     number;
  range_city:                          number;
  range_highway:                       number;
  battery_capacity_electric:           null;
  epa_time_to_charge_hr_240v_electric: null;
  epa_kwh_100_mi_electric:             null;
  range_electric:                      null;
  epa_highway_mpg_electric:            null;
  epa_city_mpg_electric:               null;
  epa_combined_mpg_electric:           null;
}