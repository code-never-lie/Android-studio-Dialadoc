package com.android.dialadoc.Adapters;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.dialadoc.Activities.Appointment;
import com.android.dialadoc.Models.User;
import com.android.dialadoc.R;

import java.util.ArrayList;

public class DoctorListCustomAdapter extends RecyclerView.Adapter<DoctorListCustomAdapter.ViewHolder> {
    //declare variables and list
    private Context context;
    private ArrayList<User> doctorList;


    public DoctorListCustomAdapter(Context context, ArrayList<User> doctorList) {
        this.context = context;
        this.doctorList = doctorList;
    }

    @NonNull
    @Override
    public DoctorListCustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.patient_single_list_view_layout,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final DoctorListCustomAdapter.ViewHolder viewHolder, int i) {
        //setting variables to its positions
        viewHolder.doctorName.setText(doctorList.get(i).getName());
        viewHolder.doctorGender.setText(doctorList.get(i).getGender());
        //handle viewholder
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show message
                Toast.makeText(context,"Doctor "+viewHolder.getAdapterPosition(),Toast.LENGTH_SHORT).show();
                //change screen
                Intent intent=new Intent(context, Appointment.class);
                intent.putExtra("doctor",doctorList.get(viewHolder.getAdapterPosition()));
                context.startActivity(intent);

            }
        });
        // notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    //inherit class viewHolder with Recylerview
    class ViewHolder extends RecyclerView.ViewHolder{

        //Different Widgets
        TextView doctorName;
        TextView doctorGender;
        CardView layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //casting
            doctorName=itemView.findViewById(R.id.doc_name);
            doctorGender=itemView.findViewById(R.id.doc_gender);
            layout=itemView.findViewById(R.id.doc_single_layout);

        }
    }
}
