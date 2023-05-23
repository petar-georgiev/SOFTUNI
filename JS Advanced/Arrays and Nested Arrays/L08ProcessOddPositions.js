function solve(arr = []) {
    return arr
        .filter((num, i) => i % 2 === 1)
        .map(m => m * 2)
        .reverse()
        .join(' ')
}

console.log(solve([3, 0, 10, 4, 7, 3]));