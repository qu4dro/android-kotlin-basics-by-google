package ru.orlovvv.tipcalculator

import kotlin.math.PI

class RoundTower(residents: Int, radius: Double, val floors: Int = 3) :
    RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors

    override fun floorArea() = super.floorArea() * floors
}