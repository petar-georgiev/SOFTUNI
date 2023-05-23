function solve() {
    let textAreaElement = document.getElementById('input');
    let text = textAreaElement.value;

    let sentences = text.split('.').filter(f => f !== '').map(x => x + '.');

    let resultDiv = document.getElementById('output');

    let paragraph = Math.ceil(sentences.length/3);

    for (let i = 0; i < paragraph; i++) {
        resultDiv.innerHTML += `<p>${sentences.splice(0,3).join('')}</p>`;
    }
}