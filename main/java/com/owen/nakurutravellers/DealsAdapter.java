package com.owen.nakurutravellers;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DealsTraAdapter extends RecyclerView.Adapter<DealsTraAdapter.DealViewHolder>
{
    ArrayList<TravelDeals> travelDealsArray;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildEventListener;



    public DealsTraAdapter()
    {

        FirebaseUtils.openFireRef("Traveellers");
        mFirebaseDatabase = FirebaseUtils.mFirebaseDatabase;
        mDatabaseReference =FirebaseUtils.mDatabaseReference;
        travelDealsArray = FirebaseUtils.mDeals;
       mDatabaseReference.addChildEventListener(mChildEventListener);


        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                TravelDeals td = dataSnapshot.getValue(TravelDeals.class);

                Log.d("Deals", td.getTitle());
                td.setId(dataSnapshot.getKey());
                travelDealsArray.add(td);
                notifyItemInserted(travelDealsArray.size()-1);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
    }

    @NonNull
    @Override
    public DealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.rv_deals, parent, false);

        return new DealViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DealViewHolder holder, int position)
    {
        TravelDeals deal = travelDealsArray.get(position);
        holder.bindData(deal);

    }

    @Override
    public int getItemCount() {

        return travelDealsArray.size();
    }

    public class DealViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvTitle;

        public DealViewHolder(@NonNull View itemView)
        {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitleDeals);
        }

        public void bindData(TravelDeals deals)
        {
            tvTitle.setText(deals.getTitle());
        }
    }

}
