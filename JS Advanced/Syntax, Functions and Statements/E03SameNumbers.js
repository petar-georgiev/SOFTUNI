function solve(number) {
    let numStr = number.toString()
    let first = numStr.charAt(1)
    let firstAsInt = parseInt(first);
    let flag = true
    let sum = 0;


    for (let i = 0; i < numStr.length; i++) {
        sum += parseInt(numStr.charAt(i))
        let nextNum = parseInt(numStr.charAt(i + 1))
        if (nextNum < firstAsInt || nextNum > firstAsInt) {
            flag = false
        }
    }
    console.log(flag)
    console.log(sum)
}

solve(2222222);