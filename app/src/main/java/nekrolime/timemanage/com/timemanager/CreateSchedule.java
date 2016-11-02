package nekrolime.timemanage.com.timemanager;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateSchedule extends AppCompatActivity implements Switch.OnCheckedChangeListener{
    private Toolbar toolbar;
    private Spinner spinner_nav;
    private Switch aswitch;
    private Button create_event;
    private EditText editText;
    private ExpandableListView expandableListView;
    private ExpandableListAdapter ela;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dailyscheduler);
        toolbar = (Toolbar) findViewById(R.id.dailyscheduler_tool_bar);
        setSupportActionBar(toolbar);
        spinner_nav = (Spinner) findViewById(R.id.spinner);
        addItemsToSpinner();
    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        create_event = (Button) findViewById(R.id.new_event);
        create_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                                LinearLayout layout = (LinearLayout)findViewById(R.id.linear_layout);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        android.widget.LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                expandableListView = new ExpandableListView(getBaseContext());
                expandableListView.setId(R.id.edit_text);
                expandableListView.setLayoutParams(params);
                expandableListView.setAdapter(ela);
                expandableListView.setVerticalScrollBarEnabled(true);
                expandableListView.setScrollbarFadingEnabled(false);


                layout.addView(expandableListView);

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        // Inflate menu to add items to action bar if it is present.
        inflater.inflate(R.menu.scheduler_menu, menu);
        return true;}
    public boolean onOptionItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()){

            case(android.R.id.home):
            NavUtils.navigateUpFromSameTask(this);

                return true;

    }
        aswitch = (Switch) findViewById(R.id.menu_switch);
        aswitch.setOnCheckedChangeListener(this);

        return super.onOptionsItemSelected(item);
    }







    public void addItemsToSpinner() {

        ArrayList<String> list = new ArrayList<String>();
        list.add(" Daily Schedule");
        list.add(" Weekly Schedule");

        // Custom ArrayAdapter with spinner item layout to set popup background

        CustomSpinnerAdapter spinAdapter = new CustomSpinnerAdapter(
                getApplicationContext(), list);



        // Default ArrayAdapter with default spinner item layout, getting some
        // view rendering problem in lollypop device, need to test in other
        // devices

  /*
   * ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this,
   * android.R.layout.simple_spinner_item, list);
   * spinAdapter.setDropDownViewResource
   * (android.R.layout.simple_spinner_dropdown_item);
   */

        spinner_nav.setAdapter(spinAdapter);

        spinner_nav.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String item = adapter.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(getApplicationContext(), "Selected  : " + item,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b){
            Toast.makeText(getApplicationContext(), "Enabled",
                    Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Disabled",
                    Toast.LENGTH_LONG).show();

        }
    }



    }


















