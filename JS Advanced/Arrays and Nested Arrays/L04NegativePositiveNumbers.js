function solve(arr = []) {
    let arrNeg = [];
    let arrPos = [];

    for (const e of arr) {
        if (e < 0) {
            arrNeg.push(e)
        } else {
            arrPos.push(e)
        }
    }
    arrNeg.reverse()
        .forEach(function (item) {
            console.log(item)
        });

    for (const a of arrPos) {
        console.log(a)

    }
}

solve([3, -2, 0, -1])