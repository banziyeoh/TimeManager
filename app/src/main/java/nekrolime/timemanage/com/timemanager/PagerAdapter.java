package nekrolime.timemanage.com.timemanager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private Context context;
    private FragmentPage fragment1;
    private SchedulerFragment fragment2;


    public PagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context = context;

    }


    public Fragment getItem(int position) {
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


    @Override
    public int getItemPosition(Object object) {
        // Causes adapter to reload all Fragments when
        // notifyDataSetChanged is called
        return POSITION_NONE;
    }


}
