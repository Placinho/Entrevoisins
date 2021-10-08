package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;


public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    public List<Neighbour> getNeighbours() {
        return neighbours;
    }


    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }


    @Override
    public List<Neighbour> addNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
        return null;
    }


    @Override
    public void addFavorite(Neighbour serializedNeighbour) {
        Neighbour originalNeighbour = neighbours.get(neighbours.indexOf(serializedNeighbour));
        originalNeighbour.setFavorite(true);
    }


    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        List<Neighbour> favoriteNeighbourList = new ArrayList<>();
        for (Neighbour n : neighbours) {
            if (n.isFavorite()) {
                favoriteNeighbourList.add(n);
            }
        }
        return favoriteNeighbourList;
    }

    @Override
        public void removeFavorite(Neighbour serializedNeighbour) {
            Neighbour originalNeighbour = neighbours.get(neighbours.indexOf(serializedNeighbour));
            originalNeighbour.setFavorite(false);
        }

    }

