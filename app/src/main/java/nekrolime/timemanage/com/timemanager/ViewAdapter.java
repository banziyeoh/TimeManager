package nekrolime.timemanage.com.timemanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import nekrolime.timemanage.com.timemanager.Database.SqlHelper;


public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.CustomViewHolder> {

    private List<NatureItem> mainInfo;
    SqlHelper sqlHelper;


    public ViewAdapter(List<NatureItem> mainInfo) {
        this.mainInfo = mainInfo;
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view_row,parent,false);
        CustomViewHolder holder = new CustomViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        holder.task.setText(mainInfo.get(position).getName());
        holder.icon.setImageResource(mainInfo.get(position).getThumbnail());

    }

    static class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView task;
        ImageView icon;

        public CustomViewHolder(View itemView) {
            super(itemView);
            task= (TextView) itemView.findViewById(R.id.text);
            icon = (ImageView) itemView.findViewById(R.id.img_thumbnail);
        }
    }

    @Override
    public int getItemCount() {return mainInfo.size();}
}
