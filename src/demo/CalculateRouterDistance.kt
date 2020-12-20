fun main() {

    calculateRouterDistance("A-D-C")

}

fun calculateRouterDistance(route: String): Unit {
    val splitedRoute = route.split('-')
    val stopsNumber = splitedRoute.size
    val graph = mutableListOf<String>("AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7")
    var distance: Int = 0
    for (index in 0 until stopsNumber - 1) {
        val beforeLoop = distance
        run loop@{
            graph.forEach {
                if (it.startsWith(splitedRoute[index].single()) && it[1] == splitedRoute[index + 1].single()) {
                    distance += it[2].toInt() - '0'.toInt()
                    return@loop
                }
            }
        }

        if (beforeLoop == distance) {
            println("no such route")
            return
        }
    }
    println(distance)

}
