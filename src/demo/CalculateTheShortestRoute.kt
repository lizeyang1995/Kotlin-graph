fun main() {
    val graph = mutableListOf<String>("AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7")
    val parsedgraph = mutableListOf<Node>()
    graph.forEach {
        val node = Node()
        node.startPoint = it[0].toString()
        node.endPoint = it[1].toString()
        node.length = it[2].toInt() - '0'.toInt()
        parsedgraph.add(node)
    }
    calculateTheShortestRoute(parsedgraph, "A", "C")
    println(lengthOfEveryRoute)
}

fun calculateTheShortestRoute(parsedgraph: MutableList<Node>, start: String, end: String) {
    if (temporaryRoute.contains(start)) {
        temporaryRoute.removeAt(temporaryRoute.size - 1)
        return
    }
    for (index in 0 until parsedgraph.size) {
        val node = parsedgraph[index]
        if (node.startPoint == start) {
            temporaryRoute.add(node.startPoint)
            lengthOfOneRoute += node.length
            if (node.endPoint == end) {
                temporaryRoute.add(node.endPoint)
                lengthOfEveryRoute.add(lengthOfOneRoute)
                temporaryRoute.removeAt(temporaryRoute.size - 1)
                temporaryRoute.removeAt(temporaryRoute.size - 1)
                lengthOfOneRoute -= node.length
                continue
            }
            calculateTheShortestRoute(parsedgraph, node.endPoint, end)
            lengthOfOneRoute -= node.length
        }
    }
    if (temporaryRoute.size > 0) {
        temporaryRoute.removeAt(temporaryRoute.size - 1)
    }
}

var lengthOfOneRoute = 0
val lengthOfEveryRoute = mutableListOf<Int>()
