package edu.aku.hassannaqvi.epi_register.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.epi_register.R;
import edu.aku.hassannaqvi.epi_register.core.MainApp;
import edu.aku.hassannaqvi.epi_register.models.FormCRFollowUP;


public class RegisteredMembersAdapter extends RecyclerView.Adapter<RegisteredMembersAdapter.ViewHolder> {
    private static final String TAG = "RegisteredMembersAdapter";
    private final Context mContext;
    private final List<FormCRFollowUP> formCRFollowUPS;
    private final List<FormCRFollowUP> backupItems = new ArrayList<>();
    private final int completeCount;
    private final OnItemClickListener onItemClickListener;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param formCRFollowUPS List<MembersModel> containing the data to populate views to be used by RecyclerView.
     */
   /* public VaccinatedMembersAdapter(Context mContext, List<FormVB> members) {
        this.member = members;
        this.mContext = mContext;
        completeCount = 0;

    }*/
    public RegisteredMembersAdapter(Context mContext, List<FormCRFollowUP> formCRFollowUPS, OnItemClickListener onItemClickListener) {
        this.formCRFollowUPS = formCRFollowUPS;
        backupItems.clear();
        backupItems.addAll(formCRFollowUPS);
        this.mContext = mContext;
        completeCount = 0;
        this.onItemClickListener = onItemClickListener;

    }

    // Add filter
    @SuppressLint("NotifyDataSetChanged")
    public void filter(String query) {
        if (query.equals("")) {
            // Show original list
            formCRFollowUPS.clear();
            formCRFollowUPS.addAll(backupItems);
            notifyDataSetChanged();
        } else {
            formCRFollowUPS.clear();
            for (FormCRFollowUP formCRFollowUP : backupItems) {
                if (formCRFollowUP.getCr_card_number().toLowerCase().contains(query) ||
                        formCRFollowUP.getCr_child_name().toLowerCase().contains(query) ||
                        formCRFollowUP.getCr_page_number().contains(query)) {
                    formCRFollowUPS.add(formCRFollowUP);
                }
            }
            notifyDataSetChanged();
        }
    }


    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");
        FormCRFollowUP formCRFollowUP = this.formCRFollowUPS.get(position);        // Get element from your dataset at this position and replace the contents of the view
        // with that element

        TextView fName = viewHolder.mName;
        TextView fAgeD = viewHolder.mAgeD;
        TextView fAgeM = viewHolder.mAgeM;
        TextView fAgeY = viewHolder.mAgeY;
        TextView fatherName = viewHolder.fatherName;
        TextView cardNo = viewHolder.cardNo;
        ImageView mainIcon = viewHolder.mainIcon;

        fName.setText(formCRFollowUP.getCr_child_name());
        fAgeD.setText(formCRFollowUP.getCr_age_days() + " D ");
        fAgeM.setText(formCRFollowUP.getCr_age_months() + " M ");
        fAgeY.setText(formCRFollowUP.getCr_age_years() + " Y ");
        fatherName.setText("Father Name: " + formCRFollowUP.getCr_father_name());
        cardNo.setText("Card No: " + formCRFollowUP.getCr_card_number());
        mainIcon.setImageResource(formCRFollowUP.getCr_gender().equals("1") ? R.drawable.malebabyicon : R.drawable.femalebabyicon);
        viewHolder.itemView.setOnClickListener(view -> onItemClickListener.onItemClick(this.formCRFollowUPS.get(position)));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.registered_member_row, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        MainApp.memberCount = formCRFollowUPS.size();
        return formCRFollowUPS.size();
    }

    public interface OnItemClickListener {
        void onItemClick(FormCRFollowUP formCRFollowUP);
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mName;
        private final TextView mAgeD;
        private final TextView mAgeM;
        private final TextView mAgeY;
        private final TextView fatherName;
        private final TextView cardNo;
        private final ImageView mainIcon;


        public ViewHolder(View v) {
            super(v);
            mName = v.findViewById(R.id.mName);
            mAgeD = v.findViewById(R.id.ageD);
            mAgeM = v.findViewById(R.id.ageM);
            mAgeY = v.findViewById(R.id.ageY);
            fatherName = v.findViewById(R.id.fName);
            cardNo = v.findViewById(R.id.cardNo);
            mainIcon = v.findViewById(R.id.mainIcon);

        }

        public TextView getTextView() {
            return mName;
        }
    }
}
