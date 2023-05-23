function solve(arr) {

    let sum = 0;
    let inverseSum = 0.0;
    let concat = [];

    for (let i = 0; i < arr.length; i++) {
        sum += arr[i];
        inverseSum += 1 / arr[i];
        concat.push(arr[i]);
    }
    console.log(sum);
    console.log(inverseSum);
    console.log(concat.join(''));
}

solve([2, 4, 8, 16])