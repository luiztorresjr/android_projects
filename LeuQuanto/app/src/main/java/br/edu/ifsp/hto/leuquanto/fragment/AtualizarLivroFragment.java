package br.edu.ifsp.hto.leuquanto.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.edu.ifsp.hto.leuquanto.R;
import br.edu.ifsp.hto.leuquanto.adapter.LivroAdapter;
import br.edu.ifsp.hto.leuquanto.domain.Livro;
import br.edu.ifsp.hto.leuquanto.service.LivroService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AtualizarLivroFragment extends Fragment {
    private Livro livro;
    private ListView listView;
    private View view;
    private String baseURL = "http://192.168.0.148:8090/";


    public AtualizarLivroFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view =  inflater.inflate(R.layout.fragment_atualizar_livro, container, false);

        listView = (ListView) view.findViewById(R.id.lvSelecionarLivros);

        preencherLista();

        Button btAtualizar = (Button) view.findViewById(R.id.btAtualizar);

        Button btSelecionar = (Button) view.findViewById(R.id.btSelecionar);
        final EditText etTitulo = (EditText) view.findViewById(R.id.etUpdateTitulo);
        final EditText etAutor = (EditText) view.findViewById(R.id.etUpdateAutor);
        final EditText etTotal = (EditText) view.findViewById(R.id.etUpdatePaginaTotal);



        btSelecionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etAutor.setText(livro.getAutor());
                etTitulo.setText(livro.getTitulo());
                etTotal.setText(""+livro.getPaginasTotal());
                etTitulo.setEnabled(false);
                etAutor.setEnabled(false);
                etTotal.setEnabled(false);
            }
        });
        btAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualiza();

            }
        });
        return view;
    }

    public void atualiza(){
        int lida, falta;
        String status = "";

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);


        EditText etLidas = (EditText) view.findViewById(R.id.etUpdatePaginaLida);
        if(etLidas.getText().toString().isEmpty())
            lida=0;
        else
            lida = Integer.parseInt(etLidas.getText().toString());
        livro.setPaginasFaltando(livro.getPaginasTotal() - lida);
        if(lida == 0){
            status = "Lerei";
        }else if(lida == livro.getPaginasTotal()){
            status = "Lido";
        }else{
            status = "Lendo - Falta: "+livro.getPaginasFaltando()+" páginas";
        }


        livro.setStatus(status);
        livro.setPaginasLidas(lida);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LivroService service = retrofit.create(LivroService.class);
        Call<Livro> call = service.atualizarLivro(livro.getId(), livro.getPaginasLidas(), livro.getPaginasFaltando(), livro.getStatus());
        call.enqueue(new Callback<Livro>() {
            @Override
            public void onResponse(Call<Livro> call, Response<Livro> response) {
                String mensagem="Atualizado com sucesso";
                Toast.makeText(getContext(),mensagem,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Livro> call, Throwable t) {

            }
        });
    }

    public void preencherLista() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LivroService service = retrofit.create(LivroService.class);
        Call<List<Livro>> call = service.listarLivros();
        call.enqueue(new Callback<List<Livro>>() {
            @Override
            public void onResponse(Call<List<Livro>> call, Response<List<Livro>> response) {
                final List<Livro> livros = response.body();
                listView.setAdapter(new LivroAdapter(getContext(), livros));
                listView.setOnItemClickListener(new ListView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        for (int i = 0; i < listView.getChildCount(); i++) {
                            listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);                        }
                        view.setBackgroundColor(Color.GRAY);
                        livro = livros.get(position);
                    }
                });
            }
            @Override
            public void onFailure(Call<List<Livro>> call, Throwable t) {

            }
        });
    }
}
