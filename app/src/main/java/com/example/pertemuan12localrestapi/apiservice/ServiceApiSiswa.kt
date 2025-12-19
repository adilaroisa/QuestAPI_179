package com.example.pertemuan12localrestapi.apiservice

import com.example.pertemuan12localrestapi.modeldata.DataSiswa
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApiSiswa {
    @GET("bacateman.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST("insertTM.php")
    suspend fun postSiswa(@Body data: DataSiswa):retrofit2.Response<Void>

}