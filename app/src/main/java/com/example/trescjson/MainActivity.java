package com.example.trescjson;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listaAktywnosci;
    Button przyciskPokaz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaAktywnosci = findViewById(R.id.listaAktywnosci);
        przyciskPokaz = findViewById(R.id.przyciskPokaz);

        przyciskPokaz.setOnClickListener(v -> pobierzAktywnosci());

    }

    private void pobierzAktywnosci() {
        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/foidslayer1337/gson/refs/heads/main/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        JsonPlaceHolderApi api = retrofit.create(JsonPlaceHolderApi.class);

        Call<BazaDanychJSON> call = api.getAktywnosci();

        call.enqueue(new Callback<BazaDanychJSON>() {
            @Override
            public void onResponse(Call<BazaDanychJSON> call, Response<BazaDanychJSON> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Aktywnosc> aktywnosciZInternetu = response.body().getPytania();

                    ArrayAdapter<Aktywnosc> adapter = new ArrayAdapter<>(
                            MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            aktywnosciZInternetu
                    );

                    listaAktywnosci.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<BazaDanychJSON> call, Throwable t) {
            }
        });
    }
}
