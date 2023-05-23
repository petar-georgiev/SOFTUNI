function solve() {
    const output = document.querySelector('textarea');

    document.querySelector('.shopping-cart').addEventListener('click', onClick)

    function onClick(ev) {
        if(ev.target.className === 'add-product'){
            const product = ev.target.parentNode.parentNode;
            const title  = product.querySelector('.product-title').textContent;
            const price = Number(product.querySelector('.product-line-price').textContent);
            output.value += `Added ${title} for ${price.toFixed(2)} to the cart.\n`;
        }
    }
}