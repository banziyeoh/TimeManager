package nekrolime.timemanage.com.timemanager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import nekrolime.timemanage.com.timemanager.Database.SqlHelper;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SqlHelper sqlHelper;


    private static final String TAG_CREATE_TDL= "CreateTDL";
    private static final String TAG_CREATE_TIMELINE = "CreateTimeLine";
    public static final String Task = "taskKey";
    private Toolbar toolbar;
    private TabLayout tabs;
    private ViewPager viewpager;
    private PagerAdapter adapter;
    private Cursor res;
    String task;


    CharSequence Titles[]={"Task","Schedule"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_appbar);
        setupFAB();
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
        getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp((DrawerLayout)findViewById(R.id.drawer_layout), toolbar);
        sqlHelper = new SqlHelper(this);




        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Task"));
        tabs.addTab(tabs.newTab().setText("Scheduler"));
        viewpager = (ViewPager) findViewById(R.id.pager);
        bindViewPagerWIthTabLayout();



        res = sqlHelper.getAllData();
        adapter = new PagerAdapter(getSupportFragmentManager(),this);



        viewpager.setAdapter(adapter);
    }






    private void setupFAB() {
        //define the icon for the main floating action button
        ImageView iconFAB = new ImageView(this);
        iconFAB.setImageResource(R.drawable.ic_add);

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(iconFAB)
                .setBackgroundDrawable(R.color.selector_button)
                .build();
        //define the icons for the sub action buttons
        ImageView iconCreateTimeline = new ImageView(this);
        iconCreateTimeline.setImageResource(R.drawable.ic_schedule);
        ImageView iconCreateTDL = new ImageView(this);
        iconCreateTDL.setImageResource(R.drawable.ic_toc);
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        SubActionButton buttonCreateTimeline = itemBuilder.setContentView(iconCreateTimeline).build();
        SubActionButton buttonCreateTDL = itemBuilder.setContentView(iconCreateTDL).build();
        buttonCreateTDL.setTag(TAG_CREATE_TDL);
        buttonCreateTimeline.setTag(TAG_CREATE_TIMELINE);
        buttonCreateTimeline.setOnClickListener(this);
        buttonCreateTDL.setOnClickListener(this);
        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(buttonCreateTimeline)
                .addSubActionView(buttonCreateTDL)
                .attachTo(actionButton)
                .build();
    }

        public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
            MenuInflater inflater = getMenuInflater();
            // Inflate menu to add items to action bar if it is present.
            inflater.inflate(R.menu.menu, menu);
            // Associate searchable configuration with the SearchView
            MenuItem searchItem = menu.findItem(R.id.action_search);
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    // perform query here
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
            return super.onCreateOptionsMenu(menu);

    }
    private static long back_pressed;
    @Override
    public void onBackPressed(){
        if (back_pressed + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
        }
        else{
            Toast.makeText(getBaseContext(), "Press again to exit", Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getTag().equals(TAG_CREATE_TDL)){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Add a task");
            builder.setMessage("What do you want to do?");
            final EditText inputField = new EditText(this);
            builder.setView(inputField);
            builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    boolean isInserted = sqlHelper.insertData(inputField.getText().toString());
                    if (isInserted =true) {
                        res = sqlHelper.getAllData();
                        Toast.makeText(MainActivity.this, "Task Created Sucessfully :D", Toast.LENGTH_LONG).show();
                        adapter.notifyDataSetChanged();
                        //RUN THE CODE
                    }else
                        Toast.makeText(MainActivity.this,"Task Created Unsucessfully :(",Toast.LENGTH_LONG).show();



                }

            });
            builder.setNegativeButton("Cancel", null);
            builder.create().show();}

        if(v.getTag().equals(TAG_CREATE_TIMELINE)){
            Intent intent = new Intent();
            intent.setClassName(this, "nekrolime.timemanage.com.timemanager.CreateSchedule");
            startActivity(intent);



        }
        }

    private void bindViewPagerWIthTabLayout(){
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                tabs.getTabAt(position).select();
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


}





