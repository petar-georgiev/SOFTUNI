const jsonData = `[{
    "id": "1",
    "first_name": "Ardine",
    "last_name": "Bassam",
    "email": "abassam0@cnn.com",
    "gender": "Female"
  }, {
    "id": "2",
    "first_name": "Kizzee",
    "last_name": "Jost",
    "email": "kjost1@forbes.com",
    "gender": "Female"
  },  
{
    "id": "3",
    "first_name": "Evanne",
    "last_name": "Maldin",
    "email": "emaldin2@hostgator.com",
    "gender": "Male"
  }]`;

function solution(string, criteria) {
    let data;
    let propName, propValue;
    if (criteria !== 'all') {
        [propName, propValue] = criteria.split('-');
    }
    try {
         data = JSON.parse(string);
    } catch {
        data = [];
    }
    return data.filter(function (i) {
        return propName
            ? i[propName] === propValue
            : true;
    });
}

const r1 = solution(jsonData, 'all');
const r2 = solution(jsonData, 'gender-Female');