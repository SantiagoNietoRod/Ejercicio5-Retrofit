package com.example.ejercicio5_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.example.ejercicio5_retrofit.network.PokemonAPI;
import com.example.ejercicio5_retrofit.network.models.Pokemon;
import com.example.ejercicio5_retrofit.network.models.PokemonListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PokemonAdapter adapterPokemon;
    private Retrofit retrofit;
    private int offset;
    private boolean aptoParaCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = this.findViewById(R.id.recyclerView);
        adapterPokemon = new PokemonAdapter(this);
        recyclerView.setAdapter(adapterPokemon);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        offset =0;
        obtenerDatos(offset);

    }

    private void obtenerDatos(int offset) {
        PokemonAPI service = retrofit.create(PokemonAPI.class);
        Call<PokemonListResponse> pokemonRespuestaCall = service.getPokemonList(100, offset);

        pokemonRespuestaCall.enqueue(new Callback<PokemonListResponse>() {
            @Override
            public void onResponse(Call<PokemonListResponse> call, Response<PokemonListResponse> response) {
                aptoParaCargar = true;
                if (response.isSuccessful()) {
                    PokemonListResponse pokemonRespuesta = response.body();
                    List<Pokemon> listaPokemon = pokemonRespuesta.getPokemonList();

                    adapterPokemon.adicionarListaPokemon(listaPokemon);
            }
        }

            @Override
            public void onFailure(Call<PokemonListResponse> call, Throwable t) {
                aptoParaCargar = true;
            }}
            );
    }

}