package MyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myroom.R;

import java.util.ArrayList;
import java.util.List;

import Pojo.Model;

public class MyAdaptUser extends RecyclerView.Adapter<MyAdaptUser.ViewHolder> {
    private List<Model> modelArrayList = new ArrayList<>();
    Context context;

    public MyAdaptUser() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_user.setText(modelArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public void setList(List<Model> models) {
        this.modelArrayList = models;
        notifyDataSetChanged();
    }

    public Model getuserAt(int position){
        return modelArrayList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_user;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_user = itemView.findViewById(R.id.tv_name);
        }
    }
}
