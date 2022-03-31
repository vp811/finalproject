package com.example.codegreen.ui.userprofile;

/**
 * Adapted from the ProductAdaptor created by karanjaswani on 1/12/18 from Assignment 3.
 */
import android.content.Context;

import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;
import com.example.codegreen.R;
import com.example.codegreen.User;

public class MilestoneAdaptor extends RecyclerView.Adapter<MilestoneAdaptor.MilestoneViewHolder> {

    private Context mCtx;
    private List<Milestone> milestones;
    private User user;
    public MilestoneAdaptor(Context mCtx, List<Milestone> milestones, User user) {
        this.mCtx = mCtx;
        this.milestones = milestones;
        this.user = user;
    }

    @Override
    public MilestoneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.milestones_layout, null);
        return new MilestoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MilestoneViewHolder holder, int position) {
        //getting the product of the specified position
        Milestone milestone = milestones.get(position);

        //binding the data with the viewholder views
        holder.textViewName.setText(milestone.getName());
        holder.textViewDescription.setText(milestone.getDescription());
        holder.imageView.setImageDrawable(ResourcesCompat.getDrawable(mCtx.getResources(), milestone.getImage(), mCtx.getTheme()));
        holder.setMilestone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add confirmation later.
                user.setFavoriteMilestone(milestone);
            }
        });

    }


    @Override
    public int getItemCount() {
        return milestones.size();
    }


    class MilestoneViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewDescription;
        ImageView imageView;
        Button setMilestone;

        public MilestoneViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            imageView = itemView.findViewById(R.id.viewMilestoneOne);
            setMilestone = itemView.findViewById(R.id.setMilestoneButton);
        }
    }
}
