package com.example.fluxit.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.fluxit.R;
import com.example.fluxit.controller.PersonController;
import com.example.fluxit.model.Person;
import com.example.fluxit.utils.ResultListener;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentPeopleList.ListenerOfFragment{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pasteFragment(new FragmentPeopleList());
        PersonController personController = new PersonController();
        personController.bringPeople(new ResultListener<List<Person>>() {
            @Override
            public void finish(List<Person> result) {

            }
        });
    }

    private void pasteFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivity_Container,fragment)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void recievePerson(Person person) {

        FragmentDetailPeople fragmentDetailPeople = new FragmentDetailPeople();

        Bundle bundle = new Bundle();

        bundle.putSerializable(FragmentDetailPeople.KEY_PERSON,person);

        fragmentDetailPeople.setArguments(bundle);

        pasteFragment(fragmentDetailPeople);

    }
}
