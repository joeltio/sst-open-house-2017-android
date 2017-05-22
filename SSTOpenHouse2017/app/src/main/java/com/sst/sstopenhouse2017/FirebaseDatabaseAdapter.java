package com.sst.sstopenhouse2017;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

public class FirebaseDatabaseAdapter {
    enum Booth {
        A("");

        private final String boothName;
        Booth(String boothName) {
            this.boothName = boothName;
        }

        public String getBoothName() {
            return this.boothName;
        }

    }

    private FirebaseDatabase database;
    private DatabaseReference root;

    public void open(String url) {
        this.database = FirebaseDatabase.getInstance();
        this.root = this.database.getReferenceFromUrl(url);
    }

    public void increment(Booth booth) {
        root.child(booth.getBoothName()).runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData currentData) {
                Integer i = currentData.getValue(Integer.class);

                if (i != null) {
                    i++;
                    currentData.setValue(i);
                }
                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {}
        });
    }
}
