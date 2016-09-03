package nekrolime.timemanage.com.timemanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import nekrolime.timemanage.com.timemanager.Database.SqlHelper;


public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.CustomViewHolder>{

    private List<NatureItem> mainInfo;
    Context ctx;
    FragmentManager fm;









    public ViewAdapter(List<NatureItem> mainInfo, Context ctx, FragmentManager fm) {
        this.mainInfo = mainInfo;
        this.ctx = ctx;
        this.fm = fm;



    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view_row,parent,false);
        CustomViewHolder holder = new CustomViewHolder(v);


        return holder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {
        holder.task.setText(mainInfo.get(position).getName());
        holder.button.setImageResource(mainInfo.get(position).getThumbnail());


    }

      class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView task;
        ImageButton button;


          public CustomViewHolder(final View itemView) {
            super(itemView);
            task= (TextView) itemView.findViewById(R.id.text);
            button = (ImageButton) itemView.findViewById(R.id.img_thumbnail);
              button.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      View parent = (View) view.getParent();
                      TextView task = (TextView) parent.findViewById(R.id.text);
                      String taskt= String.valueOf(task.getText());
                      SqlHelper sq = new SqlHelper(ctx);
                      SQLiteDatabase sbl = sq.getReadableDatabase();
                      sbl.delete(SqlHelper.TABLE_NAME,
                              SqlHelper.TASK + " = ?",
                              new String[]{taskt});
                      sbl.close();
                      PagerAdapter pg = new PagerAdapter(fm,ctx);
                      pg.notifyDataSetChanged();





                  }
              });

            }
        }


    @Override
    public int getItemCount() {return mainInfo.size();}


}
