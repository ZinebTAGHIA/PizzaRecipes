package pizza.zineb.ma.pizzarecipes.service;

import java.util.ArrayList;
import java.util.List;

import pizza.zineb.ma.pizzarecipes.beans.Produit;
import pizza.zineb.ma.pizzarecipes.dao.IDao;

public class ProduitService implements IDao<Produit> {

    private List<Produit> produits;
    private static ProduitService instance;

    private ProduitService() {
        this.produits = new ArrayList<>();
    }

    public static ProduitService getInstance() {
        if (instance == null) {
            instance = new ProduitService();
        }
        return instance;
    }

    @Override
    public boolean create(Produit o) {
        return produits.add(o);
    }

    @Override
    public boolean update(Produit o) {
        Produit p = findById(o.getId());
        p.setNom(o.getNom());
        p.setNbrIngredients(o.getNbrIngredients());
        p.setPhoto(o.getPhoto());
        p.setDuree(o.getDuree());
        p.setDetailsIngred(o.getDetailsIngred());
        p.setDescription(o.getDescription());
        p.setPreparation(o.getPreparation());
        return false;
    }

    @Override
    public boolean delete(Produit o) {
        return produits.remove(o);
    }

    @Override
    public List<Produit> findAll() {
        return produits;
    }

    @Override
    public Produit findById(int id) {
        for (Produit p : produits) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }
}
