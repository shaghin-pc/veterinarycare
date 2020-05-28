package com.shagi.vetinarycare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.ComplaintViewHolder> {

    List<ComplaintConstrructor> complaintList;
    Context context;

    public ComplaintAdapter(List<ComplaintConstrructor> my_list, Context applicationContext) {
        this.context=applicationContext;
        this.complaintList=my_list;
    }

    @NonNull
    @Override
    public ComplaintAdapter.ComplaintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.complaintcard,parent,false);

        return new ComplaintViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComplaintAdapter.ComplaintViewHolder holder, int position) {

        ComplaintConstrructor ComplaintConstructor=complaintList.get(position);
        holder.txtComplaint.setText(ComplaintConstructor.getComplaint());



    }

    @Override
    public int getItemCount() {
        return complaintList.size();
    }

    public class ComplaintViewHolder extends RecyclerView.ViewHolder{

        TextView txtComplaint;

        public ComplaintViewHolder(@NonNull View itemView) {
            super(itemView);

            txtComplaint=itemView.findViewById(R.id.complaint_card);
        }
    }
}
