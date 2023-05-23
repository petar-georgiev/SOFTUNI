function createCard(face, suit) {
const faces = ['2','3','4','5','6','7','8','9','10','J','Q','K','A'];
    const suits = {
        'S': '\u2660',
        'H': '\u2665',
        'D': '\u2666',
        'C': '\u2663',
    };

    if (Object.keys(suits).includes(suit) === false) {
        throw new Error('Invalid suit: ' + suit);
    }

    if(faces.includes(face) === false){
        throw new Error('Invalid face: ' + face);
    }


    return {
        face,
        suit: suits[suit],
        toString() {
            return this.face + this.suit;
        }
    };
}

const card1 = createCard('A', 'S');
const card3 = createCard('10', 'H');
const card4 = createCard('1', 'C');
const card5 = createCard('9', 'Y');

console.log(card1.toString());
console.log(card3.toString());
console.log(card4.toString());
console.log(card5.toString());
