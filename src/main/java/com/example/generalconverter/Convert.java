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
    private final double FAHRENHEIT_CONVERSION_CONSTANT = 1.8;
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
        conversionTable.put("Fahrenheit", 32.0);
        conversionTable.put("Kelvin", 273.15);

        //degrees
        conversionTable.put("Radians", Math.PI / 180);
        conversionTable.put("Gradient", 200.0 / 180);

        //distances
        conversionTable.put("Kilometer", 1000.0);
        conversionTable.put("Decimeter", 0.1);
        conversionTable.put("Centimeter", 0.01);
        conversionTable.put("Millimeter", 0.001);
        conversionTable.put("Micrometer", 0.000001);
        conversionTable.put("Nanometer", 0.000000001);
        conversionTable.put("Inch", 0.0254);
        conversionTable.put("Feet", 0.3048);
        conversionTable.put("Yard", 0.9144);
        conversionTable.put("Mile", 1609.344);
        conversionTable.put("Light year", 9.454254955488e15);

        //weights
        conversionTable.put("Ton", 1000000.0);
        conversionTable.put("Kilogram", 1000.0);
        conversionTable.put("Hectogram", 100.0);
        conversionTable.put("Centigram", 0.01);
        conversionTable.put("Milligram", 0.001);
        conversionTable.put("Ounce", 28.34952);
        conversionTable.put("Pound", 453.5924);

        //volumes
        conversionTable.put("Kilolitre", 1000.0);
        conversionTable.put("Decilitre", 0.1);
        conversionTable.put("Centilitre", 0.01);
        conversionTable.put("Millilitre", 0.001);
        conversionTable.put("Gallon", 3.785412);
        conversionTable.put("Pint", 0.473176);
        conversionTable.put("Fluid Ounce", 0.0295735);
        conversionTable.put("Cubic decimeter", 1.0);
        conversionTable.put("Cubic centimeter", 0.001);
        conversionTable.put("Cubic milliliter", 0.000001);

        //times
        conversionTable.put("Nanosecond", 1e-9);
        conversionTable.put("Microsecond", 1e-6);
        conversionTable.put("Millisecond", 0.001);
        conversionTable.put("Minute", 60.0);
        conversionTable.put("Hour", 3600.0);
        conversionTable.put("Day", 86400.0);
        conversionTable.put("Week", 604800.0);
        conversionTable.put("Month", 2629440.0); // Approximate value for average month (30.43333333 days)
        conversionTable.put("Year", 31553280.0); // Approximate value for average year (365.2 days)

        //velocity
        conversionTable.put("Kilometer per second", 1000.0);
        conversionTable.put("Kilometer per hour", 0.277778);
        conversionTable.put("Meter per hour", 0.000277778);
        conversionTable.put("Miles per second", 1609.34);
        conversionTable.put("Miles per hour", 0.44704);
        conversionTable.put("Light speed", 299792458.0);
        conversionTable.put("Sound speed", 343.0);

        //currency --> dated to 08/08/2023 20:40:51
        conversionTable.put("Argentinian Pesos", 0.01022);
        conversionTable.put("UAE Dirham", 0.22727);
        conversionTable.put("Indian Rupee", 0.01164);
        conversionTable.put("Nigeria Naira", 0.00228);
        conversionTable.put("England Pound", 1.1660);
        conversionTable.put("USA dollar", 0.85175);
        conversionTable.put("Chinese Won", 0.00084);
        conversionTable.put("Japanese Yen", 0.00812);
        conversionTable.put("Korean Yuan", 0.15310);

        //data
        conversionTable.put("Byte", 8.0);
        conversionTable.put("Kilobit", 1024.0);
        conversionTable.put("Kilobyte", 8192.0);
        conversionTable.put("Megabit", 1048576.0);
        conversionTable.put("Megabyte", 8388608.0);
        conversionTable.put("Gigabit", 1073741824.0);
        conversionTable.put("Gigabyte", 8589934592.0);
        conversionTable.put("Terabit", 1099511627776.0);
        conversionTable.put("Terabyte", 8796093022208.0);
        conversionTable.put("Petabit", 1125899906842624.0);
        conversionTable.put("Petabyte", 9007199254740992.0);
        conversionTable.put("Exabit", 1152921504606846976.0);
        conversionTable.put("Exabyte", 9223372036854775808.0);
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
    double convertUnit(String start, String end, double value) {
        double finalValue = value;
        if (!start.equals(end)) {
            if (basicUnit.contains(start)) {
                finalValue = fromBasicUnit(end, value);
            } else if (basicUnit.contains(end)) {
                finalValue = toBasicUnit(start, value);
            } else {
                finalValue = toBasicUnit(start, value);
                finalValue = fromBasicUnit(end, finalValue);
            }
        }
        return finalValue;
    }

    /**
     * Convert the start basic unit value in the corresponding final unit value
     */
    private double fromBasicUnit(String end, double value) {
        double newValue = value;
        if (Unit.temperatures.contains(end)) {
            if (end.equals("Fahrenheit"))
                newValue *= FAHRENHEIT_CONVERSION_CONSTANT;

            newValue += conversionTable.get(end);
        } else {
            newValue /= conversionTable.get(end);
        }
        return newValue;
    }

    /**
     * Convert the start unit value in the corresponding basic unit value
     * of the related group
     */
    private double toBasicUnit(String start, double value) {
        double newValue = value;
        if (Unit.temperatures.contains(start)) {
            newValue -= conversionTable.get(start);

            if (start.equals("Fahrenheit"))
                newValue /= FAHRENHEIT_CONVERSION_CONSTANT;
        } else {
            newValue *= conversionTable.get(start);
        }
        return newValue;
    }
}
