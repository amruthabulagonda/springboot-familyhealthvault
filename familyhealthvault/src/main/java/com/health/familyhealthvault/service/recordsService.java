package com.health.familyhealthvault.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.health.familyhealthvault.entity.Record;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class recordsService {

    public Record getRecord(String documentId) throws ExecutionException, InterruptedException {
        Record record;
        Firestore dbFireStore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFireStore.collection("myrecords").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        if(document.exists()){
            record = document.toObject(Record.class);
            return record;
        }
        return null;
    }

    public String saveRecord(Record record) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("myrecords").document(record.getDocumentId()).set(record);
        return "Record saved successfully on " + collectionsApiFuture.get().getUpdateTime().toString();
    }
}
