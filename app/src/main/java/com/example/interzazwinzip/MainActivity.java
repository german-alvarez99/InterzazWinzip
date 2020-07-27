package com.example.interzazwinzip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SD Card");

        //agregar toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        //colocar botom de HOME
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //agregar el navegatin View
        navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

        //colocar fragment qal cargar activity
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new fragmentStorage())
                .commit();

        //cambiar colo de determinadas opciones en el navigation
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();

        MenuItem tools= menu.findItem(R.id.menu_Settings);
        SpannableString s = new SpannableString(tools.getTitle());
        s.setSpan(new TextAppearanceSpan(this, R.style.StyleCambiarColorTextoMenu), 0, s.length(), 0);
        tools.setTitle(s);

        tools= menu.findItem(R.id.menu_places);
        s = new SpannableString(tools.getTitle());
        s.setSpan(new TextAppearanceSpan(this, R.style.StyleCambiarColorTextoMenu), 0, s.length(), 0);
        tools.setTitle(s);

        tools= menu.findItem(R.id.menu_NetworkAndCloud);
        s = new SpannableString(tools.getTitle());
        s.setSpan(new TextAppearanceSpan(this, R.style.StyleCambiarColorTextoMenu), 0, s.length(), 0);
        tools.setTitle(s);

        tools= menu.findItem(R.id.menu_Tool);
        s = new SpannableString(tools.getTitle());
        s.setSpan(new TextAppearanceSpan(this, R.style.StyleCambiarColorTextoMenu), 0, s.length(), 0);
        tools.setTitle(s);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        boolean fragmentTransaction = false;

        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.menu_recent:
                fragment = new fragmentRecent();
                fragmentTransaction = true;
                break;
            case R.id.menu_Favorities:
                fragment = new fragmentFavorities();
                fragmentTransaction = true;
                break;
            case R.id.menu_MyFiles:
                fragment = new fragmentFiles();
                fragmentTransaction = true;
                break;
            case R.id.menu_Storage:
                fragment = new fragmentStorage();
                fragmentTransaction = true;
                break;
            case R.id.menu_Photos:
                fragment = new fragmentPhotos();
                fragmentTransaction = true;
                break;
            case R.id.menu_Music:
                fragment = new fragmentMusic();
                fragmentTransaction = true;
                break;
            case R.id.menu_Network:
                fragment = new fragmentNetwork();
                fragmentTransaction = true;
                break;
            case R.id.menu_Dropbox:
                fragment = new fragmentDropbox();
                fragmentTransaction = true;
                break;
            case R.id.menu_GoogleDrive:
                fragment = new fragmentGoogleDrive();
                fragmentTransaction = true;
                break;
            case R.id.menu_CleanPhoto:
                fragment = new fragmentCleanPhoto();
                fragmentTransaction = true;
                break;
            case R.id.menu_AccesFromPc:
                fragment = new fragmentAccessPc();
                fragmentTransaction = true;
                break;
            case R.id.menu_Purchase:
                fragment = new fragmentPurchase();
                fragmentTransaction = true;
                break;
            case R.id.menu_Setting:
                fragment = new fragmentSetting();
                fragmentTransaction = true;
                break;
            case R.id.menu_Exit:
                finish();
                break;
        }

        if (fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();

            menuItem.setChecked(true);
            getSupportActionBar().setTitle(menuItem.getTitle());
        }
        drawerLayout.closeDrawers();
        return true;
    }
}