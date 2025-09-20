class Song(
	var title: String,
    var artist: String,
    var yearPublished: Int,
) {  
    var isPopular: Boolean = false
    
    constructor(title: String, artist: String, yearPublished: Int, playCount: Int) 
    : this(title, artist, yearPublished) {
		isPopular = if (playCount >= 1000) true else false
    }
    
    fun printSongDescription() {
        println("$title, performed by $artist, was released in $yearPublished")
    }
}

fun main() {
    var song = Song(
		title = "Dun lam trai tim anh dau",
        artist = "Son Tung MTP",
        yearPublished = 2024,
        playCount = 155000000
    )
    song.printSongDescription()
    println(song.isPopular)
}