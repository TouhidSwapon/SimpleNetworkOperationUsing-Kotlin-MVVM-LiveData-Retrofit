package com.swapon.simplenetworkoperationusingmvvm.model.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("page")
    @Expose
    var page: Int? = null
    @SerializedName("per_page")
    @Expose
    var perPage: Int? = null
    @SerializedName("total")
    @Expose
    var total: Int? = null
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null
    @SerializedName("data")
    @Expose
    var data: List<UserData>? = null


    inner class UserData {

        @SerializedName("id")
        @Expose
        var id: Int? = null
        @SerializedName("email")
        @Expose
        var email: String? = null
        @SerializedName("first_name")
        @Expose
        var firstName: String? = null
        @SerializedName("last_name")
        @Expose
        var lastName: String? = null
        @SerializedName("avatar")
        @Expose
        var avatar: String? = null

    }


}
