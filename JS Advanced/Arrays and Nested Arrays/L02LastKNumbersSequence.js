function solve(n, k) {
    let arr = [];
    arr[0] = 1;

    for (let i = 1; i < n; i++) {
        let sum = 0;
        let startIndex = Math.max(0, i - k);
        for (let j = startIndex; j < i; j++) {
            sum += arr[j];
        }
        arr.push(sum)
    }
    return arr
}

console.log(solve(6,3))