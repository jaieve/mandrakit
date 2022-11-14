package com.jaieve.mandrakit.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.jaieve.mandrakit.dto.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.concurrent.ExecutionException;

@Repository
@Slf4j
public class GoalDAO {
    public static final String COLLECTION_NAME = "goals";

    public String save(Category category) {
        Long goalKey = System.currentTimeMillis();
        category.setCreateDateTime(new Date(goalKey));
        category.setUpdateDateTime(new Date(goalKey));

    // https://firebase.google.com/docs/firestore/manage-data/add-data
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = db.collection(COLLECTION_NAME).document(String.valueOf(goalKey)).set(category);
        return String.valueOf(goalKey);
    }

    public Category getGoal(String goalId) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection(COLLECTION_NAME).document(goalId);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        Category category = null;
        if (document.exists()) {
            category = document.toObject(Category.class);
            log.info("User : {}", category);
        } else {
            log.info("Goal is null");
        }
        return category;
    }
}
