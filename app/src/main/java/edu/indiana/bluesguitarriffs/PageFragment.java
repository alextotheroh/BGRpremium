package edu.indiana.bluesguitarriffs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int pageNumber = getArguments().getInt("page_number");
        View v = inflater.inflate(R.layout.page_layout, container, false);

        TextView tv = (TextView)v.findViewById(R.id.PageTitle);
        tv.setText("Page " + Integer.toString(pageNumber));

        return v;
    }

    public static PageFragment newInstance(int pageNumber){
        PageFragment f = new PageFragment();
        Bundle b = new Bundle();
        b.putInt("page_number", pageNumber);

        f.setArguments(b);

        return f;
    }

}
