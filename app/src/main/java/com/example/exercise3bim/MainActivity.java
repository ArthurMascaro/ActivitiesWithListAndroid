package com.example.exercise3bim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.exercise3bim.src.model.AdapterProdutos;
import com.example.exercise3bim.src.model.Produto;

import java.util.ArrayList;

// Arthur Mascaro e Gustavo Trizotti

public class MainActivity extends AppCompatActivity {

    private ListView listaProdutos;
    private Button btnAddProduto;
    private AdapterProdutos adaptador;

    private ArrayList<Produto> produtos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaProdutos = findViewById(R.id.listaProdutos);
        btnAddProduto = findViewById(R.id.btnAddProduct);

        adaptador = new AdapterProdutos(this, produtos);
        listaProdutos.setAdapter(adaptador);

        btnAddProduto.setOnClickListener(new EscutadorBotao());

        EscutadorLista el = new EscutadorLista();
        listaProdutos.setOnItemClickListener( el );
        listaProdutos.setOnItemLongClickListener( el );

    }

    private class EscutadorBotao implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(MainActivity.this, AddProductActivity.class);
            startActivityForResult(i, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( resultCode == RESULT_OK ) {
            String name = data.getStringExtra("name");
            String brand = data.getStringExtra("brand");
            int quantity = data.getIntExtra("quantity", 0);
            boolean status = false;
            Produto p = new Produto(name, brand, quantity, status);
            produtos.add(p);
            adaptador.notifyDataSetChanged();
        }
    }

    private class EscutadorLista implements AdapterView.OnItemClickListener,
            AdapterView.OnItemLongClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Produto produto = produtos.get(i);

            if (produto.isSold()){
                produto.setSold(false);
            } else {
                produto.setSold(true);
            }
            adaptador.notifyDataSetChanged();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            produtos.remove(i);

            adaptador.notifyDataSetChanged();

            Toast.makeText(MainActivity.this, "Item apagado!", Toast.LENGTH_LONG).show();
            return true;
        }
    }
}
