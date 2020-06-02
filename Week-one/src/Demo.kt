class Person{
    var name = ""
    var lastName: String? = null
    var age: Int = 0
}


fun main() {
    val filip = Person()

    filip.name = "marvin collins"
    filip.lastName = "colly"


    println(filip.name)
}