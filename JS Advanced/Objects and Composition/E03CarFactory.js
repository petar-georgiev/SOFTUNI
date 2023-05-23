function solve(car) {
    const {
        model,
        power,
        carriage,
        color,
        wheelsize
    } = car

    function getEngine(power) {
        let specification = [
            {power: 90, volume: 1800},
            {power: 120, volume: 2400},
            {power: 200, volume: 3500}
        ]
        return specification.find(el => el.power >= power);
    }

    function getCarriage(carriage, color) {
        return {
            type: carriage,
            color
        }
    }

    function getWheelSize(wheelsize) {
        let wheel = wheelsize % 2 === 0
            ? wheelsize - 1
            : wheelsize;

        return Array(4).fill(wheel, 0, 4)
    }

    return {
        model,
        engine: getEngine(power),
        carriage: getCarriage(carriage, color),
        wheelsize: getWheelSize(wheelsize)
    }
}

console.log(solve({
        model: 'VW Golf II',
        power: 90,
        color: 'blue',
        carriage: 'hatchback',
        wheelsize: 14
    }
));
