function solve(num1, num2, operation) {
    let result = 0
    switch (operation) {
        case '+':
            result = num1 + num2
            break
        case '-':
            result = num1 - num2
            break
        case '/':
            result = num1 / num2
            break
        case '*':
            result = num1 * num2
            break
        case '%':
            result = num1 % num2
            break
        case '**':
            result = num1 ** num2
            break
    }
    console.log(result)
}
solve(3, 5.5, '*')