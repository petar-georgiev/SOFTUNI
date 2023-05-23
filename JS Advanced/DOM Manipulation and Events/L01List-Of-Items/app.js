function addItem() {
    let input = document.getElementById('newItemText').value;
   const liElement = document.createElement('li')
    liElement.textContent = input;
   document.getElementById('items').appendChild(liElement);
}