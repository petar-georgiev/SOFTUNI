function addItem() {
    let input = document.getElementById('newItemText').value;
    const liElement = document.createElement('li');
    liElement.textContent = input;

    const button = document.createElement('a');
    button.textContent = "[Delete]";
    button.href = '#';

    button.addEventListener('click', removeElement)

    liElement.appendChild(button);

    document.getElementById('items').appendChild(liElement);

    function removeElement(ev) {
        const parent = ev.target.parentNode;
        parent.remove();
    }
}