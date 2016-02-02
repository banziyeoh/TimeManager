package nekrolime.timemanage.com.timemanager;

import java.util.List;

/**
 * Created by Yeoh on 24/10/2015.
 */
public class PreferenceActivity extends android.preference.PreferenceActivity{
    @Override
    public void onBuildHeaders(List<android.preference.PreferenceActivity.Header> target)
    {
        loadHeadersFromResource(R.xml.headers_preference, target);
    }


}









