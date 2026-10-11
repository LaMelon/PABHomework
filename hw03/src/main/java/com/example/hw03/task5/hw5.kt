package com.example.hw03.task5

abstract class SmartDevice(val name: String) {
    abstract fun turnOn()
    fun showName() {
        println(name)
    }
}
interface Connectable {
    fun connect()
}
interface Rechargeable {
    fun charge()
}
class SmartWatch(name: String) : SmartDevice(name), Connectable, Rechargeable {
    private var battery: Int = 50
        set(value) {
            field = value.coerceIn(0, 100)
        }
    var ownerName: String? = null
    override fun turnOn() {
        println("$name is ON")
    }
    override fun connect() {
        println("$name connected to phone")
    }
    override fun charge() {
        battery += 20
        println("Battery: $battery%")
    }
    fun showOwner() {
        println("Owner: ${ownerName ?: "Not set"}")
    }
}
fun main() {
    val watch = SmartWatch("Galaxy Watch")
    watch.showName()
    watch.turnOn()
    watch.connect()

    watch.charge()
    watch.charge()
    watch.charge()

    watch.showOwner()
    watch.ownerName = "Rani"
    watch.showOwner()
}