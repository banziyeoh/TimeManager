package nekrolime.timemanage.com.timemanager;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import nekrolime.timemanage.com.timemanager.Database.SqlHelper;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private Context context;
    private FragmentPage fragment1;
    private SchedulerFragment fragment2;

    public PagerAdapter(FragmentManager fm) {
        super(fm);

    }


    public Fragment getItem(int position, SqlHelper sqlHelper) {
        if(position == 0) {
            fragment1 = FragmentPage.newInstance(position,context);
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
