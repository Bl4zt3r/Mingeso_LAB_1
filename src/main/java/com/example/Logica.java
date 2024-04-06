package com.example;

import java.util.Arrays;
import java.util.List;

public class Logica {



    //public Double getRecargoDiaAtraso();
    //public Double getDescuentoReparaciones(String modelo, Integer cReparaciones);




    /*
    ------------------------------------------
    | COSTO POR TIPO DE REPARACION           |
    ------------------------------------------
    */

    List<Integer> CostGasolina = Arrays.asList(120000, 130000, 350000, 210000, 150000, 100000,100000,180000,150000,130000,80000);
    List<Integer> CostDiesel = Arrays.asList(120000, 130000, 450000, 210000, 150000, 120000,100000,180000,150000,140000,80000);
    List<Integer> CostHibrido = Arrays.asList(180000, 190000, 700000, 300000, 200000,450000,100000,210000,180000,220000,80000);
    List<Integer> CostElectrico = Arrays.asList(220000, 230000, 800000, 300000, 250000,0,100000,250000,180000,0,80000);


    public Integer getCostoReparacion(String modelo, Integer nReparacion) {
        Integer[] costo = null;

        if (nReparacion == 1) {
            costo = new Integer[]{CostGasolina.get(0), CostDiesel.get(0), CostHibrido.get(0), CostElectrico.get(0)};
        } else if (nReparacion == 2) {
            costo = new Integer[]{CostGasolina.get(1), CostDiesel.get(1), CostHibrido.get(1), CostElectrico.get(1)};
        } else if (nReparacion == 3) {
            costo = new Integer[]{CostGasolina.get(2), CostDiesel.get(2), CostHibrido.get(2), CostElectrico.get(2)};
        } else if (nReparacion == 4) {
            costo = new Integer[]{CostGasolina.get(3), CostDiesel.get(3), CostHibrido.get(3), CostElectrico.get(3)};
        } else if (nReparacion == 5) {
            costo = new Integer[]{CostGasolina.get(4), CostDiesel.get(4), CostHibrido.get(4), CostElectrico.get(4)};
        } else if (nReparacion == 6) {
            costo = new Integer[]{CostGasolina.get(5), CostDiesel.get(5), CostHibrido.get(5), CostElectrico.get(5)};
        } else if (nReparacion == 7) {
            costo = new Integer[]{CostGasolina.get(6), CostDiesel.get(6), CostHibrido.get(6), CostElectrico.get(6)};
        } else if (nReparacion == 8) {
            costo = new Integer[]{CostGasolina.get(7), CostDiesel.get(7), CostHibrido.get(7), CostElectrico.get(7)};
        } else if (nReparacion == 9) {
            costo = new Integer[]{CostGasolina.get(8), CostDiesel.get(8), CostHibrido.get(8), CostElectrico.get(8)};
        } else if (nReparacion == 10) {
            costo = new Integer[]{CostGasolina.get(9), CostDiesel.get(9), CostHibrido.get(9), CostElectrico.get(9)};
        } else {
            costo = new Integer[]{CostGasolina.get(10), CostDiesel.get(10), CostHibrido.get(10), CostElectrico.get(10)};
        }

        switch (modelo) {
            case "Gasolina":
                return costo[0];
            case "Diesel":
                return costo[1];
            case "Hibrido":
                return costo[2];
            case "Electrico":
                return costo[3];
            default:
                return 0;
        }
    }


    /*--------------------------------------------------------------------- */


    /*
    ------------------------------------------
    | DESCUENTO POR CANTIDAD DE REPARACIONES |
    ------------------------------------------
    */

    // Descuentos por cantidad de reparaciones durantes los ultimos 12 meses
    // El primer valor corresponde, entre 1 y 2 reparaciones
    // El segundo valor corresponde, entre 2 y 5 reparaciones
    // El tercer valor corresponde, entre 5 y 8 reparaciones
    // El cuarto valor corresponde, entre 10 o mas reparaciones


    List<Double> DescGasolina = Arrays.asList(0.05, 0.07, 0.10, 0.08);
    List<Double> DescDiesel = Arrays.asList(0.05, 0.07, 0.10, 0.08);
    List<Double> DescHibrido = Arrays.asList(0.05, 0.07, 0.10, 0.08);
    List<Double> DescElectrico = Arrays.asList(0.05, 0.07, 0.10, 0.08);

