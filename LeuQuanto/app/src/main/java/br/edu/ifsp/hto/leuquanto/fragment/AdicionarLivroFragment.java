package br.edu.ifsp.hto.leuquanto.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import br.edu.ifsp.hto.leuquanto.R;
import br.edu.ifsp.hto.leuquanto.domain.Livro;
import br.edu.ifsp.hto.leuquanto.presenter.AdicionarLivroPresenter;
import br.edu.ifsp.hto.leuquanto.presenter.ListarLivroPresenter;

public class AdicionarLivroFragment extends Fragment {

    public AdicionarLivroFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Passo 5", "adicionarLivro");

        View view = inflater.inflate(R.layout.fragment_adicionar_livro, container, false);
        Button btSalvar = (Button) view.findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();

            }
        });
        return view;
    }

    public void salvar(){

        EditText etTitulo = (EditText) getView().findViewById(R.id.etTitulo);
        EditText etAutor = (EditText) getView().findViewById(R.id.etAutor);
        EditText etTotal = (EditText) getView().findViewById(R.id.etPaginaTotal);
        EditText etLido = (EditText) getView().findViewById(R.id.etPaginaLida);

        int lida, total;

        total = Integer.parseInt(etTotal.getText().toString());
        if(etLido.getText().toString().isEmpty())
            lida=0;
        else
            lida = Integer.parseInt(etLido.getText().toString());

        final Livro livro = new Livro();

        livro.setTitulo(etTitulo.getText().toString());
        livro.setAutor(etAutor.getText().toString());
        livro.setPaginasTotal(total);
        livro.setPaginasLidas(lida);

        if(lida > total)
            livro.setPaginasFaltando(0);
        else
            livro.setPaginasFaltando(total - lida);

        String status;
        if(lida == total){
            status = "Lido";
        }else if(lida == 0){
            status = "Lerei";
        }else{
            status = "Lendo - Falta: "+livro.getPaginasFaltando()+" páginas";
        }
        livro.setStatus(status);

        AdicionarLivroPresenter adicionarLivroPresenter = new AdicionarLivroPresenter();
        adicionarLivroPresenter.adicionarLivro(getContext(),livro);
    }

}
