public class Converter {

    public static boolean convert_successful = true;

    public static double convertToCelsius(String fahrenheit_str) {

        double celsius, fahrenheit_double,five,nine;

        five = 5;
        nine = 9;
        celsius = 0;

        try {
            fahrenheit_double  = Double.parseDouble(fahrenheit_str);
            celsius = (five/nine) * (fahrenheit_double - 32);
            convert_successful = true;
        }
        catch (Exception e) {
            convert_successful = false;
        }

        return celsius;
    }

    public static double convertToKelvin (String fahrenheit_str) {

        double celsius = convertToCelsius(fahrenheit_str);
        double kelvin = celsius + 273.15;

        return kelvin;
    }
}
