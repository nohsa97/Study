package com.example.myapplicationd

/*object animals {
    var list = mutableListOf<animal>()
    fun input (name:String,many:Int) : animal {
        val ani = animal(name,many)
        list.add(ani)
        return ani
    }
}

data class animal(var name:String,var many:Int)

fun main () {
    val dog = animal("dog",10)
    val cat = animal("cat",20)

    println(dog)
    println(cat)

}*/

interface human {
    fun run ()
    fun say () {
        print("fuck")
    }
}

interface girl {
    fun run ()
    fun say () {
        print("suck")
    }
}
class man : human,girl {
    var name = "noh"
    var age = 10
    constructor(){
        print("noh , 10")
    }

    override fun say() {
        super<girl>.say()
    }
    override fun run () {
        print("fun")
    }
}

fun main () {
    var hong = man()
    var gi = man()
    print("print = ${hong.name}\n")
    hong.say()
    hong.run()
}