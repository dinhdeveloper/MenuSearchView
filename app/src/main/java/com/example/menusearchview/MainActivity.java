package com.example.menusearchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lvTinhThanh;
    ArrayList<String> dsTinhThanh;
    ArrayAdapter<String> adapterTinhThanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
    }

    private void addControls() {
        lvTinhThanh = findViewById(R.id.lvTinhThanh);

        dsTinhThanh = new ArrayList<>();
        dsTinhThanh.addAll(Arrays.asList(getResources().getStringArray(R.array.arrTinhThanh)));

        adapterTinhThanh = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,dsTinhThanh);
        lvTinhThanh.setAdapter(adapterTinhThanh);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_timkiem,menu);
        MenuItem menuItem = menu.findItem(R.id.menuSearch);// lay id search
        SearchView searchView = (SearchView) menuItem.getActionView(); // tra ve view
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            //khi nhấn tìm mới tìm
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            //vừa gõ vừa tìm
            public boolean onQueryTextChange(String newText) {
                adapterTinhThanh.getFilter().filter(newText);// getFilter cho phép lọc dữ liệu trong
                //adapter với thông số truyền vào là newText
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }
}
