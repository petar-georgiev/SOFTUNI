const dealership = require('./dealershipCode');
const expect = require('chai').expect;

describe('test', () => {
    describe('newCarCost', () => {
        it('returns original price when model unsuported', () => {
            expect(dealership.newCarCost('a', 1)).to.equal(1);
        });

        it('returns discounted price when model unsuported', () => {
            expect(dealership.newCarCost('Audi A4 B8', 30000)).to.equal(15000);
        });
    });
    describe('carEquipment', () => {
        it('single element, single pick', () => {
            expect(dealership.carEquipment(['a'], [0])).deep.equal(['a']);
        });
        it('single element, single pick', () => {
            expect(dealership.carEquipment(['a', 'b', 'c'], [0, 2])).deep.equal(['a', 'c']);
        });
    });

    describe('euroCategory', () => {
        it('category is below threshold', () => {
            expect(dealership.euroCategory(1)).to.equal('Your euro category is low, so there is no discount from the final price!');
        });
        it('category is upper threshold', () => {
            expect(dealership.euroCategory(5)).to.equal(`We have added 5% discount to the final price: 14250.`);
        });
        it('category is equal to threshold', () => {
            expect(dealership.euroCategory(4)).to.equal(`We have added 5% discount to the final price: 14250.`);
        });
    });
})