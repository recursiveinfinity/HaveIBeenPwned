package com.example.haveibeenpwned.net

import com.example.haveibeenpwned.BREACHES_API
import com.example.haveibeenpwned.data.DataBreach
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PwnService {
    @GET(BREACHES_API)
    fun getBreachesForDomain(@Query("domain") domainName: String):
            Observable<List<DataBreach>>
}