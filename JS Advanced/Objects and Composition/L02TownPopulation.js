function solve(input) {

    const towns = {}


    for (const townAsString of input) {
        let [name, population] = townAsString.split(' <-> ')
        population = Number(population)

        if (towns[name] !== undefined) {
            population += towns[name]
        }
        towns[name] = population
    }
    for (let [name, population] of Object.entries(towns)) {
        console.log(`${name} : ${towns[name]}`)
    }
}

solve(['Istanbul <-> 100000',
    'Honk Kong <-> 2100004',
    'Jerusalem <-> 2352344',
    'Mexico City <-> 23401925',
    'Istanbul <-> 1000']
)