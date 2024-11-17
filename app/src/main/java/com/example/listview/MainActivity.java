package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String[] names = {
                "Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Hank", "Ivy", "Jack",
                "Karen", "Leo", "Mona", "Nate", "Olivia", "Paul", "Quinn", "Rachel", "Steve", "Tina"
        };
        String[] phones = {
                "123456789", "987654321", "456123789", "789456123", "321654987", "654987321",
                "159753456", "753951852", "456852147", "258369147", "147258369", "369147258",
                "789123456", "123789456", "852741963", "963258741", "741852963", "357159852",
                "159357258", "951753852"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>( // adapta el array en una lista para mostrarlos
                this, // Contexto
                android.R.layout.simple_list_item_1,
                names // datos que se muestran en el listview
        );
        ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(adapter); // asigna el adapatador al listview
        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() { //maneja los clicks del listview
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String phone = phones[position];
                String name = names[position];
                Toast.makeText(MainActivity.this, "El teléfono de " + name+ " es " +phone, Toast.LENGTH_SHORT).show();
            }
        };
        listView.setOnItemClickListener(mMessageClickedHandler);
    }
}