package br.edu.ifsp.hto.leuquanto.service;

import java.util.List;

import br.edu.ifsp.hto.leuquanto.domain.Livro;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Luiz on 14/06/2016.
 */
public interface LivroService {
    @GET("livro/list")
    Call<List<Livro>> listarLivros();

    @POST("livro/new")
    Call<Livro> adicionarLivro(@Body Livro livro);

    @FormUrlEncoded
    @POST("livro/update/")
    Call<Livro> atualizarLivro(@Field("n_livro") long id, @Field("paginas_lida") int paginas_lida,
                               @Field("paginas_faltando") int paginas_faltando, @Field("status") String status);

}
