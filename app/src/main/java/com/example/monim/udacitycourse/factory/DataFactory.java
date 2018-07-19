package com.example.monim.udacitycourse.factory;

public class DataFactory {
    public static DataGenerator data(boolean isNetworkConnected) {

        if (isNetworkConnected) {
            return new RemotDataGenerator();
        } else {
            return new LocalDataGenerator();
        }

    }
}
