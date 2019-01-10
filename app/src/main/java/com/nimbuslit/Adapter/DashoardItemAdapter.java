package com.nimbuslit.Adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.nimbuslit.R;

import java.util.ArrayList;


public class DashoardItemAdapter extends BaseAdapter{
    Activity activity;
    ArrayList<String> arrayList;

    ProgressDialog progressDialog;


    public DashoardItemAdapter(@NonNull Activity context) {
        activity = context;
        arrayList = new ArrayList<>();

        progressDialog = new ProgressDialog(activity);
        progressDialog.setCanceledOnTouchOutside(false);
    }

   /* public void setList(List<FriendsRequestData.FRequestDetails> arrayList1) {
        arrayList.clear();
        filterarrayList.clear();
        arrayList.addAll(arrayList1);
        filterarrayList.addAll(arrayList1);
        notifyDataSetChanged();
    }*/

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public String getItem(int position) {
        if (arrayList.size() <= position)
            return null;
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).
                    inflate(R.layout.dashboard_list_item, parent, false);
        }
//        ViewHolder viewHolder = new ViewHolder(convertView);
       /* FriendsRequestData.FRequestDetails friendsDetails = arrayList.get(position);
        viewHolder.friendName.setText(String.format("%s", friendsDetails.getUserName()));

        Picasso.with(activity).load(IMAGE_URL + friendsDetails.getUserImage()).placeholder(R.drawable.ic_user_male_icon_2).error(R.drawable.ic_user_male_icon_2).into(viewHolder.friendsProfile);

        viewHolder.buttonAccept.setOnClickListener(v -> acceptRequest(1, position));/// accept request

        viewHolder.buttonBlocked.setOnClickListener(v ->
//                acceptRequest(2, position)
                showAlert(position,"Are you sure to block '"+friendsDetails.getUserName()+"'","Block '"+friendsDetails.getUserName()+"'")
        ); /// block request
*/
        return convertView;
    }
      void showAlert(int position,String message,String title)
    {
        if (title.length()<1)
            title="Alert";
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(message)
                .setTitle(title);
        builder.setPositiveButton("Block", (dialog1, id) -> {
            // User clicked OK button
//            acceptRequest(2,position);
            dialog1.dismiss();

        });
        builder.setNegativeButton("Cancel",(dialog, which) -> {
            dialog.dismiss();
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }




}
