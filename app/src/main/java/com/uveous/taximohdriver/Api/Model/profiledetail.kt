package com.uveous.taximohdriver.Api.Model

import com.google.gson.annotations.SerializedName

data class profiledetail (

    @SerializedName("status")
    var status:Int,
    @SerializedName("user_id")
    val user_id: Int? = null,
    @SerializedName("msg")
    val msg: String? = null,
   @SerializedName("first_name")
    val first_name: String? = null,
    @SerializedName("last_name")
    val last_name: String? = null,
    @SerializedName("mobile")
    val mobile: String? = null,
    @SerializedName("email")
    val email: String? = null,
      @SerializedName("dob")
    val dob: String? = null ,
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("pincode")
    val pincode: String? = null,
    @SerializedName("profile_photo")
    val profile_photo: String? = null,
    @SerializedName("vehicle_type")
    val vehicle_type: String? = null
)

