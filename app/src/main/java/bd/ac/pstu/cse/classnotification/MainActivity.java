package bd.ac.pstu.cse.classnotification;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
//Button confirmBtn;
//Switch switch8_9,switch9_10,switch10_11,switch11_12,switch12_1,switch2_5;
//DatabaseReference databaseReference;
//    final HashMap<String, String> classData=new HashMap<String, String>();
//TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //for select of my fragment at oprning
        if(savedInstanceState==null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main1 , new showClass());
            ft.commit();
            navigationView.setCheckedItem(R.id.nav_ShowClasses);
        }









    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            myreference.setMyReference("","",this);
            Fragment fragment = null;
            fragment=new login1();
            if (fragment != null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main1 ,fragment);
                ft.commit();
            }
            return true;
        } if (id == R.id.action_notification) {
            Intent i=new Intent(this,MyService.class);
            Toast.makeText(getApplicationContext(),"Start background notification",Toast.LENGTH_LONG).show();
            startService(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void set_fragment(int id) {
        Fragment fragment = null;
        switch (id) {
            case R.id.nav_ShowClasses:
                fragment = new showClass();
                break;
            case R.id.nav_setClass:
//               Intent intent=new Intent(MainActivity.this,login.class);
//               startActivity(intent);
                fragment=new login1();
                break;

            case R.id.nav_notice:
                fragment = new Notice();
                break;

            case R.id.nav_web:
                Intent web=new Intent(Intent.ACTION_VIEW,Uri.parse("https://cse.pstu.ac.bd"));
                startActivity(web);
                break;

            case R.id.nav_facebook:
                Intent facebook=new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.facebook.com/pstucse"));
                startActivity(facebook);
                break;


        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main1 ,fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
        set_fragment(id);
        return true;
    }

//    //necessary method (yser defined)
//    private void changeClassStates(){
//        String state="off";
//        classData.put("8-9", state);
//        classData.put("9-10", state);
//        classData.put("10-11", state);
//        classData.put("11-12", state);
//        classData.put("12-1", state);
//        classData.put("2-5", state);
//
//    }

}
