package com.example.fluxit.controller;

import com.example.fluxit.model.Person;
import com.example.fluxit.model.PersonDao;
import com.example.fluxit.utils.ResultListener;

import java.util.List;

public class PersonController {

    public void bringPeople(final ResultListener<List<Person>>viewListener){
        PersonDao personDao = new PersonDao();
        personDao.bringPeople(new ResultListener<List<Person>>(){
            @Override
            public void finish(List<Person> result){
                viewListener.finish(result);
            }
        });
    }
}
