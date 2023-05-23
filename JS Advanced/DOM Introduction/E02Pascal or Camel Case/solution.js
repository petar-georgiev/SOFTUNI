function solve() {
    let input = document.getElementById('text').value;
    let currentCase = document.getElementById('naming-convention').value;

    let result = input.toLowerCase();
    let array = [];

    if (currentCase === 'Pascal Case') {
        let tokens = result.split(/\s+/gm);
        for (let i = 0; i < tokens.length; i++) {
            array.push(tokens[i].charAt(0).toUpperCase() + tokens[i].slice(1, tokens[i].length));
        }
        result = array.join("");
    } else if (currentCase === 'Camel Case') {
        let tokens = result.split(/\s+/gm);
        array.push(tokens[0]);
        for (let i = 1; i < tokens.length; i++) {
            array.push(tokens[i].charAt(0).toUpperCase() + tokens[i].slice(1, tokens[i].length));
        }
        result = array.join("");
    } else {
        result = 'Error!';
    }
    document.getElementById('result').textContent = result;
}