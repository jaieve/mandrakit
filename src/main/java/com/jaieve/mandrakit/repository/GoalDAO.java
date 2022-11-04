package com.jaieve.mandrakit.repository;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.jaieve.mandrakit.dto.Category;
import com.jaieve.mandrakit.dto.Goal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class GoalDAO {
    public static final String COLLECTION_NAME = "goals";
    public void save(List<Goal> goalList, String userId) {
        Map<String, Object> goals = new HashMap<>();
        Set<Map.Entry<String, Category> goalset = goalList.get(0).getGoal().entrySet();

//        goals.put(goalList.get(0))

    // https://firebase.google.com/docs/firestore/manage-data/add-data

        Firestore db = FirestoreClient.getFirestore();
//        db.collection(COLLECTION_NAME).
        db.collection(COLLECTION_NAME).document(userId);
    }
}
