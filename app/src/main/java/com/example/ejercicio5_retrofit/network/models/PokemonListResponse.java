package com.example.ejercicio5_retrofit.network.models;

import com.example.ejercicio5_retrofit.network.models.Pokemon;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonListResponse {

    private int count;
    private String next;
    private String previous;
    @SerializedName("results")  //Se usa cuando el nombre de la variable del GSON es distinto al que se ha asignado en la clase java
    private List<Pokemon> pokemonList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
