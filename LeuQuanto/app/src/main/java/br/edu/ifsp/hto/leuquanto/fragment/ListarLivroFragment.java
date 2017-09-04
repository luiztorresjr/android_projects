package br.edu.ifsp.hto.leuquanto.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.edu.ifsp.hto.leuquanto.R;
import br.edu.ifsp.hto.leuquanto.presenter.ListarLivroPresenter;

public class ListarLivroFragment extends Fragment {
    private ListView lvListar;

    public ListarLivroFragment() {
        Log.d("Passo 2", "Criar ListarLivroFragment");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("Passo 2", "onCreateView");

        View view = inflater.inflate(R.layout.fragment_listar_livro, container, false);
        ListarLivroPresenter listarLivroPresenter = new ListarLivroPresenter();

        lvListar = (ListView) view.findViewById(R.id.lvListarLivros);
        listarLivroPresenter.listarLivro(getContext(), lvListar);
        return view;
    }

}
