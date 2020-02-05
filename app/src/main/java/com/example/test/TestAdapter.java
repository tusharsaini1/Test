package com.example.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class TestAdapter extends RecyclerView.Adapter<TestAdapter.itemHolder> {

    String[] testList;

    public TestAdapter(String[] stringArray) {
        testList = stringArray;
    }

    @NonNull
    @Override
    public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new itemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemHolder holder, int position) {
        holder.test.setText(testList[position]);
        if (position == 0) {
            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(holder.itemView.getContext(),
                    R.layout.list_item, R.id.textView_list, holder.itemView.getResources().getStringArray(R.array.TestList));
            holder.listView.setAdapter(arrayAdapter);
        } else if (position == 1) {
            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(holder.itemView.getContext(),
                    R.layout.list_item, R.id.textView_list, holder.itemView.getResources().getStringArray(R.array.List1));
            holder.listView.setAdapter(arrayAdapter);
        } else if (position == 2) {
            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(holder.itemView.getContext(),
                    R.layout.list_item, R.id.textView_list, holder.itemView.getResources().getStringArray(R.array.List2));
            holder.listView.setAdapter(arrayAdapter);
        }

    }

    @Override
    public int getItemCount() {
        return testList.length;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class itemHolder extends RecyclerView.ViewHolder {

        TextView test, listtext;
        ListView listView;

        public itemHolder(@NonNull View itemView) {
            super(itemView);

            test = itemView.findViewById(R.id.test);
            listView = itemView.findViewById(R.id.listView);
            listtext = itemView.findViewById(R.id.textView_list);
        }
    }
}
