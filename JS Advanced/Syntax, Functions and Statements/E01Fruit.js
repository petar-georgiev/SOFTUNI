function solve(fruit, weightInGrams, pricePerKilo) {

    let weightInKilo = weightInGrams / 1000.00;
    let money = weightInKilo * pricePerKilo;

    console.log('I need $%s to buy %s kilograms %s.',
        money.toFixed(2),
        weightInKilo.toFixed(2),
        fruit);
}

solve('orange', 2500, 1.80);