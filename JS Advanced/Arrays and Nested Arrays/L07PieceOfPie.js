function solve(arr = [], first, last) {
    return arr.slice(arr.indexOf(first), arr.indexOf(last) + 1)
}

console.log(solve(['Pumpkin Pie',
        'Key Lime Pie',
        'Cherry Pie',
        'Lemon Meringue Pie',
        'Sugar Cream Pie'],
    'Key Lime Pie',
    'Lemon Meringue Pie'
))