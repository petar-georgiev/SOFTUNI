package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.common.enums.HealthyFoodType;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import java.sql.Driver;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double allPrice;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
        this.allPrice = 0.0;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food = this.healthFoodRepository.foodByName(name);
        if (food != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST,
                    food.getName()));
        }
        if (type.equals("Salad")) {
            food = new Salad(name, price);
        } else if (type.equals("VeganBiscuits")) {
            food = new VeganBiscuits(name, price);
        }
        this.healthFoodRepository.add(food);
        return String.format(OutputMessages.FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages drink = this.beverageRepository.beverageByName(name, brand);
        if (drink != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST,
                    drink.getName()));
        }
        if (type.equals("Fresh")) {
            drink = new Fresh(name, counter, brand);
        } else if (type.equals("Smoothie")) {
            drink = new Smoothie(name, counter, brand);
        }
        this.beverageRepository.add(drink);
        return String.format(OutputMessages.BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = this.tableRepository.byNumber(tableNumber);
        if (table != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_EXIST,
                    tableNumber));
        }
        if (type.equals("Indoors")) {
            table = new Indoors(tableNumber, capacity);
        } else if (type.equals("InGarden")) {
            table = new InGarden(tableNumber, capacity);
        }
        this.tableRepository.add(table);
        return String.format(OutputMessages.TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        for (Table table : this.tableRepository.getAllEntities()) {
            if (!table.isReservedTable() && table.getSize() >= numberOfPeople) {
                table.reserve(numberOfPeople);
                return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
            }
        }
        return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = this.tableRepository.byNumber(tableNumber);

        if (table == null || !table.isReservedTable()) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        HealthyFood food = this.healthFoodRepository.foodByName(healthyFoodName);
        if (food == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);
        }
        table.orderHealthy(food);

        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL,healthyFoodName,tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = this.tableRepository.byNumber(tableNumber);

        if (table == null || !table.isReservedTable()) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        Beverages drink = this.beverageRepository.beverageByName(name,brand);
        if (drink == null) {
            return String.format(OutputMessages.NON_EXISTENT_DRINK, name,brand);
        }
        table.orderBeverages(drink);

        return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL,name,tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = this.tableRepository.byNumber(tableNumber);
        double bill = table.bill();
        this.allPrice += bill;
        table.clear();
        return String.format(OutputMessages.BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        //TODO:
        return String.format(OutputMessages.TOTAL_MONEY, this.allPrice);
    }
}
