function solve(currentSpeed, type) {

    let allowedSpeed;

    function output(currentSpeed, type, allowedSpeed) {
        function description(currentSpeed, allowedSpeed) {
            let speeding = currentSpeed - allowedSpeed;
            if (speeding <= 20) {
                return 'speeding'
            } else if (speeding > 20 && speeding <= 40) {
                return 'excessive speeding'
            } else {
                return 'reckless driving '
            }
        }

        if (currentSpeed <= allowedSpeed) {
            console.log('Driving %d km/h in a %d zone',
                currentSpeed, allowedSpeed)
        } else {
            console.log('The speed is %d km/h faster than the allowed speed of %d - %s'
                , currentSpeed - allowedSpeed, allowedSpeed, description(currentSpeed, allowedSpeed))

        }
    }

    switch (type) {
        case 'motorway':
            allowedSpeed = 130
            output(currentSpeed, type, allowedSpeed)
            break
        case 'interstate':
            allowedSpeed = 90
            output(currentSpeed, type, allowedSpeed)
            break
        case 'city':
            allowedSpeed = 50
            output(currentSpeed, type, allowedSpeed)
            break
        case 'residential':
            allowedSpeed = 20
            output(currentSpeed, type, allowedSpeed)
            break
    }
}

solve(200, 'motorway')