package nekrolime.timemanage.com.timemanager;

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

public class FragmentPage extends Fragment {
    private int value;
    private RecyclerView recyclerView;
    private Cursor cursor;
    private  ViewAdapter adapter;

    public static FragmentPage newInstance(int value ,Cursor cursor){

        FragmentPage frag = new FragmentPage();
        frag.value = value;
        frag.cursor= cursor;
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
        adapter = new ViewAdapter(cursor);
        recyclerView.setAdapter(adapter);


        return view;
    }

    public void notifyNewData(Cursor res){
        adapter = new ViewAdapter(res);
        recyclerView.setAdapter(adapter);
    }
    }

