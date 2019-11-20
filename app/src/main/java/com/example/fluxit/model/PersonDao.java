package com.example.fluxit.model;

import com.example.fluxit.utils.ResultListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonDao extends PersonParentDao {

    private static final String BASE_URL = "https://randomuser.me/api/";

    public PersonDao() {
        super(BASE_URL);
    }


    public void bringPeople(final ResultListener<List<Person>> listResultListener) {

        Call<PersonContainer> call = personService.bringPeople();

        call.enqueue(new Callback<PersonContainer>(){


            @Override
            public void onResponse(Call<PersonContainer> call, Response<PersonContainer> response) {
                PersonContainer personContainer = response.body();
                listResultListener.finish(personContainer.getPersonList());
            }

            @Override
            public void onFailure(Call<PersonContainer> call, Throwable t) {

            }
        });



    }
}
