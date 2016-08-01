package paulo.android.derplist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paulo Vila Nova on 2016-07-31.
 */
public class DerpData {

    private static final String[] titles  = {"Nothingness cannot be defined", "The softest thing cannot be snapped",
            "be like water, my friend."} ;
    private static final int[] icons = {android.R.drawable.ic_popup_reminder,
                                        android.R.drawable.ic_menu_add,
                                        android.R.drawable.ic_menu_delete};

    public static List<ListItem> getListData() {
        List<ListItem> data = new ArrayList<>();

        //Repeat process 4 times, so that we have enough data to demonstrate a scrollable
        //RecyclerView
        for (int x = 0; x < 4; x++) {
            //create ListItem with dummy data, then add them to our List
            for (int i = 0; i < titles.length && i < icons.length; i++) {
                ListItem item = new ListItem();
                item.setImageResId(icons[i]);
                item.setTitle(titles[i]);
                data.add(item);
            }
        }
        return data;
    }
}
