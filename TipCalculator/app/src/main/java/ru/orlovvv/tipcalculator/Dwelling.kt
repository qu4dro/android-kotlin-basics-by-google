package ru.orlovvv.tipcalculator

abstract class Dwelling(private var residents: Int) {

    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom() = residents < capacity
    fun getRoom() {
        if (hasRoom()) residents++
    }

    abstract fun floorArea(): Double
}