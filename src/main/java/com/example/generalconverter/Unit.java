package com.example.generalconverter;

import java.util.Arrays;
import java.util.List;

/**
 * Contains all the units used for this app
 */
public class Unit {
    static final List<String> temperatures = Arrays.asList("Celsius", "Fahrenheit", "Kelvin");
    static final List<String> angles = Arrays.asList("Degrees", "Radiant", "Gradient");
    static final List<String> distances = Arrays.asList("Kilometer", "Meter", "Decimeter", "Centimeter", "Millimeter", "Micrometer", "Nanometer", "Inch", "Feet", "Yard", "Mile", "Light year");
    static final List<String> weights = Arrays.asList("Kilogram", "Hectogram", "Gram", "Centigram", "Milligram", "Ounce", "Pound", "Ton");
    static final List<String> volumes = Arrays.asList("Kilolitre", "Litre", "Decilitre", "Centilitre", "Millilitre", "Gallon", "Pint", "Fluid Ounce", "Cubic decimeter", "Cubic centimeter", "Cubic milliliter");
    static final List<String> times = Arrays.asList("Nanosecond", "Microsecond", "Millisecond", "Second", "Minute", "Hour", "Day", "Month", "Week", "Year");
    static final List<String> velocity = Arrays.asList("Kilometer per second", "Kilometer per hour", "Meter per second", "Meter per hour", "Miles per second", "Miles per hour", "Light speed", "Sound speed");
    static final List<String> currency = Arrays.asList("Argentinian-Pesos", "Dirham", "Euro", "Indian-Rupee", "Naira", "Pound", "US-dollar", "Won", "Yen", "Yuan");
    static final List<String> data = Arrays.asList("Bit", "Byte", "Kilobit", "Kilobyte", "Megabit", "Megabyte", "Gigabit", "Gigabyte", "Terabit", "Terabyte", "Petabit", "Petabyte", "Exabit", "Exabyte");
    static final List<List<String>> allUnits = List.of(temperatures, angles, distances, weights, volumes, times, velocity, currency, data);
}
