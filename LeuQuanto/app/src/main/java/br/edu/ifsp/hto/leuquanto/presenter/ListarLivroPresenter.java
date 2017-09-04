package br.edu.ifsp.hto.leuquanto.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import br.edu.ifsp.hto.leuquanto.adapter.LivroAdapter;
import br.edu.ifsp.hto.leuquanto.domain.Livro;
import br.edu.ifsp.hto.leuquanto.service.LivroService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListarLivroPresenter {


    private static String baseURL = "http://192.168.0.148:8090/";

    public void listarLivro (final Context context, final ListView listView){
        Log.d("Passo 3", "listarLivro");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LivroService service = retrofit.create(LivroService.class);
        Call<List<Livro>> call = service.listarLivros();
        call.enqueue(new Callback<List<Livro>>() {
            @Override
            public void onResponse(Call<List<Livro>> call, Response<List<Livro>> response) {
                List<Livro> livros = response.body();
                listView.setAdapter(new LivroAdapter(context,livros));
            }

            @Override
            public void onFailure(Call<List<Livro>> call, Throwable t) {

            }
        });
    }
}
