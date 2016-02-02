package nekrolime.timemanage.com.timemanager;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferenceFragment extends PreferenceActivity {
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

        }

    }
