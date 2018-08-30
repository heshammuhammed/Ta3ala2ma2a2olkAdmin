package com.example.heshammuhammed.ta3ala2ma2a2olkadmin;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import AddCustomer.MVP.AddCustomerFragment;
import AdminReports.MVP.*;
import AdminCategories.MVP.CategoriesFragment;
import AdminCustomerService.MVP.CustomerServiceFragment;
import AdminPlaces.MVP.PlacesFragment;
import AdminUsers.MVP.UsersFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    private static Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.context = getApplicationContext();

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        HomeFragment home = new HomeFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentswitcher, home).addToBackStack("tag");
        ;
        fragmentTransaction.commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        fragmentTransaction = fragmentManager.beginTransaction();
        if (id == R.id.users) {
                fragmentTransaction  = fragmentManager.beginTransaction();
            UsersFragment usersFragment = new UsersFragment();
            Bundle bundle = new Bundle();
            bundle.putString("KEY", "1");
            usersFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.fragmentswitcher, usersFragment).addToBackStack("tag");
             //    fragmentTransaction.commit();
        } else if (id == R.id.reports) {
             //     fragmentTransaction  = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentswitcher, new ReportsFragment()).addToBackStack("tag");
             //  fragmentTransaction.commit();
        } else if (id == R.id.categories) {
            //    fragmentTransaction  = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentswitcher, new CategoriesFragment()).addToBackStack("tag");
            //    fragmentTransaction.commit();
        } else if (id == R.id.customerservices) {
            //    fragmentTransaction  = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentswitcher, new CustomerServiceFragment()).addToBackStack("tag");
            //      fragmentTransaction.commit();
        } else if (id == R.id.places) {
            //     fragmentTransaction  = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentswitcher, new PlacesFragment()).addToBackStack("tag");
             //      fragmentTransaction.commit();
        } else if (id == R.id.newcustomerservice) {
           //   fragmentTransaction  = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentswitcher, new AddCustomerFragment()).addToBackStack("tag");
         //      fragmentTransaction.commit();
        } else if (id == R.id.allcustomerservices) {
            UsersFragment usersFragment = new UsersFragment();
            Bundle bundle = new Bundle();
            bundle.putString("KEY", "2");
            usersFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.fragmentswitcher, usersFragment).addToBackStack("tag");
        }

      fragmentTransaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public static Context getAppContext() {
        return MainActivity.context;
    }
}