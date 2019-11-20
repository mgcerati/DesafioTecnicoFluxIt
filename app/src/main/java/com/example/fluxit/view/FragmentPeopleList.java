package com.example.fluxit.view;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fluxit.R;
import com.example.fluxit.controller.PersonController;
import com.example.fluxit.model.Person;
import com.example.fluxit.utils.ResultListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPeopleList extends Fragment implements AdapterPeople.AdapterOfListener {

    private RecyclerView recyclerView;

    private ListenerOfFragment listenerOfFragment;

    private SwipeRefreshLayout swipeRefreshLayout;

    private AdapterPeople adapterPeople;

    private  PersonController personController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_people_list, container, false);

        recyclerView = view.findViewById(R.id.fragmentPeople_recycler);

        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        adapterPeople = new AdapterPeople(FragmentPeopleList.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapterPeople);
        personController = new PersonController();
        userRequest();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Esto se ejecuta cada vez que se realiza el gesto
                userRequest();

                swipeRefreshLayout.setRefreshing(false);
            }

        });

        return view;

    }

    private void userRequest() {
        personController.bringPeople(new ResultListener<List<Person>>() {
            @Override
            public void finish(List<Person> result) {
                adapterPeople.setPersonList(result);
            }
        });
    }


    @Override
    public void informePersonSelected(Person person) {
        listenerOfFragment.recievePerson(person);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenerOfFragment = (ListenerOfFragment) context;
    }

    public interface ListenerOfFragment {

        public void recievePerson(Person person);

    }
}
