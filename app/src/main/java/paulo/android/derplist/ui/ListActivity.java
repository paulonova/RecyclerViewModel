package paulo.android.derplist.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import paulo.android.derplist.R;
import paulo.android.derplist.adapter.DerpAdapter;
import paulo.android.derplist.model.DerpData;
import paulo.android.derplist.model.ListItem;

public class ListActivity extends AppCompatActivity implements DerpAdapter.ItemClickCallBack{

    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";

    private RecyclerView recView;
    private DerpAdapter adapter;
    private ArrayList listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listData = (ArrayList)DerpData.getListData();

        recView = (RecyclerView)findViewById(R.id.rec_list);

        //LayoutManager: GridLayoutManager and StaggeredGridLayoutManager
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DerpAdapter(listData, this);
        recView.setAdapter(adapter);

        adapter.setItemClickCallBack(this);

    }

    @Override
    public void onItemClick(int p) {

        ListItem item = (ListItem) listData.get(p);
        Toast.makeText(this, "TEST 1 - " + p,Toast.LENGTH_SHORT).show();

//        Intent i = new Intent(this, DetailActivity.class);
//
//        Bundle extras = new Bundle();
//        extras.putString(EXTRA_QUOTE, item.getTitle());
//        extras.putString(EXTRA_ATTR, item.getSubTitle());
//        i.putExtra(BUNDLE_EXTRAS, extras);
//
//        startActivity(i);
    }

    @Override
    public void onSecondaryIconClick(int p) {

        ListItem item = (ListItem) listData.get(p);
        Toast.makeText(this, "TEST 2 - " + p,Toast.LENGTH_SHORT).show();
    }
}