    public Double getDescuentoReparaciones(String modelo, Integer cReparaciones) {
        Double[] descuentos = null;

        if (cReparaciones <= 2) {
            descuentos = new Double[]{DescGasolina.get(0), DescDiesel.get(0), DescHibrido.get(0), DescElectrico.get(0)};
        } else if (cReparaciones <= 5) {
            descuentos = new Double[]{DescGasolina.get(1), DescDiesel.get(1), DescHibrido.get(1), DescElectrico.get(1)};
        } else if (cReparaciones <= 9) {
            descuentos = new Double[]{DescGasolina.get(2), DescDiesel.get(2), DescHibrido.get(2), DescElectrico.get(2)};
        } else {
            descuentos = new Double[]{DescGasolina.get(3), DescDiesel.get(3), DescHibrido.get(3), DescElectrico.get(3)};
        }

        switch (modelo) {
            case "Gasolina":
                return descuentos[0];
            case "Diesel":
                return descuentos[1];
            case "Hibrido":
                return descuentos[2];
            case "Electrico":
                return descuentos[3];
            default:
                return 0.0;
        }
    }


    /*--------------------------------------------------------------------- */

    /*
    ------------------------------------------
    | DESCUENTO FIJO POR DIAS ESPECIALES |
    ------------------------------------------
    */

    // Descuento por dia de atencion, si entra al taller desde las 9:00 am hasta las 12:00 pm
    // porcentaje 0 a 100%; ej: 0.1 -> 10%
    Double DescXDia = 0.1;

    public Double getDescuentoDiaEspecial(){
        return DescXDia;
    }

    /*--------------------------------------------------------------------- */


    // Bonos

    List<Integer> Desc_bono_toyota ;

    /*--------------------------------------------------------------------- */
    /*
    ------------------------------------------
    | RECARGOS POR ANTIGUEDAD DEL AUTO        |
    ------------------------------------------
    */
    List<Double> rec_antiguedad_sedan = Arrays.asList(0.0,0.03,0.12,0.20);
    List<Double> rec_antiguedad_hatchback = Arrays.asList(0.0,0.03,0.12,0.20);
    List<Double> rec_antiguedad_suv = Arrays.asList(0.0,0.03,0.12,0.20);
    List<Double> rec_antiguedad_pickup = Arrays.asList(0.0,0.03,0.12,0.20);
    List<Double> rec_antiguedad_furgoneta = Arrays.asList(0.0,0.03,0.12,0.20);
    public Double getRecargoAntiguedad(String vehicleType, int yearsOfAntiquity) {
        Double[] recargoAntiguedad = null;

        if (yearsOfAntiquity >= 0 && yearsOfAntiquity <= 5) {
            recargoAntiguedad = new Double[]{rec_antiguedad_sedan.get(0), rec_antiguedad_hatchback.get(0), rec_antiguedad_suv.get(0), rec_antiguedad_pickup.get(0), rec_antiguedad_furgoneta.get(0)};
        } else if (yearsOfAntiquity <= 10) {
            recargoAntiguedad = new Double[]{rec_antiguedad_sedan.get(1), rec_antiguedad_hatchback.get(1), rec_antiguedad_suv.get(1), rec_antiguedad_pickup.get(1), rec_antiguedad_furgoneta.get(1)};
        } else if (yearsOfAntiquity <= 15) {
            recargoAntiguedad = new Double[]{rec_antiguedad_sedan.get(2), rec_antiguedad_hatchback.get(2), rec_antiguedad_suv.get(2), rec_antiguedad_pickup.get(2), rec_antiguedad_furgoneta.get(2)};
        } else {
            recargoAntiguedad = new Double[]{rec_antiguedad_sedan.get(3), rec_antiguedad_hatchback.get(3), rec_antiguedad_suv.get(3), rec_antiguedad_pickup.get(3), rec_antiguedad_furgoneta.get(3)};
        }

        switch (vehicleType) {
            case "Sedán":
                return recargoAntiguedad[0];
            case "Hatchback":
                return recargoAntiguedad[1];
            case "SUV":
                return recargoAntiguedad[2];
            case "Pickup":
                return recargoAntiguedad[3];
            case "Furgoneta":
                return recargoAntiguedad[4];
            default:
                return 0.0;
        }
    }

    /*--------------------------------------------------------------------- */

    /*
     ------------------------------------------
     | RECARGOS POR KILOMETRAJE DEL AUTO      |
     ------------------------------------------
     */

