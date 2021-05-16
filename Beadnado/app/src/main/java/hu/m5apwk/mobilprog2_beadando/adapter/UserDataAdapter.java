package hu.m5apwk.mobilprog2_beadando.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.List;

import hu.m5apwk.mobilprog2_beadando.R;
import hu.m5apwk.mobilprog2_beadando.viewmodel.UserDataViewModel;

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.UserDataViewHolder> {

    List<UserDataViewModel> userDataViewModelsList;
    Context context;

    public UserDataAdapter(List<UserDataViewModel> userDataViewModelsList, Context context) {
        this.userDataViewModelsList = userDataViewModelsList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public UserDataViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_line_data,parent,false);
        UserDataViewHolder holder = new UserDataViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UserDataViewHolder holder, int position) {
        holder.id.setText((CharSequence) userDataViewModelsList.get(position).getId());
        holder.name.setText((CharSequence) userDataViewModelsList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return userDataViewModelsList.size();
    }

    public class UserDataViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView name;

        public UserDataViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tv_id);
            name = itemView.findViewById(R.id.tv_name);
        }
    }
}
