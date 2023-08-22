package com.example.exercise3bim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.exercise3bim.src.model.Produto;

import java.util.ArrayList;

public class AddProductActivity extends AppCompatActivity {

    private EditText txtName;
    private EditText txtBrand;
    private EditText txtQuantity;
    private Button btnAdd;
    private Button btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product2);

        txtName = findViewById(R.id.txtNome);
        txtBrand = findViewById(R.id.txtMarca);
        txtQuantity = findViewById(R.id.txtQnt);
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancela);

        btnAdd.setOnClickListener(new EscutadorBotaoAdicionar());
        btnCancel.setOnClickListener(new EscutadorBotaoCancelar());

    }

    private class EscutadorBotaoAdicionar implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String name;
            String brand;
            int quantity;

            name = txtName.getText().toString();
            brand = txtBrand.getText().toString();
            quantity = Integer.parseInt(txtQuantity.getText().toString());

            txtBrand.setText("");
            txtName.setText("");
            txtQuantity.setText("");

            Intent i = new Intent(AddProductActivity.this, MainActivity.class);
            i.putExtra("name", name);
            i.putExtra("brand", brand);
            i.putExtra("quantity", quantity);
            setResult(RESULT_OK, i);

            finish();
        }
    }

    private class EscutadorBotaoCancelar implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            txtBrand.setText("");
            txtName.setText("");
            txtQuantity.setText("");
            finish();
        }
    }

}