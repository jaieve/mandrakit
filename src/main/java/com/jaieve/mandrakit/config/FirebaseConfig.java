package com.jaieve.mandrakit.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {
    @Value("${firebase.sdk.path}")
    private String firebaseSdkPath;
    private FirebaseApp firebaseApp;

    @PostConstruct
    public FirebaseApp init() throws IOException {
        Resource resource = new ClassPathResource(firebaseSdkPath);
        FileInputStream serviceAccount = new FileInputStream(resource.getFile());
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        firebaseApp = FirebaseApp.initializeApp(options);
        return firebaseApp;
    }

    @Bean
    public FirebaseAuth initFirebaseAuth() {
        FirebaseAuth instance = FirebaseAuth.getInstance(firebaseApp);
        return instance;
    }
}
