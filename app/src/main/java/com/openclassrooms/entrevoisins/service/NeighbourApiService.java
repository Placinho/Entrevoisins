package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;



public interface NeighbourApiService {


    List<Neighbour> getNeighbours();


    void deleteNeighbour(Neighbour neighbour);


    List<Neighbour> createNeighbour(Neighbour neighbour);

    void addNeighbour(Neighbour neighbour);

    List<Neighbour> getFavoriteNeighbours();

    void removeFavorite(Neighbour neighbour);

    void addFavorite(Neighbour neighbour);
}
