function sumTable() {
    let rows = document.querySelectorAll('table tr');
    let result = 0;
    for (let i = 1; i < rows.length - 1; i++) {
        let cols = rows[i].children;
        result += Number(cols[cols.length - 1].textContent);
    }
    document.getElementById('sum').textContent = result;
}