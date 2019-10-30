package com.example.listviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebServices;

public class MainActivity extends AppCompatActivity implements Asynchtask {


    ListView lstOpciones;
    Noticias[] noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<String, String>();
        WebServices ws= new WebServices("https://api.androidhive.info/contacts/", datos, this, this);
        ws.execute("");

        /*

        noticias = new Noticias[]{
                    new Noticias("Noticia 1", "SubNoticia Contenido Contenido Contenido Contenido 1"),
                    new Noticias("Noticia 2", "SubNoticia Contenido Contenido Contenido Contenido 2"),
                    new Noticias("Noticia 3", "SubNoticia Contenido Contenido Contenido Contenido 3"),
                    new Noticias("Noticia 4", "SubNoticia Contenido Contenido Contenido Contenido 4")};


        AdaptadorNoticias adaptadornoticias = new AdaptadorNoticias(this, noticias);
        lstOpciones = (ListView)findViewById(R.id.lstLista);

        View header = getLayoutInflater().inflate(R.layout.ly_encabezado, null);
        lstOpciones.addHeaderView(header);

        lstOpciones.setAdapter(adaptadornoticias);
        */

    }

    @Override
    public void processFinish(String result) throws JSONException {

        Log.i("processFinish", result);

        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        JSONObject jsonObj = new JSONObject(result);
        JSONArray contacts = jsonObj.getJSONArray("contacts");

        noticias = new Noticias[contacts.length()];

        for(int i=0;i<contacts.length();i++) {
            JSONObject c = contacts.getJSONObject(i);
            String id = c.getString("id");
            String name = c.getString("name");
            String email = c.getString("email");
            String address = c.getString("address");
            String gender = c.getString("gender");

            //El nodo Phone es un objeto JSON
            JSONObject phone = c.getJSONObject("phone");
            String mobile = phone.getString("mobile");
            String home = phone.getString("home");
            String office = phone.getString("office");

            HashMap<String, String> contact = new HashMap<>();

            contact.put("id",id);
            contact.put("name",name);
            contact.put("email",email);
            contact.put("mobile",mobile);

            noticias[i] = new Noticias(name,email+" "+mobile, address);
        }

        AdaptadorNoticias adaptadornoticias = new AdaptadorNoticias(this, noticias);
        ListView lsOpciones = (ListView)findViewById(R.id.lstLista);

        View header = getLayoutInflater().inflate(R.layout.ly_encabezado, null);
        lstOpciones = (ListView)findViewById(R.id.lstLista);
        lstOpciones.addHeaderView(header);

        lsOpciones.setAdapter(adaptadornoticias);
    }
}
