class SummerCamp{

    constructor(organizer, location) {
        this.organizer = organizer;
        this.location = location;
        this.priceForTheCamp = {
            child: 150,
            student: 300,
            collegian: 500
        }
        this.listOfParticipants = [];
    }

    registerParticipant(name, condition, money){

        let participant = {
            name,
            condition,
            money
        }
        if(!this.priceForTheCamp.includes(condition)){
            throw new Error('Unsuccessful registration at the camp.');
        }

        if(this.listOfParticipants.includes(name)){
            return `The ${name} is already registered at the camp.`;
        }

        this.listOfParticipants.push(participant);
    }

    unregisterParticipant(name){

    }

    timeToPlay (typeOfGame, participant1, participant2){

    }

    toString(){

    }

}
const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
console.log(summerCamp.registerParticipant("Petar Petarson", "student", 200));
console.log(summerCamp.registerParticipant("Petar Petarson", "children", 300));
console.log(summerCamp.registerParticipant("Petar Petarson", "collegian", 400));
