package nekrolime.timemanage.com.timemanager;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private Cursor cursor;
    private FragmentPage fragment1;
    private SchedulerFragment fragment2;

    public PagerAdapter(FragmentManager fm,Cursor cursor) {
        super(fm);
        this.cursor = cursor;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            fragment1 = FragmentPage.newInstance(position, cursor);
            return fragment1;
        }else{
            return new SchedulerFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public void notifyNewDataChanged(Cursor res){;
        if(fragment1!=null){

        }


    }
}
