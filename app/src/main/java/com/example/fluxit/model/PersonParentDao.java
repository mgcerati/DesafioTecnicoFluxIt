package com.example.fluxit.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonParentDao {

    private Retrofit retrofit;
    protected PersonService personService;

    public PersonParentDao(String baseUrl){

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        personService = retrofit.create(PersonService.class);

    }

}
