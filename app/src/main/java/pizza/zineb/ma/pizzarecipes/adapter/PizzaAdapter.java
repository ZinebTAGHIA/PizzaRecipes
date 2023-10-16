package pizza.zineb.ma.pizzarecipes.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pizza.zineb.ma.pizzarecipes.R;
import pizza.zineb.ma.pizzarecipes.beans.Produit;


public class PizzaAdapter extends BaseAdapter {
    private List<Produit> produits;
    private LayoutInflater inflater;

    public PizzaAdapter(List<Produit> produits, Activity activity) {
        this.produits = produits;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return produits.size();
    }

    @Override
    public Object getItem(int position) {
        return produits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produits.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.item, null);
        TextView nom = convertView.findViewById(R.id.nom);
        TextView duree = convertView.findViewById(R.id.duree);
        TextView nbrIngred = convertView.findViewById(R.id.nbrIngred);
        ImageView image = convertView.findViewById(R.id.image);
        TextView id = convertView.findViewById(R.id.id);

        nom.setText(produits.get(position).getNom());
        duree.setText(produits.get(position).getDuree() + "");
        nbrIngred.setText(produits.get(position).getNbrIngredients() + "");
        image.setImageResource(produits.get(position).getPhoto());
        id.setText(produits.get(position).getId() + "");
        return convertView;
    }
}
