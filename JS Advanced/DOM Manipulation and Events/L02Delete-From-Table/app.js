function deleteByEmail() {
    const input = document.querySelector('input[name = "email"]');

    let removed = false;

    const rows = Array
        .from(document.querySelector('tbody').children)
        .filter(r => r.children[1].textContent === input.value);

    rows.forEach(r => r.remove());

    rows.length > 0
        ? document.getElementById('result').textContent = 'Deleted.'
        : document.getElementById('result').textContent = 'Not found.'

}