package com.shagi.vetinarycare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.MyViewHolder> {
    List<PetConstructor>my_list;
    Context context;




    public PetAdapter(List<PetConstructor> my_list, Context applicationContext) {
        this.context=applicationContext;
        this.my_list=my_list;

    }

    @NonNull
    @Override
    public PetAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.petcard,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetAdapter.MyViewHolder holder, int position) {

        final PetConstructor petConstructor=my_list.get(position);

        holder.txtType.setText(petConstructor.getType());
        holder.txtAge.setText(petConstructor.getAge());
        holder.txtColor.setText(petConstructor.getColor());
        holder.txtSex.setText(petConstructor.getSex());
        holder.txtId.setText(petConstructor.getIdentifyMark());

    }

    @Override
    public int getItemCount() {
        return  my_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtType,txtAge,txtColor,txtSex,txtId;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtType=itemView.findViewById(R.id.typ_card);
            txtAge=itemView.findViewById(R.id.age_card);
            txtColor=itemView.findViewById(R.id.color_card);
            txtSex=itemView.findViewById(R.id.sex_card);
            txtId=itemView.findViewById(R.id.id_card);
        }
    }
}
