package com.owen.nakurutravellers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ArrayList<TravelDeals> travelDealsArray;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
            RecyclerView rvDeals = (RecyclerView) findViewById(R.id.rvDeals);
        final  DealAdapter adapter = new DealAdapter();
        rvDeals.setAdapter(adapter);

        LinearLayoutManager dealLayoutmanager =  new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvDeals.setLayoutManager(dealLayoutmanager);

}
    
     @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_activity_menu, menu);
        return true;
    }
