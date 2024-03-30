package com.projeto.servicoviajem.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.projeto.servicoviajem.R;
import com.projeto.servicoviajem.model.Pacote;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListaPacoteAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacoteAdapter(List<Pacote> pacotes, Context context){

        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);


        TextView local = viewCriada.findViewById(R.id.text_cidade);
        local.setText(pacote.getLocal());


        //erro ao carregar imagem!!
//        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
//        Resources resources = context.getResources();
//        int idDoDrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
//        Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable);
//        imagem.setImageDrawable(drawableImagemPacote);


        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        int quantidadeDeDias = pacote.getDias();
        String diasEmTexto = "";
        if(quantidadeDeDias>1){
            diasEmTexto=quantidadeDeDias+" Dias";
        }else{
            diasEmTexto=quantidadeDeDias+" Dia";
        }
        dias.setText(diasEmTexto);


        TextView valor = viewCriada.findViewById(R.id.item_pacote_valor);
        BigDecimal precoDoPacote = pacote.getValor();
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String moedaBrasileira = formatoBrasileiro.format(precoDoPacote).replace("R$", "R$ ");
        valor.setText(moedaBrasileira);
        return viewCriada;
    }
}
