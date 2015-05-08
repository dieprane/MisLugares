package org.example.mislugares;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Diego_Trabajo on 07/05/2015.
 */
public class EdicionLugar extends ActionBarActivity {
    private long id;
    private Lugar lugar;
    private EditText nombre;
    private Spinner tipo;
    private EditText direccion;
    private EditText telefono;
    private EditText url;
    private EditText comentario;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        id = extras.getLong("id");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edicion_lugar);
        lugar = Lugares.elemento((int) id);
        nombre = (EditText) findViewById(R.id.t_nombre);
        nombre.setText(lugar.getNombre());
        direccion = (EditText) findViewById(R.id.t_direccion);
        direccion.setText(lugar.getDireccion());
        telefono = (EditText) findViewById(R.id.t_telefono);
        telefono.setText(Integer.toString(lugar.getTelefono()));
        url = (EditText) findViewById(R.id.t_url);
        url.setText(lugar.getUrl());
        comentario = (EditText) findViewById(R.id.t_comentario);
        comentario.setText(lugar.getComentario());
        tipo = (Spinner) findViewById(R.id.s_tipo);
        ArrayAdapter adaptador = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, TipoLugar.getNombres());
        adaptador.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);
        tipo.setAdapter(adaptador);
        tipo.setSelection(lugar.getTipo().ordinal());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edicion_lugar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.accion_cancelar:
                return true;
            case R.id.accion_guardar:
                lugar.setNombre(nombre.getText().toString());
                lugar.setTipo(TipoLugar.values()[tipo.getSelectedItemPosition()]);
                lugar.setDireccion(direccion.getText().toString());
                lugar.setTelefono(Integer.parseInt(telefono.getText().toString()));
                lugar.setUrl(url.getText().toString());
                lugar.setComentario(comentario.getText().toString());
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
