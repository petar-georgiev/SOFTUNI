const pizzUni = require('./pizza-place');
const {expect, assert} = require('chai');

describe("Pizza place tests", () => {
    describe("makeAnOrder tests", () => {
        it('Should return confirmation message when pizza is ordered', () => {
            let order = {
                orderedPizza: 'Margaritta',
            }
            expect(pizzUni.makeAnOrder(order)).to.equal(`You just ordered ${order.orderedPizza}`);
        })
        it('Should return confirmation message when pizza and drink is ordered', () => {
            let order = {
                orderedPizza: 'Capricciosa',
                orderedDrink: 'Coke',
            }
            expect(pizzUni.makeAnOrder(order)).to.equal(`You just ordered ${order.orderedPizza} and ${order.orderedDrink}.`);
        })

        it('Should throw when there is no ordered pizza', () => {
            let order = {}

            expect(() => pizzUni.makeAnOrder(order).to.throw('You must order at least 1 Pizza to finish the order.'));
        })

        it('Should throw when there is only drink', () => {
            let order = {
                orderedDrink: 'Pepsi'
            }
            expect(() => pizzUni.makeAnOrder(order).to.throw('You must order at least 1 Pizza to finish the order.'));
        })
        it('Should throw when there is no order', () => {

            expect(() => pizzUni.makeAnOrder(order).to.throw('You must order at least 1 Pizza to finish the order.'));
        })
    });
    describe("getRemainingWork tests", () => {
        it('Should return all orders completed when one ready status is given', () => {
            let statusArr = [
                {pizzaName: 'Margaritta', status: 'ready'}
            ];
            expect(pizzUni.getRemainingWork(statusArr)).to.equal('All orders are complete!');
        });
        it('Should return all orders completed when two ready statuses are given', () => {
            let statusArr = [
                {pizzaName: 'Margaritta', status: 'ready'},
                {pizzaName: 'Vegetariana', status: 'ready'}
            ];
            expect(pizzUni.getRemainingWork(statusArr)).to.equal('All orders are complete!');
        });
        it('Should return remaining pizzas when there is one pending order', () => {
            let statusArr = [
                {pizzaName: 'Margaritta', status: 'preparing'},
                {pizzaName: 'Vegetariana', status: 'ready'}
            ];
            expect(pizzUni.getRemainingWork(statusArr)).to.equal('The following pizzas are still preparing: Margaritta.');
        });
        it('Should return remaining pizzas when there are more pending order', () => {
            let statusArr = [
                {pizzaName: 'Margaritta', status: 'preparing'},
                {pizzaName: 'Vegetariana', status: 'preparing'}
            ];
            expect(pizzUni.getRemainingWork(statusArr)).to.equal('The following pizzas are still preparing: Margaritta, Vegetariana.');
        });
    });
    describe("orderType tests", () => {
        it('Should return totalSum when type of order is Delivery', () => {
            let totalSum = 10;
            let orderType = 'Delivery';

            expect(pizzUni.orderType(totalSum, orderType)).to.equal(totalSum);
        })
    });

    describe("orderType tests", () => {
        it('Should return totalSum with discount when type of order is Carry Out', () => {
            let totalSum = 10;
            let orderType = 'Carry Out';

            expect(pizzUni.orderType(totalSum, orderType)).to.equal(9);
        })
    });

});
