package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TableRepositoryImpl implements TableRepository<Table> {
    private List<Table> tables;

    public TableRepositoryImpl() {
        this.tables = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(this.tables);
    }

    @Override
    public void add(Table entity) {
        this.tables.add(entity);
    }

    @Override
    public Table byNumber(int number) {
        return this.tables.stream().filter(f -> f.getTableNumber() == number).
                findFirst().orElse(null);
    }
}
