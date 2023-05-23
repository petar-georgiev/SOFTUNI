function solve(num1, num2, num3) {
    let max = 0;
    if (num1 > num2 && num1 > num3) {
        max = num1
    } else if (num2 > num1 && num2 > num3) {
        max = num2
    } else {
        max = num3
    }
    console.log('The largest number is %d.', max)
}

solve(-3, -5, -22.5)