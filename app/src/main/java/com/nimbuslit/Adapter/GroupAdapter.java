package com.nimbuslit.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nimbuslit.Constant.Constants;
import com.nimbuslit.HelperActivity;
import com.nimbuslit.MainActivity;
import com.nimbuslit.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GroupAdapter extends BaseAdapter implements Filterable {
    Activity activity;
    ArrayList<String> arrayList;
    ArrayList<String> filterarrayList;
    ProgressDialog progressDialog;
    private ItemFilter mFilter = new ItemFilter();

    public GroupAdapter(@NonNull Activity context) {
        activity = context;
        arrayList = new ArrayList<>();
        filterarrayList = new ArrayList<>();
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

    public void showDialog() {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.customize_group);
        LinearLayout linearLayout=dialog.findViewById(R.id.group_device_list);
        for(int i=0;i<4;i++) {
            View layout2 = LayoutInflater.from(activity).inflate(R.layout.group_device_text, null, false);

            TextView textView =  layout2.findViewById(R.id.custom_device_text);
            textView.setText("Light device "+(i+1));
            linearLayout.addView(layout2);
        }
        dialog.show();

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
                    inflate(R.layout.group_list_item, parent, false);
              }
        ViewHolder viewHolder=new ViewHolder(convertView);
        viewHolder.groupCustomize.setOnClickListener(view -> showDialog());
        viewHolder.editGroup.setOnClickListener(view -> {

                Intent intent = new Intent(activity, HelperActivity.class);
                intent.putExtra(Constants.MAIN_KEY, Constants.EDIT_GROUP);
                activity.startActivity(intent);

        });

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

    void showAlert(int position, String message, String title) {
        if (title.length() < 1)
            title = "Alert";
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(message)
                .setTitle(title);
        builder.setPositiveButton("Block", (dialog1, id) -> {
            // User clicked OK button
//            acceptRequest(2,position);
            dialog1.dismiss();

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
        @BindView(R.id.group_customize)
        Button groupCustomize;
        @BindView(R.id.edit_group)
        Button editGroup;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

     /*   public void acceptRequest(int acceptCode, int position) {  /// accept code =1 for accept request and =2 to block

    Call<JsonObject> call;
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), arrayList.get(position).getFriendId());
        progressDialog.setMessage("Progressing ...");
        switch (acceptCode)
        {
            case 1:
                call = AppHelper.apiInterface.acceptRequest(sessionManager.getToken(), requestBody);
                break;
            case 2:
                call = AppHelper.apiInterface.blockRequest(sessionManager.getToken(), requestBody);
                break;
             default:
                 return;
        }
        progressDialog.show();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                progressDialog.cancel();
                if (response.code() == 200) {
                    JsonObject jsonObject = response.body();
                    if (jsonObject == null) {
                        Log.w("All Business", "No Data");
                        return;
                    }
                    Log.w("friendsRequestAdapter:", jsonObject + "");

                    if (Integer.parseInt(jsonObject.get("status").getAsString()) == 1) {
                            arrayList.remove(position);
                            notifyDataSetChanged();
                    }
                    Toast.makeText(activity, ""+jsonObject.get("response").getAsString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(activity, "Fail,Check your connection and try again.", Toast.LENGTH_SHORT).show();
                }

            }


            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(activity, "Fail,Check your connection and try again.", Toast.LENGTH_SHORT).show();
                Log.w("error", "asd " + t.getMessage());
                progressDialog.cancel();
            }
        });
    }

    static class ViewHolder {
        @BindView(R.id.friends_request_profile)
        CircularImageView friendsProfile;
        @BindView(R.id.request_friend_name)
        TextView friendName;
        @BindView(R.id.button_accept_request)
        Button buttonAccept;
        @BindView(R.id.button_blocked)
        Button buttonBlocked;
        @BindView(R.id.request_friends_status)
        TextView friendsStatus;
        @BindView(R.id.friends_status_image)
        ImageView friendsStatusImage;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
*/
}
