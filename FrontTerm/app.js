function fetchData(url) {
  return fetch(url)
      .then(response => {
          if (!response.ok) {
              throw new Error('Network response was not ok');
          }
          return response.json();
      })
      .then(data => {
          // handle the data from backend 
          console.log(data);
          return data; // Optionally return the data
      })
      .catch(error => {
          // handle errors
          console.error('Error fetching data:', error);
          throw error; // rethrowing the error
      });
}

const apiUrl = 'http://localhost:5500/api/data';

fetchData(apiUrl)
    .then(data => {
        // use data from the backend
        console.log('Data received:', data);
    })
    .catch(error => {
        // handle errors
        console.error('Failed to fetch data:', error);
    });
