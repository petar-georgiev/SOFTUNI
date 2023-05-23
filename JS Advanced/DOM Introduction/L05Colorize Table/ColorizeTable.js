function colorize() {
    let rows = document.querySelectorAll("table tr:nth-of-type(2n)")
    for (const row of rows) {
        row.style.backgroundColor = "teal";
    }
}