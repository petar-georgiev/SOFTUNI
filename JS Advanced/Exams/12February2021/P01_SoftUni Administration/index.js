function solve() {
    let buttonElement = document.querySelector('.admin-view .action button');

    buttonElement.addEventListener('click', (e) => {
        e.preventDefault();
        let lectureNameElement = document.querySelector('input[name = "lecture-name"]');
        let lectureDataElement = document.querySelector('input[name = "lecture-date"]');
        let lectureModuleElement = document.querySelector('select[name = "lecture-module"]');


        let lectureElement = createLecture(lectureNameElement.value, lectureDataElement.value);
        let moduleElement = createModule(lectureModuleElement.value, lectureElement);

        let modulesElement = document.querySelector('.modules');
        modulesElement.appendChild(moduleElement);
    });

    function createModule(name, lectureElement) {
        let divElement = document.createElement('div');
        divElement.classList.add('module');

        let headingElement = document.createElement('h3');
        headingElement.textContent = `${name.toUpperCase()}-MODULE`;

        let lectureListElement = document.createElement('ul');
        lectureListElement.appendChild(lectureElement);

        divElement.appendChild(headingElement);
        divElement.appendChild(lectureListElement);

        return divElement;
    }

    function createLecture(name, date) {


        let liElement = document.createElement("li");
        liElement.classList.add('flex');
        let courseHeadingElement = document.createElement('h4');
        courseHeadingElement.textContent = `${name} - ${formatDate(date)}`

        let deleteButtonElement = document.createElement('button');
        deleteButtonElement.classList.add('red');
        deleteButtonElement.textContent = 'Del'

        deleteButtonElement.addEventListener('click', (e) => {
            e.currentTarget.closest('.module').remove();
        })

        liElement.appendChild(courseHeadingElement);
        liElement.appendChild(deleteButtonElement);

        return liElement;

    }

    function formatDate(dateInput) {
        let [date, time] = dateInput.split('T');
        date = date.replace(/-/g, '/');
        return `${date} - ${time}`;
    }
};
