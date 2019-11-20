package com.example.fluxit.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fluxit.R;
import com.example.fluxit.model.Person;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetailPeople extends Fragment {

    public static final String KEY_PERSON = "keyperson";

    private ImageView imageViewPerson;
    private TextView textViewName;
    private TextView textViewLast;
    private TextView textViewAge;
    private TextView textViewEmail;
    private TextView textViewCountry;
    private TextView textViewState;


    public FragmentDetailPeople() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewOfFragment =  inflater.inflate(R.layout.fragment_fragment_detail_people, container, false);
        imageViewPerson = viewOfFragment.findViewById(R.id.fragmentImage_Person);
        textViewName = viewOfFragment.findViewById(R.id.fragmentDetail_name);
        textViewLast = viewOfFragment.findViewById(R.id.fragmentDetail_last);
        textViewAge = viewOfFragment.findViewById(R.id.fragmentDetail_age);
        textViewEmail = viewOfFragment.findViewById(R.id.fragmentDetail_email);
        textViewCountry = viewOfFragment.findViewById(R.id.fragmentDetail_country);
        textViewState = viewOfFragment.findViewById(R.id.fragmentDetail_state);

        Bundle bundle = getArguments();

        Person personSelected = (Person) bundle.getSerializable(KEY_PERSON);
        Glide.with(imageViewPerson.getContext()).load(personSelected.getPhoto().getLarge()).placeholder(R.drawable.ic_refresh_black_24dp).into(imageViewPerson);
        textViewName.setText("First name: " + personSelected.getName().getFirst());
        textViewLast.setText("Last name: " +personSelected.getName().getLast());
        textViewAge.setText("Age: " +personSelected.getDob().getAge());
        textViewEmail.setText("Email: " +personSelected.getEmail());
        textViewCountry.setText("Country: " +personSelected.getLocation().getCountry());
        textViewState.setText("State: " +personSelected.getLocation().getState());

        return viewOfFragment;

    }

}
