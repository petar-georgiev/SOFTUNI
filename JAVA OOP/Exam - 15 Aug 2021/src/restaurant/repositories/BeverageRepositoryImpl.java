package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private List<Beverages> drinks;


    public BeverageRepositoryImpl() {
        this.drinks = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return this.drinks.stream().
                filter(f -> f.getName().equals(drinkName) && f.getBrand().equals(drinkBrand)).
                findFirst().orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(this.drinks);
    }

    @Override
    public void add(Beverages entity) {
        this.drinks.add(entity);
    }
}
