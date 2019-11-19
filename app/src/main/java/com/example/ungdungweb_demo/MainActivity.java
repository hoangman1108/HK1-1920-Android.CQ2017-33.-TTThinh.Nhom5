package com.example.ungdungweb_demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static ArrayList<GioHang> gioHangArrayList = new ArrayList<>();

    public static ArrayList<UserInfor> userInforArrayList = new ArrayList<>();

    public static  ArrayList<MonNuoc> monNuocArrayList = new ArrayList<>();

    public static ArrayList<RequestXacnhan> requestXacnhanArrayList = new ArrayList<>();

    public static ArrayList<String> keyRequest = new ArrayList<>();

    public static ArrayList<String> keygiohang = new ArrayList<>();

    public static int index=-1;

    public static DatabaseReference mData =FirebaseDatabase.getInstance().getReference();
    public static FirebaseStorage storage = FirebaseStorage.getInstance();

    public static StorageReference storageRef = storage.getReferenceFromUrl("gs://database-projectandroid.appspot.com");

    public static ArrayList<String> keyUser = new ArrayList<>();

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

//        mData = FirebaseDatabase.getInstance().getReference();

//       mData.child("UserInfor").push().setValue(oject)

        if (index == -1) {
            DataBase();
            LoadDataNuoc();
            LoadKeyGioHang();

            Intent intentA = new Intent(this, LoginActivity.class);
            startActivity(intentA);
            finish();
        }

//

