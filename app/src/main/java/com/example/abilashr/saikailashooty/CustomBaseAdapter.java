package com.example.abilashr.saikailashooty;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    List<String> events;
    public CustomBaseAdapter(Context context, List<String> events) {
        this.context = context;
        this.events = events;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int i) {
        return events.get(i);
    }

    @Override
    public long getItemId(int i) {
        return events.indexOf(getItem(i));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(R.layout.event_name,null);
        TextView textView =(TextView)convertView.findViewById(R.id.eventName);

        return convertView;
    }
}
