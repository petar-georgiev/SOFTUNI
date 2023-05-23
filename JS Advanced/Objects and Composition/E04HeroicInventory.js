function solve(input) {
    const arr = [];

    for (const el of input) {
        let split = el.split(" / ");
        arr.push(split);
    }

    const result = [];

    for (let i = 0; i < arr.length; i++) {
       let itemString = arr[i][2]
        const obj = {
            name: arr[i][0],
            level: Number(arr[i][1]),
            items: itemString
                ? itemString.split(", ")
                : []
        }
        result.push(obj);
    }
    return JSON.stringify(result);
}

console.log(solve(['Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara']
));