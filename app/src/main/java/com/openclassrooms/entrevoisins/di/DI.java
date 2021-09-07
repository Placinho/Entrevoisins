package com.openclassrooms.entrevoisins.di;

import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;


public class DI {

    private static NeighbourApiService service = new DummyNeighbourApiService();


    public static NeighbourApiService getNeighbourApiService() {
        return service;
    }


    public static NeighbourApiService getNewInstanceApiService() {
        return new DummyNeighbourApiService();
    }
}
