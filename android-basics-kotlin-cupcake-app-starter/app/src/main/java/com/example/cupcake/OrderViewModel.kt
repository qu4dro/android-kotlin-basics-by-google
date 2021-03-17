package com.example.cupcake

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    private val _quantity = MutableLiveData<Int>(0)
    val quantity: LiveData<Int>
        get() = _quantity

    private val _flavor = MutableLiveData<String>("")
    val flavor: LiveData<String>
        get() = _flavor

    private val _price = MutableLiveData<Double>(0.0)
    val price: LiveData<Double>
        get() = _price

    private val _date = MutableLiveData<String>("")
    val date: LiveData<String>
        get() = _date

    fun setQuantity(numberCakes: Int) {
        _quantity.value = numberCakes
    }

    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
    }

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
    }

    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }
}