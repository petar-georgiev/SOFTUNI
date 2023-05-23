function solve(input) {
    let result = [];
    let townsInfo = {}

    for (let i = 0; i <= input.length + 1; i++) {
        let line = input.shift();
        if (i !== 0) {
            let [Town, Latitude, Longitude] = line.split("|").splice(1, 3);
            townsInfo[Town] = {
                Latitude: Number(Number(Latitude).toFixed(2)),
                Longitude: Number(Number(Longitude).toFixed(2))
            };
        }
    }


    return JSON.stringify(townsInfo);
}

console.log(solve([
    '| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']
));