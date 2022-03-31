package com.example.codegreen.ui.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.codegreen.MainActivity;
import com.example.codegreen.R;
import com.example.codegreen.User;
//import com.example.codegreen.databinding.FragmentLeaderboardBinding;

public class UserAdaptor extends RecyclerView.Adapter<UserAdaptor.UserViewHolder> {
    private Context mCtx;

    //we are storing all the products in a list
    private List<User> userList;

    //getting the context and product list with constructor
    public UserAdaptor(Context mCtx, List<User> userList) {
        this.mCtx = mCtx;
        this.userList = userList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.leaderboard_layout, null);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        //getting the product of the specified position
        User user = userList.get(position);

        //binding the data with the viewholder views
        holder.textViewName.setText(user.getUsername());

        holder.textViewScore.setText(String.valueOf(user.getScore()));
        holder.textViewLocation.setText(String.valueOf(user.getLocation()));
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(user.getImage()));

    }


    @Override
    public int getItemCount() {
        return userList.size();
    }


    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName,textViewScore, textViewLocation;
        ImageView imageView;

        public UserViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            // textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewScore = itemView.findViewById(R.id.textViewScore);
           textViewLocation = itemView.findViewById(R.id.textViewLocation);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}









