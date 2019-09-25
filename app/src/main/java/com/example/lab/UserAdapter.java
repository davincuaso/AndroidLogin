package com.example.lab;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;

public class UserAdapter extends RealmRecyclerViewAdapter<User, UserAdapter.MyViewHolder>  {
    UserList context;
    public UserAdapter(UserList context, @Nullable RealmResults<User> data)
    {
        super(data, true); // autoupdate true
     this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // create row view / viewHolder
        // only a limited number will be created
        View view = context.getLayoutInflater().inflate(R.layout.activity_row_user, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        // copy from the result object to the viewHolder for display
        User user = getItem(position);

        // fill in the ViewHolder
        // non-strings need to be converted to String via String.valueOf()
        holder.username.setText(user.getUsername());
        holder.email.setText(user.getEmail());
        holder.password.setText(user.getPassword());

        holder.delete.setTag(user);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView email;
        TextView username;
        TextView password;
        Button delete;

        public MyViewHolder(View itemView)
        {
            super(itemView);

            email = itemView.findViewById(R.id.textView6);
            username = itemView.findViewById(R.id.textView7);
            password = itemView.findViewById(R.id.textView8);
            delete = itemView.findViewById(R.id.delete);

            delete.setOnClickListener(deleteListener);
        }
    }
    private View.OnClickListener deleteListener = new View.OnClickListener(){
        @Override
        public void onClick(View v)
        {
//            Tag is attaching arbitrary object to an existing object
            User user = (User) v.getTag();
//            System.out.println(u);
            context.delete(user);
        }
    };
}
