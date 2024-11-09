package com.example.pizza_tanveer

import java.io.Serializable

class PizzaOrder: Serializable {
    var isVeg: Boolean;
    var isNonVeg: Boolean;
    var noOfSlices: Int;
    var isFullPizza: Boolean;
    var isNeedDelivery: Boolean;
    var tax: Double;
    var subTotal: Double = 0.00;
    var totalCost: Double;

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
        if(isVeg){
            this.subTotal += 4.25 * noOfSlices
        } else {
            this.subTotal += 6.70 * noOfSlices
        }

        if(isNeedDelivery){
            subTotal += 5.25
        }
        this.tax = subTotal * 0.13;
        this.totalCost = this.subTotal + this.tax
    }

    override fun toString(): String {


        var finalReceipt: String = "Pizza Type: ${if(isVeg) "Veg" else "NonVeg"} \n" +
                "Number Of Slices: ${noOfSlices} \n" +
                "Price Per Slice: ${if(isVeg) "$ 4.25" else "$ 6.70"} \n" +
                "Delivery Cost: ${if (isNeedDelivery) "$ 5.25" else "$ 0.00"}\n" +
                "SubTotal: $${subTotal} \n" +
                "Total Tax: $${tax} \n" +
                "Total: $${totalCost} \n"

        return finalReceipt
    }

}