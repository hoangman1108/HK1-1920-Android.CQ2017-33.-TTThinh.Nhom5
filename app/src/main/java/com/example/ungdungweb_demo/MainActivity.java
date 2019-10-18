package com.example.ungdungweb_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    Button btnmain;
    Intent intent;

    ImageButton imgbtnmaps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //trang dể kết hiển thị các trang khác
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigationview);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

       // imgbtnmaps = (ImageButton) findViewById(R.id.btnDiaChi);

        Fragment fragmentfirst = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragmentfirst).show(fragmentfirst).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment select = null;
                    switch (menuItem.getItemId())
                    {
                        case R.id.itemHomeMain:
                            select = new HomeFragment();
                            break;
                        case R.id.itemHomeMenu:
                            select = new MenuMonFragment();
                            break;
                        case R.id.itemMap:
//                          select = new MapsFragment();
                            intent = new Intent(MainActivity.this, Maps.class);
            //               Toast.makeText(mainActivity, "ra nào", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + menuItem.getItemId());
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, select).commit();

                    return true;
                }
            };


    public void Show() {
        HomeFragment homeFragment = (HomeFragment) this.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    }
}

