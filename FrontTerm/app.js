import { useEffect, useState } from 'react';
import React, { useEffect, useState } from 'react';

// React NavBar component
function NavBar() {
  return (
      <nav className="NavBar">
          <h1 className="left-align">Moravian University Women's Basketball</h1>
      </nav>
  );
}

// React Home component buttons for navigation
function Home() {
  const handleButtonClick = (pageUrl) => {
    window.location.href = pageUrl; // Navigate to the specfic page URL
};
  return (
      <section id="home">
          <div className="img">
              <img src="images/moravianlogo.jpeg" alt="Moravian Logo" />
          </div>
          <button onClick={() => handleButtonClick('roster.html')}>Roster</button>
          <button onClick={() => handleButtonClick('threepoint.html')}>3-Pointers</button>
          <button onClick={() => handleButtonClick('freethrow.html')}>Free Throws</button>
      </section>
  );
}

//Parsing a JSON
function parseJson(json) {
  try {
      return JSON.parse(json);
  } catch (error) {
      console.error('Error parsing JSON:', error);
      return null;
  }
}

//function to display data
async function fetchData(apiUrl) {
  try {
    const response = await fetch(apiUrl);
    if (!response.ok) {
      throw new Error('Failed to fetch data');
    }
    const jsonData = await response.text();
    const parsedData = parseJson(jsonData); // Parse JSON response

    console.log('Parsed Data:', parsedData);
    return parsedData;
  } catch (error) {
    console.error('Error fetching data:', error);
    throw error;
  }
}

function DataDisplay() {
  const [data, setData] = useState(null);

  useEffect(() => {
    const apiUrl = 'http://localhost:8080/basketball_api/getPlayers';
    fetchData(apiUrl)
      .then((parsedData) => {
        setData(parsedData); // Set parsed data in component state
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
  }, []); // Run once on component mount

  return (
    <section id="data">
      <h2>Data</h2>
      {data ? (
        <pre>{JSON.stringify(data, null, 2)}</pre>
      ) : (
        <p>Loading data...</p>
      )}
    </section>
  );
}
  export default dataDisplay;

//this is code for fetching data from API

// Function to fetch data from API at the RequestMapping
async function fetchData() {
  try {
      const response = await fetch('http://localhost:8080/basketball_api/getPlayers');
      if (!response.ok) {
          throw new Error('Failed to fetch players');
      }
      const players = await response.json();
      console.log('Players:', players);
      return players;
  } catch (error) {
      console.error('Error fetching players:', error);
      throw error;
  }
}

// Function to add a player to the API
async function addPlayer(player) {
  try {
      const response = await fetch('http://localhost:8080/basketball_api/addPlayer', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(player)
      });
      if (!response.ok) {
          throw new Error('Failed to add player');
      }
      const addedPlayer = await response.json();
      console.log('Added player:', addedPlayer);
      return addedPlayer;
  } catch (error) {
      console.error('Error adding player:', error);
      throw error;
  }
}

//Function to edit a player in the API
async function editPlayer(player) {
  try {
      const response = await fetch('http://localhost:8080/basketball_api/editPlayer', {
          method: 'PUT',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(player)
      });
      if (!response.ok) {
          throw new Error('Failed to edit player');
      }
      const editedPlayer = await response.json();
      console.log('Edited player:', editedPlayer);
      return editedPlayer;
  } catch (error) {
      console.error('Error editing player:', error);
      throw error;
  }
}

// Funtion to add a freethrow to the API
async function addFreeThrow(freeThrow) {
  try {
      const response = await fetch('http://localhost:8080/basketball_api/addFreeThrow', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },  
          body: JSON.stringify(freeThrow)
      });
      if (!response.ok) {
          throw new Error('Failed to add free throw');
      }
      const addedFreeThrow = await response.json();
      console.log('Added free throw:', addedFreeThrow);
      return addedFreeThrow;
  } catch (error) {
      console.error('Error adding free throw:', error);
      throw error;
  }
}

// Function to edit a freethrow in the API
async function editFreeThrow(freeThrow) {
  try {
      const response = await fetch('http://localhost:8080/basketball_api/editFreeThrow', {
          method: 'PUT',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(freeThrow)
      });
      if (!response.ok) {
          throw new Error('Failed to edit free throw');
      }
      const editedFreeThrow = await response.json();
      console.log('Edited free throw:', editedFreeThrow);
      return editedFreeThrow;
  } catch (error) {
      console.error('Error editing free throw:', error);
      throw error;
  }
}

// Function to add a 3-pointer to the API
async function addThreePointer(threePointer) {
  try {
      const response = await fetch('http://localhost:8080/basketball_api/addThreePointer', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(threePointer)
      });
      if (!response.ok) {
          throw new Error('Failed to add 3-pointer');
      }
      const addedThreePointer = await response.json();
      console.log('Added 3-pointer:', addedThreePointer);
      return addedThreePointer;
  } catch (error) {
      console.error('Error adding 3-pointer:', error);
      throw error;
  }
}

// Function to edit a 3-pointer in the API
async function editThreePointer(threePointer) {
  try {
      const response = await fetch('http://localhost:8080/basketball_api/editThreePointer', {
          method: 'PUT',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(threePointer)
      });
      if (!response.ok) {
          throw new Error('Failed to edit 3-pointer');
      }
      const editedThreePointer = await response.json();
      console.log('Edited 3-pointer:', editedThreePointer);
      return editedThreePointer;
  } catch (error) {
      console.error('Error editing 3-pointer:', error);
      throw error;
  }
}

// Function to handle button click events and update state
async function handleButtonClick(pageId) {
  try {
      const data = await fetchData(pageId);
      ReactDOM.render(
          <React.Fragment>
              <NavBar />
              <Home />
              <DataDisplay data={data} />
          </React.Fragment>,
          document.getElementById('root')
      );
  } catch (error) {
      console.error(`Failed to fetch data for ${pageId}:`, error);
  }
}

// Initial render
ReactDOM.render(
  <React.Fragment>
      <NavBar />
      <Home />
  </React.Fragment>,
  document.getElementById('root')
);
