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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    Button btnmain;
    Fragment select = null;
    NavigationView navigationView;
    Intent intent;
    Menu menu1;

    ImageButton imgbtnmaps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //trang dể kết hiển thị các trang khác
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigationview);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);


        navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

       // imgbtnmaps = (ImageButton) findViewById(R.id.btnDiaChi);

//        Intent intent1 = getIntent();
//        Bundle bundle1 = intent1.getBundleExtra("info1");
//       if(!bundle1.isEmpty()){
//           String name1 = bundle1.getString("name");
//           menu1 = navigationView.getMenu();
////        menu1.findItem(R.id.itemName).setTitle(bundle1.getString("name"));
//           menu1.findItem(R.id.itemName).setTitle(name1);
//       }

        Menu menu1 = navigationView.getMenu();
        LayoutInflater factory = getLayoutInflater();
        View regisText = factory.inflate(R.layout.activity_detail__info, null);
        TextView name1 = (TextView) regisText.findViewById(R.id.detail_name);
        String usr = name1.getText().toString();
        menu1.findItem(R.id.itemName).setTitle(usr);


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
//                Menu menu=navigationView.getMenu();
//                String name=(String)menu.findItem(R.id.itemName).getTitle();
//                String phone=(String)menu.findItem(R.id.itemSdt).getTitle();
//                String email=(String)menu.findItem(R.id.itemEmail).getTitle();
                Intent intent=new Intent(this, Detail_Info.class);
//                Bundle bundle=new Bundle();
//                bundle.putString("name",name);
//                bundle.putString("phone",phone);
//                bundle.putString("email",email);
//                intent.putExtra("infor",bundle);
                startActivity(intent);


                break;
            case R.id.itemHelp:
                default:
                    Toast.makeText(this, "Not found", Toast.LENGTH_SHORT).show();

        }

        return true;
    }
}

