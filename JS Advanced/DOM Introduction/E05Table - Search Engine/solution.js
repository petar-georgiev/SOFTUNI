function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);

    function onClick() {
        const input = document.querySelector('#searchField').value.toLowerCase();
        const rows = document.querySelectorAll('tbody tr')

        for (const row of rows) {
            if(row.textContent.toLowerCase().includes(input)){
                row.setAttribute('class','select');
            }else {
                row.removeAttribute('class');
            }
        }
    }
}