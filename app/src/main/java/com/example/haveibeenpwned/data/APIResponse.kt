package com.example.haveibeenpwned.data

import com.google.gson.annotations.SerializedName

data class DataBreach(
        @SerializedName("Name") val name: String,
        @SerializedName("Domain")val domain: String,
        @SerializedName("BreachDate")val breachDate: String,
        @SerializedName("Description")val description: String)

