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
//    calculateNumberOfRouteWithMaximumStops(parsedgraph, "C", "C")
//    calculateNumberOfRouteWithExactlyStops(parsedgraph, "A", "C")
    calculateNumberOfRouteWithMaximumDistance(parsedgraph, "C", "C")
    println(numberOfmethods)
}

fun calculateNumberOfRouteWithMaximumStops(parsedgraph: MutableList<Node>, start: String, end: String) {
    for (index in 0 until parsedgraph.size) {
        val node = parsedgraph.get(index)
        if (node.startPoint == start) {
            temporaryRoute.add(node.startPoint)
            if (node.endPoint == end) {
                temporaryRoute.add(node.endPoint)
                if (temporaryRoute.size <= 4) {
                    numberOfmethods ++
                }
                temporaryRoute.removeAt(temporaryRoute.size - 1)
                temporaryRoute.removeAt(temporaryRoute.size - 1)
                continue
            }
            calculateNumberOfRouteWithMaximumStops(parsedgraph, node.endPoint, end)
        }
    }
    if (temporaryRoute.size > 0) {
        temporaryRoute.removeAt(temporaryRoute.size - 1)
    }
}

fun calculateNumberOfRouteWithExactlyStops(parsedgraph: MutableList<Node>, start: String, end: String) {
    for (index in 0 until parsedgraph.size) {
        val node = parsedgraph.get(index)
        if (node.startPoint == start && temporaryRoute.size <= 4) {
            temporaryRoute.add(node.startPoint)
            if (node.endPoint == end && temporaryRoute.size == 4) {
                temporaryRoute.add(node.endPoint)
                numberOfmethods ++
                temporaryRoute.removeAt(temporaryRoute.size - 1)
                temporaryRoute.removeAt(temporaryRoute.size - 1)
                continue
            }
            calculateNumberOfRouteWithExactlyStops(parsedgraph, node.endPoint, end)
        }
    }
    if (temporaryRoute.size > 0) {
        temporaryRoute.removeAt(temporaryRoute.size - 1)
    }
}

fun calculateNumberOfRouteWithMaximumDistance(parsedgraph: MutableList<Node>, start: String, end: String) {
    parsedgraph.forEach {
        if (it.startPoint == start && lengthOfOneRoute < 30 - it.length) {
            temporaryRoute.add(it.startPoint)
            lengthOfOneRoute += it.length
            if (it.endPoint == end) {
                temporaryRoute.add(it.endPoint)
                numberOfmethods++
                if (lengthOfOneRoute < 30) {
                    temporaryRoute.removeAt(temporaryRoute.size - 1)
                    calculateNumberOfRouteWithMaximumDistance(parsedgraph, it.endPoint, end)
                }
                temporaryRoute.removeAt(temporaryRoute.size - 1)
                lengthOfOneRoute -= it.length
                return@forEach

            }
            calculateNumberOfRouteWithMaximumDistance(parsedgraph, it.endPoint, end)
            temporaryRoute.removeAt(temporaryRoute.size - 1)
            lengthOfOneRoute -= it.length
        }
    }
}

val temporaryRoute: MutableList<String> = mutableListOf()
var numberOfmethods = 0
val resultRoute = mutableListOf<MutableList<String>>()

class Node{
    var startPoint: String = ""
    var endPoint: String = ""
    var length: Int = 0
}
