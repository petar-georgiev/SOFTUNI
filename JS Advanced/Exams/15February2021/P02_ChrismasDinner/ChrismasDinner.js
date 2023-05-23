class ChrismasDinner {
    constructor(budjet) {
        this.budget = budjet;
        this.products = [];
        this.guests = {};
    }

    set budget(value) {
        if(value < 0){
            throw new Error('The budget cannot be a negative number')
        }
        this._budget = value;
    }

    get budget() {
        return this._budget;
    }

    shopping([name, price]) {

    }

    inviteGuests(name, dish) {

    }

    showAttendance() {

    }
}

const myDinner = new ChrismasDinner(-1);
console.log(myDinner.budget);