//        Intent intentacept = getIntent();
//        index = intent.getIntExtra("key",0);


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
                Intent intent1=new Intent(this, HelpActivity.class);
                startActivity(intent1);
                break;
            case R.id.itemLogout:
                index=-1;
                Intent intent2=new Intent(this,LoginActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.itemHistory:
               Intent intent3 = new Intent(this, HistoryActivity.class);
               startActivity(intent3);
                break;
            case R.id.itemChangepass:
                startActivity(new Intent(this, ChangePassword.class));
                break;

        }

        return true;
    }

    public static void DataBase(){
//        for(int i = 0;i<userInforArrayList.size();i++){
//            mData.child("UserInfor").push().setValue(userInforArrayList.get(i));
//        }
        userInforArrayList.clear();
        monNuocArrayList.clear();
        requestXacnhanArrayList.clear();
        keyRequest.clear();
        keyUser.clear();

        mData.child("UserInfor").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                UserInfor userInfor = dataSnapshot.getValue(UserInfor.class);
                userInforArrayList.add(userInfor);
                keyUser.add(dataSnapshot.getKey());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mData.child("MonNuoc").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                MonNuoc monNuoc = dataSnapshot.getValue(MonNuoc.class);
                monNuocArrayList.add(monNuoc);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mData.child("RequestDonHang").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                RequestXacnhan requestXacnhan = dataSnapshot.getValue(RequestXacnhan.class);
                requestXacnhanArrayList.add(requestXacnhan);
                keyRequest.add(dataSnapshot.getKey());
//                Log.d("SDT",requestXacnhan.sdt);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public static void LoadKeyGioHang(){
        keygiohang.clear();
        mData.child("DonHang").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                keygiohang.add(dataSnapshot.getKey());
//                Log.d("Keyabc",keygiohang.get(keygiohang.size()-1));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void LoadDataNuoc(){

//          monNuocArrayList.add(new MonNuoc("38.000","37.000","Machiato Mango","Machiato co...","https://firebasestorage.googleapis.com/v0/b/database-projectandroid.appspot.com/o/1.jpg?alt=media&token=c8b9277b-41e9-4cbb-b3d2-7957f735c97a","https://firebasestorage.googleapis.com/v0/b/database-projectandroid.appspot.com/o/1.jpg?alt=media&token=c8b9277b-41e9-4cbb-b3d2-7957f735c97a"));
////        monNuocArrayList.add(new MonNuoc("41.000","35.000","Black coffee","Milk coffee"));
////        monNuocArrayList.add(new MonNuoc("40.000","36.000","Blue sky","Tropical stom"));
////        monNuocArrayList.add(new MonNuoc("55.000","39.000","Hột é","Nước mía"));
////        monNuocArrayList.add(new MonNuoc("37.000","44.000","cocain","red malboro"));
////        monNuocArrayList.add(new MonNuoc("37.000",null,"cocain",null));

//        ArrayList<String> urlImageNuoc = new ArrayList<>();
//        urlImageNuoc.add("https://firebasestorage.googleapis.com/v0/b/database-projectandroid.appspot.com/o/1.jpg?alt=media&token=f7dc6d3e-661d-4515-a8fc-19fcdc745129");
//        urlImageNuoc.add("https://firebasestorage.googleapis.com/v0/b/database-projectandroid.appspot.com/o/2.jpg?alt=media&token=158ad782-8a33-4bda-926c-2af6c66fb21a");
//
//        urlImageNuoc.add("https://firebasestorage.googleapis.com/v0/b/database-projectandroid.appspot.com/o/3.jpg?alt=media&token=22459459-2707-464a-a5be-b3fe14730991");
//        urlImageNuoc.add("https://firebasestorage.googleapis.com/v0/b/database-projectandroid.appspot.com/o/4.jpg?alt=media&token=cb35ff7f-6c78-4ba0-897c-939e8de8a12d");
//        urlImageNuoc.add("https://firebasestorage.googleapis.com/v0/b/database-projectandroid.appspot.com/o/5.jpg?alt=media&token=f482f667-1641-47c7-a9c2-ac2e42b6c38f");
//        urlImageNuoc.add("https://firebasestorage.googleapis.com/v0/b/database-projectandroid.appspot.com/o/6.jpg?alt=media&token=91bd6c15-371f-4803-a4aa-9752c6bce2ee");
//        MonNuoc monNuoc = new MonNuoc("38.000","37.000","Machiato Mango","Machiato co...",urlImageNuoc.get(0), urlImageNuoc.get(1));
//        MonNuoc monNuoc = new MonNuoc("41.000","35.000","Black coffee","Milk coffee",urlImageNuoc.get(2), urlImageNuoc.get(3));
//        MonNuoc monNuoc1 = new MonNuoc("40.000","36.000","Blue sky","Tropical stom",urlImageNuoc.get(4), urlImageNuoc.get(5));
//        MonNuoc monNuoc2 = new MonNuoc("55.000","39.000","Hột é","Nước mía",urlImageNuoc.get(0), urlImageNuoc.get(1));
//        MonNuoc monNuoc3 = new MonNuoc("37.000","44.000","cocain","red malboro",urlImageNuoc.get(3), urlImageNuoc.get(0));
//
//        mData.child("MonNuoc").push().setValue(monNuoc);
//        mData.child("MonNuoc").push().setValue(monNuoc1);
//        mData.child("MonNuoc").push().setValue(monNuoc2);
//        mData.child("MonNuoc").push().setValue(monNuoc3);

//        MainActivity.userInforArrayList.add(new UserInfor("nguoikhung@gmail.com","0356341653","tototo123","Nguyễn Hoàng Mẫn","11/08/1980","Female"));
//        MainActivity.userInforArrayList.add(new UserInfor("hello@gmail.com","0356981653","tototo123","Nguyễn Văn văn","1/1/1999","Male"));
//        MainActivity.userInforArrayList.add(new UserInfor("alen@gmail.com","03569345653","tototo123","Cao Văn Lầu","11/1/1999","Male"));
//        MainActivity.userInforArrayList.add(new UserInfor("pro@gmail.com","0356933553","tototo123","Nguyễn Văn B","12/1/1999","Female"));
//        MainActivity.userInforArrayList.add(new UserInfor("vip@gmail.com","0356553653","tototo123","Nguyễn Văn C","15/1/1999","Male"));
//        MainActivity.userInforArrayList.add(new UserInfor("vippro123@gmail.com","0356981653","tototo123","Nguyễn Thị D","1/1/1999","Male"));
//        MainActivity.userInforArrayList.add(new UserInfor("baophatnguyen99@gmail.com","0355555553","tototo123","Nguyễn Hữu Cảnh","1/1/1999","Male"));
//        MainActivity.userInforArrayList.add(new UserInfor("a","0355555553","b","Nguyễn Hữu Cảnh","1/1/1999","Male"));
//
//        for(int i = 0;i<1;i++){
//            mData.child("UserInfor").push().setValue(new UserInfor("nguoikhung@gmail.com","0356341653","tototo123","Nguyễn Hoàng Mẫn","11/08/1980","Female"));
//            mData.child("UserInfor").push().setValue(new UserInfor("a","0355555553","b","Nguyễn Hữu Cảnh","1/1/1999","Male"));
//            mData.child("UserInfor").push().setValue(new UserInfor("vip@gmail.com","0356553653","123","Nguyễn Văn C","15/1/1999","Male"));
//        }

    }
}

