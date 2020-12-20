var lengthOfOneRoute = 0
val lengthOfEveryRoute = mutableListOf<Int>()

val temporaryRoute: MutableList<String> = mutableListOf()
var numberOfmethods = 0

class Node{
    var startPoint: String = ""
    var endPoint: String = ""
    var length: Int = 0
}