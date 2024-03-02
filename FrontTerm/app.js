import React from 'react';
import ReactDOM from 'react-dom';

// Contact Form
document.getElementById("contactForm").addEventListener("submit", function(event) {

    event.preventDefault();

    // Get form values
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const message = document.getElementById("message").value;

    // Display submitted information
    alert(`Thank you, ${name}! Your Message Has Been Received.\n\nEmail: ${email}\nMessage: ${message}`);

    // Clear the form
    document.getElementById("contactForm").reset();
});

// Fetch data from the Java backend
// fetch('/data')
//   .then(response => response.json())
//   .then(data => {
//     // Process the data received from the Java backend
//     console.log(data);
//   })
//   .catch(error => {
//     console.error('Error fetching data:', error);
// });

//three point percentage calculator
function calculatePercentage() {
  // Get input values
  var made = parseInt(document.getElementById("made").value);
  var attempted = parseInt(document.getElementById("attempted").value);

  // Calculate percentage
  var percentage = (made / attempted) * 100;

  // Display result
  var resultElement = document.getElementById("result");
  if (isNaN(percentage)) {
      resultElement.textContent = "Please enter valid numbers.";
  } else {
      resultElement.textContent = "3-Point Shot Percentage: " + percentage.toFixed(2) + "%";
  }
}
