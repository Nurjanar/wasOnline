fun main() {
    val secondAgo = 86401
    val minuteAgo = secondAgo / 60
    val hoursAgo = minuteAgo / 60

    agoToText(secondAgo, minuteAgo, hoursAgo)
}

fun agoToText(
    secondAgo: Int,
    minuteAgo: Int,
    hoursAgo: Int
) {
    when (secondAgo) {
        in 0..60 -> println("«был(а) только что».")
        in 61..3599 ->
            println("был(а) $minuteAgo ${itemText(minuteAgo)} назад».")

        in 60 * 60..24 * 60 * 60 ->
            println("«был(а) $hoursAgo ${itemText2(hoursAgo)} назад»")

        in 24 * 60 * 60 + 1..48 * 60 * 60 -> println("«был(а) вчера»")
        in 48 * 60 * 60 + 1..72 * 60 * 60 -> println("«был(а) позавчера».")
        else -> println("«был(а) давно».")
    }
}


fun itemText(minuteAgo: Int): String {
    return when (minuteAgo) {
        1, 21, 31, 41, 51 -> "минуту"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "минуты"
        in 5..20 -> "минут"
        in 25..30 -> "минут"
        in 35..40 -> "минут"
        in 45..50 -> "минут"
        in 55..59 -> "минут"
        else -> itemText2(hoursAgo = minuteAgo / 60)
    }
}

fun itemText2(hoursAgo: Int): String {
    return when (hoursAgo) {
        1, 21 -> "час"
        2, 3, 4, 22, 23, 24 -> "часа"
        else -> "часов"
    }
}

