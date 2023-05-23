function solve(number, ...operation) {
    let operations = operation

    function action(op, number) {
        switch (op) {
            case 'chop':
                return number /= 2
                break
            case 'dice':
                return number = Math.sqrt(number)
                break
            case 'spice':
                return number += 1
                break
            case 'bake':
                return number *= 3
                break
            case 'fillet':
                let result = number *= 0.8
                return result.toFixed(1)
                break
        }
    }

    for (let op of operations) {
        console.log(number = action(op, parseInt(number)))

    }
}

solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet')