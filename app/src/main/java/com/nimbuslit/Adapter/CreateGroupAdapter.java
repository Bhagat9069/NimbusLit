package com.nimbuslit.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import com.nimbuslit.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CreateGroupAdapter extends BaseAdapter implements Filterable {
    Activity activity;
    ArrayList<String> arrayList;
    ArrayList<String> filterarrayList;
    ProgressDialog progressDialog;
    private ItemFilter mFilter = new ItemFilter();

    public CreateGroupAdapter(@NonNull Activity context) {
        activity = context;
        arrayList = new ArrayList<>();
        filterarrayList = new ArrayList<>();
        progressDialog = new ProgressDialog(activity);
        progressDialog.setCanceledOnTouchOutside(false);
    }


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

    public void showDialog()
    {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.light_device_details);
        dialog.show();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).
                    inflate(R.layout.create_group_list_item, parent, false);
            ViewHolder viewHolder=new ViewHolder(convertView);
            viewHolder.customizeDevice.setOnClickListener(view -> showDialog());
            viewHolder.selectDevice.setOnClickListener(view -> Toast.makeText(activity, "Will be soon.", Toast.LENGTH_SHORT).show());
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

    void showAlert(String message, String title) {
        if (title.length() < 1)
            title = "Alert";
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(message)
                .setTitle(title);
        builder.setPositiveButton("Remove", (dialog1, id) -> {
            // User clicked OK button
//            acceptRequest(2,position);
            dialog1.dismiss();
            Toast.makeText(activity, "Will be soon", Toast.LENGTH_SHORT).show();

        });
        builder.setNegativeButton("Cancel", (dialog, which) -> {
            dialog.dismiss();
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public Filter getFilter() {
//        arrayList=filterarrayList;
        return mFilter;
    }


    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

           /* final ArrayList<FriendsRequestData.FRequestDetails> list = filterarrayList;
            int count = list.size();
            final ArrayList<FriendsRequestData.FRequestDetails> nlist = new ArrayList<>(count);

            FriendsRequestData.FRequestDetails filterableString;

            for (int i = 0; i < count; i++) {
                filterableString = list.get(i);
                if (filterableString.getUserName().toLowerCase().contains(filterString)) {
                    nlist.add(filterableString);
                }
            }*/
    /*        results.values = nlist;
            results.count = nlist.size();*/

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // arrayList = (ArrayList<FriendsRequestData.FRequestDetails>) results.values;
            // notifyDataSetChanged();
        }

    }

    static class ViewHolder {
        @BindView(R.id.customize_device)
        Button customizeDevice;
        @BindView(R.id.select_device)
        Button selectDevice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
