package com.example.fluxit.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PersonService {
    @GET("?results=20")
    Call<PersonContainer>bringPeople();

}
