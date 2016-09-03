package nekrolime.timemanage.com.timemanager;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import nekrolime.timemanage.com.timemanager.Database.SqlHelper;

public class FragmentPage extends Fragment {
    private int value;
    private RecyclerView recyclerView;
    private  ViewAdapter adapter;
    public  SqlHelper sqlHelper;
    String task;

    public static FragmentPage newInstance(int value , Context context){

        FragmentPage frag = new FragmentPage();
        frag.value = value;
        frag.sqlHelper= new SqlHelper(context);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_layout,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getActivity()).build());
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        adapter = new ViewAdapter(getData(),getContext(),getFragmentManager());
        recyclerView.setAdapter(adapter);






        return view;}
    public List<NatureItem> getData() {
        List<NatureItem> data = new ArrayList<>();
        NatureItem mainInfo = null;
        Cursor c = sqlHelper.gettaskdata();
        if (c != null) {
            while (c.moveToNext()) {
                int nameIndex = c.getColumnIndex(sqlHelper.TASK);
                String nameText = c.getString(nameIndex);
                this.task = nameText;

                mainInfo = new NatureItem();
                mainInfo.setName(nameText);

                mainInfo.setThumbnail(R.drawable.ic_check);
                data.add(mainInfo);

            }
        }

        return data;
    }


}




