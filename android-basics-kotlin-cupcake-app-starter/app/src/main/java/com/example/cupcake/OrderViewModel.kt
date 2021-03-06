package com.example.cupcake

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

private const val CAKE_PRICE = 5.00
private const val PRICE_FOR_SAME_DAY_PICKUP = 3.00

class OrderViewModel : ViewModel() {

    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int>
        get() = _quantity

    private val _flavor = MutableLiveData<String>()
    val flavor: LiveData<String>
        get() = _flavor

    private val _price = MutableLiveData<Double>()
    val price: LiveData<String> = Transformations.map(_price) {
            NumberFormat.getCurrencyInstance().format(it)
        }

    private val _date = MutableLiveData<String>()
    val date: LiveData<String>
        get() = _date

    val dateOptions = getPickupOptions()

    init {
        resetOrder()
    }

    fun setQuantity(numberCakes: Int) {
        _quantity.value = numberCakes
        updatePrice()
    }

    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
    }

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
        updatePrice()
    }

    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }

    fun resetOrder() {
        _quantity.value = 0
        _flavor.value = ""
        _date.value = dateOptions[0]
        _price.value = 0.0
    }

    private fun getPickupOptions(): List<String> {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }

    private fun updatePrice() {
        var newPrice = (quantity.value ?: 0) * CAKE_PRICE
        if (dateOptions[0] == _date.value) {
            newPrice += PRICE_FOR_SAME_DAY_PICKUP
        }
        _price.value = newPrice
    }
}
