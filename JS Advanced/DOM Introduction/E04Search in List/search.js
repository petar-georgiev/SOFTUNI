function search() {
    let inputName = document.getElementById('searchText').value;
    let listOfTowns = document.querySelectorAll('#towns>li');
    let matches = 0;

    for (const listOfTown of listOfTowns) {
        if (listOfTown.textContent.includes(inputName)) {
            listOfTown.style.fontWeight = 'bold' ;
            listOfTown.style.textDecoration = 'underline' ;

            matches++;
        }
    }
    document.getElementById('result').textContent = `${matches} matches found`
    document.getElementById('searchText').value = ''
}
