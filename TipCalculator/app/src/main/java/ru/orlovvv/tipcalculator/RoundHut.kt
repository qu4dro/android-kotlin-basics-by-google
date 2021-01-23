package ru.orlovvv.tipcalculator

import kotlin.math.PI
import kotlin.math.sqrt

open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea() = radius * radius * PI

    fun calculateMaxCarpetSize(): Double {
        val diameter = radius * 2
        return sqrt(diameter * diameter / 2)
    }
}