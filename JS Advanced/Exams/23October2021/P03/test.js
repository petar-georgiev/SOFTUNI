const library = require('./library');
const expect = require('chai').expect;

describe('test', () => {
    describe('calcPriceOfBook', () => {
        it('throw error when incorrect name and year', () => {
            expect(() => library.calcPriceOfBook(1, 'a')).to.throw('Invalid input');
        });
        it('return price of book if equal year', () => {
            expect(library.calcPriceOfBook('harry potter', 1980)).to.equal(`Price of harry potter is 10.00`);
        });
        it('return price of book if below year', () => {
            expect(library.calcPriceOfBook('harry potter', 1979)).to.equal(`Price of harry potter is 10.00`);
        });
        it('return price of new books', () => {
            expect(library.calcPriceOfBook('harry potter', 2020)).to.equal(`Price of harry potter is 20.00`);
        });
    })

    describe('findBook', () => {
        it('throw error when no books', () => {
            expect(() => library.findBook([], "a")).to.throw('No books currently available');
        })
        it('return output if found book', () => {
            let booksArray = ['harry potter', 'java advanced']
            expect(library.findBook(booksArray, 'java advanced')).to.equal('We found the book you want.');
        })
        it('return output if not found book', () => {
            let booksArray = ['harry potter', 'java advanced']
            expect(library.findBook(booksArray, 'a'))
                .to.equal('The book you are looking for is not here!');
        })
    })

    describe('arrangeTheBooks', () => {
        it('throw error when count is not integer', () => {
            expect(() => library.arrangeTheBooks( 'a')).to.throw('Invalid input');
        });
        it('throw error when count is below zero', () => {
            expect(() => library.arrangeTheBooks( -1)).to.throw('Invalid input');
        });
        it('return output if count below availableSpace', () => {
            expect(library.arrangeTheBooks( 9)).to.equal('Great job, the books are arranged.');
        });
        it('return output if count bigger than availableSpace', () => {
            expect(library.arrangeTheBooks( 41)).to.equal('Insufficient space, more shelves need to be purchased.');
        });
    })
})