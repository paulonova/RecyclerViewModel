package paulo.android.derplist.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import paulo.android.derplist.R;
import paulo.android.derplist.adapter.DerpAdapter;
import paulo.android.derplist.model.DerpData;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recView;
    private DerpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recView = (RecyclerView)findViewById(R.id.rec_list);

        //LayoutManager: GridLayoutManager and StaggeredGridLayoutManager
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DerpAdapter(DerpData.getListData(), this);
        recView.setAdapter(adapter);

    }
}
