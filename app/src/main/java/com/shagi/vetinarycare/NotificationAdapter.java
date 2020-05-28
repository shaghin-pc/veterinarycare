package com.shagi.vetinarycare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    List<NotificationConstructor> mylist;
    Context context;

    public NotificationAdapter(List<NotificationConstructor> mylist, Context mycontext) {
        this.context=mycontext;
        this.mylist=mylist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.MyViewHolder holder, int position) {

        NotificationConstructor notificationConstructor=mylist.get(position);

        holder.itemnameType.setText(notificationConstructor.getItemname());
        holder.banknameType.setText(notificationConstructor.getBankname());
        holder.branchType.setText(notificationConstructor.getBranch());
        holder.ifscType.setText(notificationConstructor.getIfsc());
        holder.accountnoType.setText(notificationConstructor.getAccountno());
        holder.annualincomeType.setText(notificationConstructor.getAnnualincome());
        holder.mainjobType.setText(notificationConstructor.getMainjob());
        holder.scstType.setText(notificationConstructor.getScst());
        holder.bplType.setText(notificationConstructor.getBpl());
        holder.womenType.setText(notificationConstructor.getWomen());
        holder.handcapType.setText(notificationConstructor.getHandcap());
        holder.girlType.setText(notificationConstructor.getGirl());
        holder.beforeType.setText(notificationConstructor.getBefore());


    }

    @Override
    public int getItemCount() { return mylist.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView  itemnameType,banknameType,branchType,ifscType,accountnoType,annualincomeType,mainjobType,scstType,bplType,womenType,handcapType,girlType,beforeType;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemnameType=itemView.findViewById(R.id.itemname_card);
            banknameType=itemView.findViewById(R.id.bankname_card);
            branchType=itemView.findViewById(R.id.branch_card);
            ifscType=itemView.findViewById(R.id.ifsc_card);
            accountnoType=itemView.findViewById(R.id.accountno_card);
            annualincomeType=itemView.findViewById(R.id.annualincome_card);
            mainjobType=itemView.findViewById(R.id.mainjob_card);
            scstType=itemView.findViewById(R.id.scst_card);
            bplType=itemView.findViewById(R.id.bpl_card);
            womenType=itemView.findViewById(R.id.women_card);
            handcapType=itemView.findViewById(R.id.handcap_card);
            girlType=itemView.findViewById(R.id.girl_card);
            beforeType=itemView.findViewById(R.id.before_card);
        }
    }
}
