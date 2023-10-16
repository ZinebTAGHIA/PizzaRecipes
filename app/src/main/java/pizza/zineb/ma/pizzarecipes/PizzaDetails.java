package pizza.zineb.ma.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class PizzaDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_details);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black));
        }

        Intent intent = getIntent();
        int img = intent.getIntExtra("photo", 0);
        String n = intent.getStringExtra("nom");
        String d = intent.getStringExtra("descContent");
        String i = intent.getStringExtra("ingredContent");
        String p = intent.getStringExtra("prepContent");

        ImageView image = findViewById(R.id.photo);
        TextView nom = findViewById(R.id.nom);
        TextView desc = findViewById(R.id.descContent);
        TextView ingred = findViewById(R.id.ingredContent);
        TextView prep = findViewById(R.id.prepContent);

        image.setImageResource(img);
        nom.setText(n);
        desc.setText(d);
        ingred.setText(i);
        prep.setText(p);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.share) {
            String txt = "PizzaRecipes";
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder.from(this).setType(mimeType).setChooserTitle("PizzaRecipes").setText(txt).startChooser();
        }
        return super.onOptionsItemSelected(item);
    }
}