package com.example.generalconverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that represent various possible conversion of several units
 *
 * @author Gabriele Aldovardi
 */
public class Convert {
    private final int FAHRENHEIT_CONVERSION_CONSTANT = 32;
    Map<String, Double> conversionTable;

    /**
     * Create a new conversion table with a structure of an HashMap
     */
    Convert() {
        this.conversionTable = new HashMap<>();
        createConversionTable(this.conversionTable);
    }
    /**
     * Method that insert into the given map every unit associated with
     * a number which allow to convert the starting unit value into the
     * final, using basic unit:
     * temperature -> Celsius; distances -> Meter; time -> Second; ecc.
     *
     * @param conversionTable is the current map
     * */
    void createConversionTable(Map<String, Double> conversionTable) {
        //temperatures
        conversionTable.put("Fahrenheit", 1.8);
        conversionTable.put("Kelvin", 273.15);

        //degrees

        //distances
        conversionTable.put("Kilometer", 1000.0);
        conversionTable.put("Decimeter", 0.1);
        conversionTable.put("Centimeter", 0.01);
        conversionTable.put("Millimeter", 0.001);
        conversionTable.put("Micrometer", 0.000001);
        conversionTable.put("Nanometer", 0.000000001);
        conversionTable.put("Feet", 0.3048);
        conversionTable.put("Yard", 0.9144);
        conversionTable.put("Inch", 0.0254);
        conversionTable.put("Mile", 1609.344);
        conversionTable.put("Light year", 9.454254955488e15);

        //weights
    }
}
