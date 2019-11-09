package com.example.ungdungweb_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static ArrayList<GioHang> gioHangArrayList = new ArrayList<>();

    public static ArrayList<UserInfor> userInforArrayList = new ArrayList<>();

    public static int index=-1;


    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    Button btnmain;
    Fragment select = null;
    public static NavigationView navigationView ;
    Intent intent;
    public static Menu menu1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (index == -1) {
            Intent intentA = new Intent(this, LoginActivity.class);
            startActivity(intentA);
            finish();
        }

        //trang dể kết hiển thị các trang khác
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigationview);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);


        navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        menu1=navigationView.getMenu();
        if(index!=-1) {
            menu1.findItem(R.id.itemName).setTitle(userInforArrayList.get(index).getName());
            menu1.findItem(R.id.itemSdt).setTitle(userInforArrayList.get(index).getPhone());
            menu1.findItem(R.id.itemEmail).setTitle(userInforArrayList.get(index).getEmail());
        }


        Fragment fragmentfirst = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragmentfirst).show(fragmentfirst).commit();

    }


    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId())
                    {
                        case R.id.itemHomeMain:
                            select = new HomeFragment();
                            break;
                        case R.id.itemHomeMenu:
                            select = new MenuMonFragment();
                            break;
                        case R.id.itemMap:
                            select = new BlankFragment();
                            break;
                        case R.id.itemGioHang:
                            select = new GioHangFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, select).commit();

                    return true;
                }
            };

    public void Show() {
        HomeFragment homeFragment = (HomeFragment) this.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.itemInfor:

                Intent intent=new Intent(this, Detail_Info.class);
                startActivity(intent);
                finish();
                break;
            case R.id.itemHelp:
                Intent intent1=new Intent(this,HelpActivity.class);
                startActivity(intent1);
                break;
            case R.id.itemLogout:
                index=-1;
                Intent intent2=new Intent(this,LoginActivity.class);
                startActivity(intent2);
                finish();
                break;

        }

        return true;
    }
}

