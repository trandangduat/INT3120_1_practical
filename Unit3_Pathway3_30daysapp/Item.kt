package com.example.a30daysapp

data class Item(
    val title: String,
    val description: String
)

fun generateItems(count: Int = 30): List<Item> {
    val titles = listOf(
        "Operation Falcon", "Crimson Dawn", "Silent Echo", "Iron Shield",
        "Blue Horizon", "Storm Breaker", "Golden Path", "Shadow Hunt",
        "Silver Arrow", "Phantom Strike", "Wild River", "Emerald Flame",
        "Desert Mirage", "Frostbite", "Obsidian Tower", "Lunar Eclipse",
        "Solar Flare", "Thunderbolt", "Black Orchid", "Hidden Fortress",
        "Cobalt Wave", "Jade Blade", "Vortex Rising", "Scarlet Veil",
        "Ivory Crown", "Echo Valley", "Steel Serpent", "Twilight Guard",
        "Blazing Comet", "Radiant Dawn"
    )

    val descriptions = listOf(
        "A daring mission beyond enemy lines.",
        "Ancient secrets hidden for centuries.",
        "When silence is louder than thunder.",
        "Defenders stand tall against all odds.",
        "Where the sky meets endless seas.",
        "A storm that changes everything.",
        "The journey to greatness begins here.",
        "Shadows reveal more than light.",
        "An arrow that never misses its mark.",
        "Striking from the unseen corners.",
        "The river flows wild and free.",
        "A fire that cannot be extinguished.",
        "Mirages hide the truth of the desert.",
        "Cold winds bite deeper than steel.",
        "A tower built on forgotten stones.",
        "When the moon hides the sun.",
        "A flare that blinds the unprepared.",
        "Thunder splits the sky in two.",
        "Beauty concealing deadly power.",
        "A fortress lost in the mist.",
        "The wave crashes with unrelenting force.",
        "A blade forged in eternal jade.",
        "The rising force of chaos unleashed.",
        "A veil that hides scarlet truths.",
        "A crown of ivory, fragile yet regal.",
        "Echoes return from distant valleys.",
        "The serpent coils with lethal intent.",
        "Guardians who walk at twilight.",
        "A comet blazing across dark skies.",
        "Dawn that promises radiant hope."
    )

    return List(count) { i -> Item(titles[i], descriptions[i]) }
}
