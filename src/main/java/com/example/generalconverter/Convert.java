package com.example.generalconverter;

import java.util.*;

/**
 * Represent various possible conversion of several units.
 * Basic units are the ones used for the conversion value, so for example:
 * {"Kilometer", 1000.0} -> distances -> basic unit = Meter => 1 Meter = 1000 Kilometer
 *
 * @author Gabriele Aldovardi
 */
public class Convert {
    private final int FAHRENHEIT_CONVERSION_CONSTANT = 32;
    Map<String, Double> conversionTable;
    List<String> basicUnit;

    /**
     * Create a new conversion table with a structure of an HashMap
     */
    public Convert() {
        this.conversionTable = new HashMap<>();
        this.basicUnit = new ArrayList<>();
        createConversionTable(this.conversionTable);
        Collections.addAll(basicUnit, "Celsius", "Degrees", "Meter", "Gram", "Litre", "Second", "Meter per second", "Euro", "Bit");
    }

    /**
     * Method that insert into the given map every unit associated with
     * a number which allow to convert the starting unit value into the
     * final, using basic unit:
     * temperature -> Celsius; distances -> Meter; time -> Second; ecc.
     *
     * @param conversionTable is the current map
     */
    public void createConversionTable(Map<String, Double> conversionTable) {
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

    /**
     * Convert the passed value into a new following the current conversion table
     *
     * @param start initial unit
     * @param end final unit
     * @param value initial value
     *
     * @return the value associated to the new unit
     */
    Optional<Double> convertUnit(Optional<String> start, Optional<String> end, Optional<Double> value) {
        Optional<Double> finalValue = null;
        if (basicUnit.contains(start.get())) {
            finalValue = fromBasicUnit(end, value);
        } else if (basicUnit.contains(end.get())) {
            finalValue = toBasicUnit(start, value);
        } else {
            finalValue = toBasicUnit(start, value);
            finalValue = fromBasicUnit(end, finalValue);
        }

        return finalValue;
    }

    private Optional<Double> toBasicUnit(Optional<String> start, Optional<Double> value) {
        return null;
    }

    private Optional<Double> fromBasicUnit(Optional<String> end, Optional<Double> value) {
        return null;
    }
}
