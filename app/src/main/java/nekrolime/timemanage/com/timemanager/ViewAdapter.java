package nekrolime.timemanage.com.timemanager;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;


public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.CustomViewHolder> {

    private List<NatureItem> mainInfo;





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
        holder.button.setImageResource(mainInfo.get(position).getThumbnail());

    }

    static class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView task;
        ImageButton button;
        

        public CustomViewHolder(View itemView) {
            super(itemView);
            task= (TextView) itemView.findViewById(R.id.text);
            button = (ImageButton) itemView.findViewById(R.id.img_thumbnail);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.d("test","button clicked");







                }
            });
        }
    }

    @Override
    public int getItemCount() {return mainInfo.size();}
}
