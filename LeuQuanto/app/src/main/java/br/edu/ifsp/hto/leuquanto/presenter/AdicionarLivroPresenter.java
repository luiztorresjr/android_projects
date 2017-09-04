package br.edu.ifsp.hto.leuquanto.presenter;

import android.content.Context;
import android.widget.Toast;

import br.edu.ifsp.hto.leuquanto.domain.Livro;
import br.edu.ifsp.hto.leuquanto.service.LivroService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Luiz on 20/06/2016.
 */
public class AdicionarLivroPresenter {

    private static String baseURL = "http://192.168.0.148:8090/";
    private String mensagem;
    public void adicionarLivro(final Context context, final Livro livro){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LivroService service = retrofit.create(LivroService.class);
        Call<Livro> call = service.adicionarLivro(livro);

        call.enqueue(new Callback<Livro>() {
            @Override
            public void onResponse(Call<Livro> call, Response<Livro> response) {
                String mensagem="Adicionado com sucesso";
                Toast.makeText(context,mensagem,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Livro> call, Throwable t) {

            }
        });
    }
}
