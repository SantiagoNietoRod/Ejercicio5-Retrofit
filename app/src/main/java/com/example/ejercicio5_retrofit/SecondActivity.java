package com.example.ejercicio5_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.ejercicio5_retrofit.databinding.ActivitySecondBinding;
import com.example.ejercicio5_retrofit.network.models.Pokemon;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            Pokemon pokemon = (Pokemon) bundle.getSerializable("Pokemon");

            Glide.with(this)
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemon.getNumber() + ".png")
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.imagen);
            binding.nombre.setText((pokemon.getName()));
            //binding.tipo.setText(pokemon.getBase_experience());
        }
    }
}