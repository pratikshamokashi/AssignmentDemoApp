package com.example.assignmentdemoapp.Data.DataMapper

import com.example.assignmentdemoapp.Data.services.response.ResponseData
import com.example.assignmentdemoapp.Domain.domain.entity.*
import retrofit2.Response

class UserDataMapper {
    fun mapGetData(responseData: Response<ResponseData>):ResponseDataEntiy{
        val dataResponse: ResponseData? = responseData.body()

        val responseDataEntity = ResponseDataEntiy()
        responseDataEntity.success = dataResponse?.success
        responseDataEntity.responseData  = ResponseDataE()
        val mCountryR =dataResponse?.responseData?.country
        val mCountryE = ArrayList<CountryE>()

        for (i in 0..mCountryR!!.size - 1) {
            val mDataE = CountryE()

            mDataE.country = mCountryR.get(i).country
            mDataE.territory = mCountryR.get(i).territory
            mCountryE.add(mDataE)
        }
        val mZoneR = dataResponse.responseData?.zone
        val mZoneE = ArrayList<ZoneE>()

        for (i in 0..mZoneR!!.size - 1) {
            val mDataE = ZoneE()

            mDataE.zone = mZoneR.get(i).zone
            mDataE.territory = mZoneR.get(i).territory
            mZoneE.add(mDataE)
        }
        val mRegionR = dataResponse.responseData?.region
        val mRegionE = ArrayList<RegionE>()

        for (i in 0..mRegionR!!.size - 1) {
            val mDataE = RegionE()

            mDataE.region = mRegionR.get(i).region
            mDataE.territory = mRegionR.get(i).territory
            mRegionE.add(mDataE)
        }
        val mAreaR = dataResponse.responseData?.area
        val mAreaE = ArrayList<AreaE>()

        for (i in 0..mAreaR!!.size - 1) {
            val mDataE = AreaE()

            mDataE.area = mAreaR.get(i).area
            mDataE.territory = mAreaR.get(i).territory
            mAreaE.add(mDataE)
        }
        val mEmployeeR = dataResponse.responseData?.employee
        val mEmployeeE = ArrayList<EmployeeE>()

        for (i in 0..mEmployeeR!!.size - 1) {
            val mDataE = EmployeeE()

            mDataE.name = mEmployeeR.get(i).name
            mDataE.territory = mEmployeeR.get(i).territory
            mEmployeeE.add(mDataE)
        }
        responseDataEntity.success = dataResponse.success
        responseDataEntity.responseData = ResponseDataE()
        responseDataEntity.responseData!!.country = mCountryE
        responseDataEntity.responseData!!.zone = mZoneE
        responseDataEntity.responseData!!.region = mRegionE
        responseDataEntity.responseData!!.area = mAreaE
        responseDataEntity.responseData!!.employee = mEmployeeE
        return responseDataEntity
    }
}
