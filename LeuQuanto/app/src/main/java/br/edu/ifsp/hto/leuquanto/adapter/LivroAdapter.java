package br.edu.ifsp.hto.leuquanto.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.ifsp.hto.leuquanto.R;
import br.edu.ifsp.hto.leuquanto.domain.Livro;

public class LivroAdapter extends BaseAdapter {

    private final Context context;
    private final List<Livro> livros;

    public LivroAdapter(Context context, List<Livro> livros) {
        this.context = context;
        this.livros = livros;
    }

    @Override
    public int getCount() {
        return livros != null ? livros.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return livros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return livros.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_livro, parent, false);

        TextView tvLivro = (TextView) view.findViewById(R.id.tvTitulo);
        TextView tvAutor = (TextView) view.findViewById(R.id.tvAutor);
        TextView tvStatus = (TextView) view.findViewById(R.id.tvStatus);

        Livro livro = livros.get(position);

        tvLivro.setText(livro.getTitulo());
        tvAutor.setText(livro.getAutor());
        String status;

        if(livro.getStatus().equals("Lendo")){
            status = livro.getStatus()+" - Falta: "+livro.getPaginasFaltando()+" páginas";
        }else{
            status = livro.getStatus();
        }
        tvStatus.setText(status);

        return view;
    }
}
