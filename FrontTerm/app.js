import React from 'react';
import ReactDOM from 'react-dom';
//Roster Button

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
