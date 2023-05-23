function extractText() {
    let listElement = document.querySelectorAll('#items li');

    let result = '';

    for (const listItem of listElement) {
        result += listItem.textContent.trim() + '\n';
    }
    let resultElement = document.getElementById('result');
    resultElement.textContent = result.trim();
}