package com.owen.nakurutravellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    private EditText etPrice;
    private EditText etDesc;
    private EditText etTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDesc = (EditText)findViewById(R.id.txtDescription);
        etPrice = (EditText)findViewById(R.id.txtPrice);
        etTitle = (EditText)findViewById(R.id.txtTitle);
 FirebaseUtil.openfbReference("traveldeals");

        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
        mDatabaseReference =FirebaseUtil.mDatabaseReference;
        //AddChildReferncer to listner to the changes



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_save:

            saveDeals();

            Toast.makeText(this,"Data saved", Toast.LENGTH_LONG).show();

            clean();

            return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void saveDeals()
    {
        String title = etTitle.getText().toString();
        String price = etPrice.getText().toString();
        String desc = etDesc.getText().toString();

        //created an Object to write to the database;
        TravelDeals travelDeals = new TravelDeals(title, price, desc, "");
        mDatabaseReference.push().setValue(travelDeals);

    }

    public void clean()
    {
        //clear Data from the Edit txt
        etTitle.setText("");
        etPrice.setText("");
        etDesc.setText("");

        //get focus for the title
        etTitle.requestFocus();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save, menu);
        return true;
    }
}
