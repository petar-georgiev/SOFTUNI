function solve(steps, footprintInMeters, speed) {

    let distanceToWalkInMeters = steps * footprintInMeters
    let breakTimeInSec = (Math.trunc(distanceToWalkInMeters / 500)) * 60;
    let distanceToWalkInKilometers = distanceToWalkInMeters / 1000;
    let allTime = (distanceToWalkInKilometers / speed) * 3600 + breakTimeInSec;
    let hours = Math.trunc(allTime / 3600)
    let minutes = Math.trunc((allTime % 3600) / 60)
    let seconds = Math.ceil(allTime % 60)
    let strTime = hours.toString().padStart(2, '0') + ':'
        + minutes.toString().padStart(2, '0')
        + ':' + seconds.toString().padStart(2, '0');
    console.log(strTime)
}

solve(2564, 0.70, 5.5)