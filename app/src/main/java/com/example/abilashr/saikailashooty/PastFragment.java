package com.example.abilashr.saikailashooty;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.abilashr.saikailashooty.data.DataContract;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class PastFragment extends Fragment {
    Cursor cursor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_past, container, false);
        cursor = getActivity().getContentResolver().query(DataContract.EventEntry.CONTENT_URI, null, DataContract.EventEntry.EVENT_DATE + "< '" + getDateAndTime() + "'", null, DataContract.EventEntry.EVENT_DATE);
        CustomCursorAdapter customCursorAdapter = new CustomCursorAdapter(getContext(), cursor);
        if(cursor.getCount() != 0) {
            cursor.moveToNext();
        }
        ListView listView = (ListView) rootView.findViewById(R.id.pastList);
        listView.setAdapter(customCursorAdapter);
        return rootView;
    }
    private String getDateAndTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
