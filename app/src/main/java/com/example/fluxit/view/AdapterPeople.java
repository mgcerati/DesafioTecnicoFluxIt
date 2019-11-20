package com.example.fluxit.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fluxit.R;
import com.example.fluxit.model.Person;

import java.util.ArrayList;
import java.util.List;

public class AdapterPeople extends RecyclerView.Adapter<AdapterPeople.ViewHolderPeople> {

    private List<Person> personList;
    private AdapterOfListener adapterOfListener;

    public AdapterPeople(List<Person> personList) {
        this.personList = personList;
    }
    public AdapterPeople(AdapterOfListener adapterOfListener){
        personList = new ArrayList<>();
        this.adapterOfListener = adapterOfListener;
    }

    @NonNull
    @Override
    public ViewHolderPeople onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewcell = inflater.inflate(R.layout.cell_person,parent,false);
        return new ViewHolderPeople(viewcell);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPeople holder, int position) {
        Person personShow = personList.get(position);
        holder.loadPerson(personShow);
    }

    @Override
    public int getItemCount() { return personList.size(); }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }

    public interface AdapterOfListener {
        public void informePersonSelected(Person person);
    }

    public class ViewHolderPeople extends RecyclerView.ViewHolder{

        private ImageView imageViewPerson;
        private TextView textViewUserame;


        public ViewHolderPeople(@NonNull View itemView) {
            super(itemView);
            imageViewPerson = itemView.findViewById(R.id.cellPerson_imageView_Thumbnail);
            textViewUserame = itemView.findViewById(R.id.cellPerson_TextView_Username);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Person selectedPerson = personList.get(getAdapterPosition());
                    adapterOfListener.informePersonSelected(selectedPerson);
                }
            });
        }

        public void loadPerson(Person person) {

            Glide.with(imageViewPerson.getContext()).load(person.getPhoto().getThumbnail()).placeholder(R.drawable.ic_refresh_black_24dp).into(imageViewPerson);
            textViewUserame.setText("Username: " +person.getLogin().getUsername());

        }
    }
}
