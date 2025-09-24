data class Event (
	var title: String,
    var description: String?,
    var daypart: String,
    var duration: Int
)

fun main() {
    val event = Event(
        title = "Study Kotlin", 
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = "Evening",
        duration = 15
	)
    print(event)
}