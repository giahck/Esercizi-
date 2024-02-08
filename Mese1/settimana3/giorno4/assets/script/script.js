/* genera cgriglia calendario */
const now = new Date();
const getYear = now.getFullYear();
const getMonth = now.getMonth();
console.log(now);
const appointments = [];
const monthNames = [
  "Gennaio",
  "Febraio",
  "marzo",
  "aprile",
  "maggio",
  "giugno",
  "luglio",
  "Agosto",
  "Settembre",
  "ottobre",
  "Novembre",
  "Dicembre",
];
const printCurrenMonthInH1 = () => {
  const title = document.querySelector("h1");
  const currentMonth = monthNames[getMonth];
  title.innerText = currentMonth;
};
printCurrenMonthInH1();

const dayInThisMonth = () => {
  const lastDayInTheMonth = new Date(getYear, getMonth + 1, 0);
  const numberOfTheDay = lastDayInTheMonth.getDate();
  return numberOfTheDay;
};
dayInThisMonth();

const unSelectAllDay = () => {
  const previousSelected = document.querySelector(".selected");
  if (previousSelected) {
    previousSelected.classList.remove("selected");
  }
};

const chageMeetingDaySection = (indexOfTheDay) => {
  const rightSpan = document.getElementById("newMeetingDay");
  rightSpan.classList.add("hasDay");
  rightSpan.innerText = indexOfTheDay + 1;
};

const showAppointments = (indexOfTheDay) => {
  const appointmentsForThisDay = appointments[indexOfTheDay];
  const appointmentsList = document.querySelector("#appointments ul");
  appointmentsList.innerHTML = "";
  appointmentsForThisDay.forEach((appointment) => {
    const newLi = document.createElement("li");
    newLi.innerText = appointment;
    appointmentsList.appendChild(newLi);
  });
  const appointmentsDiv = document.getElementById("appointments");
  appointmentsDiv.style.display = "block";
};

const createDays = (numberOfTheDay) => {
  const calendarDiv = document.getElementById("calendar");
  for (let i = 0; i < numberOfTheDay; i++) {
    const dayCellDiv = document.createElement("div");
    dayCellDiv.classList.add("day");
    dayCellDiv.addEventListener("click", function () {
      unSelectAllDay();
      dayCellDiv.classList.add("selected");
      chageMeetingDaySection(i);
      if (appointments[i].length > 0) {
        showAppointments(i);
      } else {
        const appointments = document.getElementById("appointments");
        appointments.style.display = "none";
      }
    });
    const cellValue = document.createElement("h3");
    cellValue.innerText = i + 1;
    dayCellDiv.appendChild(cellValue);
    calendarDiv.appendChild(dayCellDiv);
    appointments.push([]);
  }
  console.log(appointments);
};

createDays(dayInThisMonth());

const handleFormSubmit = (e) => {
  e.preventDefault();
  const selectDay = document.getElementById("newMeetingDay").innerText;
  const meetingTime = document.getElementById("newMeetingTime").value;
  const meetingName = document.getElementById('newMeetingName').value;
  const meetingString = `${meetingTime} - ${meetingName}`;
  const indiceGiorno = parseInt(selectDay) - 1;
  appointments[indiceGiorno].push(meetingString);
    const dot = document.createElement("span");
    dot.classList.add("dot");
    const selectedCell = document.querySelector(".selected");
    if (!selectedCell.querySelector(".dot")) {
    selectedCell.appendChild(dot);
  }
  showAppointments(indiceGiorno);
};
const meetingForm=document.querySelector('form');
meetingForm.addEventListener('submit',handleFormSubmit);