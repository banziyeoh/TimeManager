package nekrolime.timemanage.com.timemanager;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private Cursor cursor;
    private FragmentPage fragment;

    public PagerAdapter(FragmentManager fm,Cursor cursor) {
        super(fm);
        this.cursor = cursor;
    }

    @Override
    public Fragment getItem(int position) {
        fragment = FragmentPage.newInstance(position,cursor);
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    public void notifyNewDataChanged(){;
        if(fragment!=null){
            fragment.notifyNewData();
            this.notifyDataSetChanged();
        }

    }
}