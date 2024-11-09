package com.example.pizza_tanveer

import java.io.Serializable

class PizzaOrder: Serializable {
    var isVeg: Boolean;
    var isNonVeg: Boolean;
    var noOfSlices: Int;
    var isFullPizza: Boolean;
    var isNeedDelivery: Boolean;

    constructor(
        isVeg: Boolean = false,
        isNonVeg: Boolean = true,
        noOfSlices: Int = 0,
        isFullPizza: Boolean = false,
        isNeedDelivery: Boolean = false,

    ) {
        this.isVeg = isVeg
        this.isNonVeg = isNonVeg
        this.noOfSlices = noOfSlices
        this.isFullPizza = isFullPizza
        this.isNeedDelivery = isNeedDelivery

    }

    override fun toString(): String {
        var subTotal: Double = 0.00;
        if(isVeg){
            subTotal += 4.25 * noOfSlices
        } else {
            subTotal += 6.70 * noOfSlices
        }

        if(isNeedDelivery){
            subTotal += 5.25
        }
        val tax: Double = subTotal * 0.13;

        var finalReceipt: String = "Pizza Type: ${if(isVeg) "Veg" else "NonVeg"} \n" +
                "Number Of Slices: ${noOfSlices} \n" +
                "Price Per Slice: ${if(isVeg) "$ 4.25" else "$ 6.70"} \n" +
                "Delivery Cost: ${if (isNeedDelivery) "$ 5.25" else "$ 0.00"}\n" +
                "SubTotal: $${subTotal} \n" +
                "Total Tax: $${tax} \n" +
                "Total: $${subTotal + tax} \n"

        return finalReceipt
    }

}