import React from 'react';
import ReactDOM from 'react-dom';

fetch('http://localhost:5500/api/data')
  .then(response => response.json())
  .then(data => {
    // Handle the data received from the backend
    console.log(data);
  })
  .catch(error => {
    // Handle any errors that occur during the request
    console.error('Error fetching data:', error);
  });
