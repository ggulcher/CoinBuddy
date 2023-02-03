package com.example.coinbuddy.di

import com.example.coinbuddy.data.repository.FirebaseCoinFavoriteManager
import com.example.coinbuddy.data.repository.FirebaseCoinFavoriteManagerImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object FirebaseModule {

    @Provides
    @Singleton
    fun providesFirebaseAuth() = Firebase.auth

    @Provides
    @Singleton
    fun providesFireStore() = Firebase.firestore

    @Provides
    @Singleton
    fun providesFirebaseRepository(
        firebaseAuth: FirebaseAuth,
        fireStore: FirebaseFirestore
    ): FirebaseCoinFavoriteManager {
        return FirebaseCoinFavoriteManagerImpl(firebaseAuth, fireStore)
    }
}
