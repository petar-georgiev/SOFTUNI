function solve(arr = []) {
    let output = []
    for (let i = 0; i < arr.length; i += 2) {
        output.push(arr[i])
    }
    console.log(output.join(' '));
}

solve(['20', '30', '40', '50', '60'])