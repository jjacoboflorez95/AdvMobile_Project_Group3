package com.juanjacoboflorezmonroy.shoestore

import com.google.firebase.database.Exclude

data class Shoe(var name: String="", var image: String="", var price: String=""){

    private var _key: String = ""
    var key : String
        @Exclude
        get() {
            return _key
        }
        set(value) {
            _key = value
        }
}
