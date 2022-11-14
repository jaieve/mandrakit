package com.jaieve.mandrakit.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.jaieve.mandrakit.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
@Slf4j
public class UserDAO {
    public static final String COLLECTION_NAME = "users";

    public List<User> getUsers() throws ExecutionException, InterruptedException {
        List<User> list = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            list.add(document.toObject(User.class));
        }
        return list;
    }

    public User getUser(String userKey) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection(COLLECTION_NAME).document(userKey);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        User user = null;
        if (document.exists()) {
            user = document.toObject(User.class);
            log.info("User : {}", user);
        } else {
            log.info("User is null");
        }
        return user;
    }

    public void saveGoal(String userKey, String goalKey) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection(COLLECTION_NAME).document(userKey);
        ApiFuture<WriteResult> writeResult  = docRef.update("goalId", goalKey);
        log.info("Update Result : " + writeResult.get());
    }
}
