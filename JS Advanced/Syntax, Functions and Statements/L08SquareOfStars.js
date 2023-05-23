function solve(size) {

    let matrix = [];

    for (let i = 0; i < size; i++) {
        for (let j = 0; j < size; j++) {
            matrix.push('*');
        }
        matrix.push('\n');
    }
    console.log(matrix.join(' '));
}
solve(5);