package com.shagi.vetinarycare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    List<UserViewConstructor> user_list;
    Context context;

    public UserAdapter(List<UserViewConstructor> my_list, Context applicationContext) {
        this.context=applicationContext;
        this.user_list=my_list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.usercard,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        UserViewConstructor userConstructor=user_list.get(position);

        holder.txtName.setText(userConstructor.getName());
        holder.txtAddress.setText(userConstructor.getAddress());
        holder.txtDistrict.setText(userConstructor.getDistrict());
        holder.txtTaluk.setText(userConstructor.getTaluk());
        holder.txtPanchayath.setText(userConstructor.getPanchayath());
        holder.txtWard.setText(userConstructor.getWard_no());
        holder.txtHouse.setText(userConstructor.getHouse_no());
        holder.txtRation.setText(userConstructor.getRationcard_no());
        holder.txtAdhaar.setText(userConstructor.getAdhaar_no());
        holder.txtEmail.setText(userConstructor.getEmail());
        holder.txtPhone.setText(userConstructor.getPhone_no());


    }

    @Override
    public int getItemCount() {
        return user_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName,txtAddress,txtDistrict,txtTaluk,txtPanchayath,txtWard,txtHouse,txtRation,txtAdhaar,txtEmail,txtPhone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName=itemView.findViewById(R.id.name_card);
            txtAddress=itemView.findViewById(R.id.address_card);
            txtDistrict=itemView.findViewById(R.id.dist_card);
            txtTaluk=itemView.findViewById(R.id.talu_card);
            txtPanchayath=itemView.findViewById(R.id.panch_card);
            txtWard=itemView.findViewById(R.id.ward_card);
            txtHouse=itemView.findViewById(R.id.house_card);
            txtRation=itemView.findViewById(R.id.ration_card);
            txtAdhaar=itemView.findViewById(R.id.adhaar_card);
            txtEmail=itemView.findViewById(R.id.mail_card);
            txtPhone=itemView.findViewById(R.id.phone_card);

        }
    }
}