    List<Double> rec_kilometraje_sedan = Arrays.asList(0.0,0.03,0.12,0.20);
    List<Double> rec_kilometraje_hatchback = Arrays.asList(0.0,0.03,0.12,0.20);
    List<Double> rec_kilometraje_suv = Arrays.asList(0.0,0.03,0.12,0.20);
    List<Double> rec_kilometraje_pickup = Arrays.asList(0.0,0.03,0.12,0.20);
    List<Double> rec_kilometraje_furgoneta = Arrays.asList(0.0,0.03,0.12,0.20);

    public Double getRecargoKilometraje(String vehicleType, int kilometraje) {
        Double[] recargokilometraje = null;

        if (kilometraje >= 0 && kilometraje <= 5000) {
            recargokilometraje = new Double[]{rec_kilometraje_sedan.get(0), rec_kilometraje_hatchback.get(0), rec_kilometraje_suv.get(0), rec_kilometraje_pickup.get(0), rec_kilometraje_furgoneta.get(0)};
        } else if (kilometraje <= 12000) {
            recargokilometraje = new Double[]{rec_kilometraje_sedan.get(1), rec_kilometraje_hatchback.get(1), rec_kilometraje_suv.get(1), rec_kilometraje_pickup.get(1), rec_kilometraje_furgoneta.get(1)};
        } else if (kilometraje <= 25000) {
            recargokilometraje = new Double[]{rec_kilometraje_sedan.get(2), rec_kilometraje_hatchback.get(2), rec_kilometraje_suv.get(2), rec_kilometraje_pickup.get(2), rec_kilometraje_furgoneta.get(2)};
        } else if (kilometraje <= 40000) {
            recargokilometraje = new Double[]{rec_kilometraje_sedan.get(3), rec_kilometraje_hatchback.get(3), rec_kilometraje_suv.get(3), rec_kilometraje_pickup.get(3), rec_kilometraje_furgoneta.get(3)};
        }else {
            recargokilometraje = new Double[]{rec_kilometraje_sedan.get(4), rec_kilometraje_hatchback.get(4), rec_kilometraje_suv.get(4), rec_kilometraje_pickup.get(4), rec_kilometraje_furgoneta.get(4)};
        }

        switch (vehicleType) {
            case "Sedán":
                return recargokilometraje[0];
            case "Hatchback":
                return recargokilometraje[1];
            case "SUV":
                return recargokilometraje[2];
            case "Pickup":
                return recargokilometraje[3];
            case "Furgoneta":
                return recargokilometraje[4];
            default:
                return 0.0;
        }
    }

    /*--------------------------------------------------------------------- */

    /*
    ------------------------------------------
    | RECARGOS POR ATRASO EN RETIRO DEL AUTO      |
    ------------------------------------------
    */
    Double rec_retiro_atrasado = 0.05;

    public Double getRecargoDiaAtraso(){
        return rec_retiro_atrasado;
    }




}




//public Double getDescuentoReparaciones2(String modelo, Integer cReparaciones){
//    if(cReparaciones <= 2) {
//        if (modelo == "Gasolina") {
//            return DescGasolina.get(0);
//        }
//        if (modelo == "Diesel") {
//            return DescDiesel.get(0);
//        }
//        if (modelo == "Hibrido") {
//            return DescHibrido.get(0);
//        }
//        if (modelo == "Electrico") {
//            return DescElectrico.get(0);
//        }
//    }
//    if( 3 <= cReparaciones && cReparaciones <= 5) {
//        if (modelo == "Gasolina") {
//            return DescGasolina.get(1);
//        }
//        if (modelo == "Diesel") {
//            return DescDiesel.get(1);
//        }
//        if (modelo == "Hibrido") {
//            return DescHibrido.get(1);
//        }
//        if (modelo == "Electrico") {
//            return DescElectrico.get(1);
//        }
//    }
//
//    if( 6 <= cReparaciones && cReparaciones <= 9) {
//        if (modelo == "Gasolina") {
//            return DescGasolina.get(2);
//        }
//        if (modelo == "Diesel") {
//            return DescDiesel.get(2);
//        }
//        if (modelo == "Hibrido") {
//            return DescHibrido.get(2);
//        }
//        if (modelo == "Electrico") {
//            return DescElectrico.get(2);
//        }
//    }
//    if( 10 <= cReparaciones) {
//        if (modelo == "Gasolina") {
//            return DescGasolina.get(3);
//        }
//        if (modelo == "Diesel") {
//            return DescDiesel.get(3);
//        }
//        if (modelo == "Hibrido") {
//            return DescHibrido.get(3);
//        }
//        if (modelo == "Electrico") {
//            return DescElectrico.get(3);
//        }
//    }
//    return 0.0;
//}
