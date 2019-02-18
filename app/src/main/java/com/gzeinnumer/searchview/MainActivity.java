package com.gzeinnumer.searchview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.idSearch)
    SearchView idSearch;
    @BindView(R.id.listView)
    ListView listView;

    ArrayAdapter<String> adapter;
    String[] data = {"a","b","c","d","e","f","g","h","i","j","k","l"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        idSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String text = newText;
                adapter.getFilter().filter(newText);
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
