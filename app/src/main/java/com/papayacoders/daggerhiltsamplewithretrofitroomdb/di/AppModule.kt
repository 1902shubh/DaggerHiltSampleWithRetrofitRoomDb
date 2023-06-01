package com.papayacoders.daggerhiltsamplewithretrofitroomdb.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
class AppModule {


    fun getApiInterface() : ApiInterface{

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)
    }


}