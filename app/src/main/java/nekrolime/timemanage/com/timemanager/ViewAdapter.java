package nekrolime.timemanage.com.timemanager;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Cursor mCursor;

    public ViewAdapter(Cursor myCursor) {
        this.mCursor = myCursor;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view_row,parent,false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mCursor.moveToPosition(position);
        System.out.println("gg.com");
        mCursor.getString(0);

    }

    static class CustomViewHolder extends RecyclerView.ViewHolder{

        public CustomViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {return mCursor.getCount();}
}
