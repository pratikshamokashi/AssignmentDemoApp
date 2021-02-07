package com.example.assignmentdemoapp.Data.services.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ResponseData:Serializable {
    @SerializedName("ResponseStatus")
    @Expose
    var responseStatus: Int? = null

    @SerializedName("ResponseData")
    @Expose
    var responseData: ResponseDataR? = null

    @SerializedName("Success")
    @Expose
    var success: Boolean? = null
}
class ResponseDataR {
    @SerializedName("country")
    @Expose
    var country: List<CountryR>? = null

    @SerializedName("zone")
    @Expose
    var zone: List<ZoneR>? = null

    @SerializedName("region")
    @Expose
    var region: List<RegionR>? = null

    @SerializedName("area")
    @Expose
    var area: List<AreaR>? = null

    @SerializedName("employee")
    @Expose
    var employee: List<EmployeeR>? = null
}
class ZoneR {
    @SerializedName("zone")
    @Expose
    var zone: String? = null

    @SerializedName("territory")
    @Expose
    var territory: String? = null
}
class RegionR {
    @SerializedName("region")
    @Expose
    var region: String? = null

    @SerializedName("territory")
    @Expose
    var territory: String? = null
}
class EmployeeR {
    @SerializedName("area")
    @Expose
    var area: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("territory")
    @Expose
    var territory: String? = null
}
class CountryR {
    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("territory")
    @Expose
    var territory: String? = null
}
class AreaR {
    @SerializedName("area")
    @Expose
    var area: String? = null

    @SerializedName("territory")
    @Expose
    var territory: String? = null
}