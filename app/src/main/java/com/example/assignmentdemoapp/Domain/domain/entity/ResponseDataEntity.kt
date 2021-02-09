package com.example.assignmentdemoapp.Domain.domain.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ResponseDataEntiy:Serializable {
     @SerializedName("ResponseStatus")
        @Expose
        var responseStatus: Int? = null

        @SerializedName("ResponseData")
        @Expose
        var responseData: ResponseDataE? = null

        @SerializedName("Success")
        @Expose
        var success: Boolean? = null
    }
    class ResponseDataE {
        @SerializedName("country")
        @Expose
        var country: List<CountryE>? = null

        @SerializedName("zone")
        @Expose
        var zone: List<ZoneE>? = null

        @SerializedName("region")
        @Expose
        var region: List<RegionE>? = null

        @SerializedName("area")
        @Expose
        var area: List<AreaE>? = null

        @SerializedName("employee")
        @Expose
        var employee: List<EmployeeE>? = null
    }
    class ZoneE {
        @SerializedName("zone")
        @Expose
        var zone: String? = null

        @SerializedName("territory")
        @Expose
        var territory: String? = null

        override fun toString(): String {
            return "$zone"
        }

    }
    class RegionE {
        @SerializedName("region")
        @Expose
        var region: String? = null

        @SerializedName("territory")
        @Expose
        var territory: String? = null
        override fun toString(): String {
            return "$region"
        }
    }
    class EmployeeE:Serializable {
        @SerializedName("area")
        @Expose
        var area: String? = null

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("territory")
        @Expose
        var territory: String? = null

        override fun toString(): String {
            return "$name"
        }
    }
    class CountryE {
        @SerializedName("country")
        @Expose
        var country: String? = null

        @SerializedName("territory")
        @Expose
        var territory: String? = null

        override fun toString(): String {
            return "$country"
        }
    }
    class AreaE {
        @SerializedName("area")
        @Expose
        var area: String? = null

        @SerializedName("territory")
        @Expose
        var territory: String? = null

        override fun toString(): String {
            return "$area"
        }
    }
