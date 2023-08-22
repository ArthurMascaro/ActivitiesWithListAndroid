package com.example.exercise3bim.src.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.exercise3bim.R;

import java.util.ArrayList;

public class AdapterProdutos extends ArrayAdapter<Produto> {

    private Context context;

    private ArrayList<Produto> produtos;

    public AdapterProdutos(Context context, ArrayList<Produto> produtos) {
        super(context, R.layout.product_list_item, produtos);
        this.context = context;
        this.produtos = produtos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());

        View itemView = li.inflate(R.layout.product_list_item, parent, false);

        TextView lblName = itemView.findViewById(R.id.lblNome2);
        TextView lblBrand = itemView.findViewById(R.id.lblMarca2);
        TextView lblQuantity = itemView.findViewById(R.id.lblQnt2);
        TextView lblStatus = itemView.findViewById(R.id.lblStatus);

        lblName.setText(produtos.get(position).getName());
        lblBrand.setText(produtos.get(position).getBrand());
        lblQuantity.setText(String.valueOf(produtos.get(position).getQuantity()));
        lblStatus.setText(produtos.get(position).isSold() ? "COMPRADO" : "A VENDA");

        return itemView;
    }
}
