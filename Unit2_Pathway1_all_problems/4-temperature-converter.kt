fun main() {
    val celciusToFahrenheit: (Double) -> Double = {
        (9.0/5) * it + 32
    }
    val kelvinToCelcius: (Double) -> Double = {
        it - 273.15
    }
    val fahrenheitToKelvin: (Double) -> Double = {
        (5.0/9) * (it - 32) + 273.15
    }
    printFinalTemperature(
        initialMeasurement = 27.0, 
        initialUnit = "Celsius",
        finalUnit = "Fahrenheit",
        conversionFormula = celciusToFahrenheit
    )
    printFinalTemperature(
        initialMeasurement = 350.0, 
        initialUnit = "Kelvin",
        finalUnit = "Celsius",
        conversionFormula = kelvinToCelcius
    )
    printFinalTemperature(
        initialMeasurement = 10.0, 
        initialUnit = "Fahrenheit",
        finalUnit = "Kelvin",
        conversionFormula = fahrenheitToKelvin
    )
}

fun printFinalTemperature(
    initialMeasurement: Double, 
    initialUnit: String, 
    finalUnit: String, 
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}