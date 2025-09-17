// 1. The output should be "The total party size is: 2030"
// 2. The issue is the "numberOfAdults" and "numberOfKids" are in string literal, thus + operator means concatenating 2 string
fun main() {
    val numberOfAdults = 20
    val numberOfKids = 30
    val total = numberOfAdults + numberOfKids
    println("The total party size is: $total")
}