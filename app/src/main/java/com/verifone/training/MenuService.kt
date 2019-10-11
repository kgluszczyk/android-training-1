package com.verifone.training

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST

interface MenuService {
    @GET("fake-server-menu/menu")
    fun getMenu() : Single<List<MenuItem>>
}
