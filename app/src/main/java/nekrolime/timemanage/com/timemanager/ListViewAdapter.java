package nekrolime.timemanage.com.timemanager;


import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;

public class ListViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    private EditText header_edit;
    private Layout child_item;
    ListViewAdapter(Context context,EditText header_edit,Layout child_item){
        this.context = context;
        this.header_edit=header_edit;
        this.child_item=child_item;
    }

    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService
            (Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.parent_layout, parent, false);
        }
        return v;
    }

    @Override

    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
            (Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.new_daily_event, parent, false);
        }
        return v;
    }


    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
