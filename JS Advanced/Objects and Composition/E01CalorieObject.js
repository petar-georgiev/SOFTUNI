function solve(input) {
    let result = {};

    for (let i = 1; i < input.length; i += 2) {
        result[input[i - 1]] = Number(input[i]);
    }
    console.log(result)
}

solve(['Yoghurt', '48', 'Rise', '138', 'Apple', '52'])