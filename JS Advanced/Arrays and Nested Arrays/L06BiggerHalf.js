function solve(arr = []) {
    return arr.sort((a, b) => a - b)
        .slice(arr.length / 2, arr.length)
}

console.log(solve([3, 19, 14, 7, 2]));