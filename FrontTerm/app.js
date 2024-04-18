// React NavBar component
function NavBar() {
  return (
      <nav className="NavBar">
          <h1 className="left-align">Moravian Women's Basketball</h1>
      </nav>
  );
}

// React Home component
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

// React component display fetched data
function DataDisplay({ data }) {
  return (
      <div id="dataDisplay">
          <h2>Data Display</h2>
          <pre>{JSON.stringify(data, null, 2)}</pre>
      </div>
  );
}

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

// Function to delete a player from the API
async function deletePlayer(playerId) {
  try {
      const response = await fetch(`http://localhost:8080/basketball_api/deletePlayer/${playerId}`, {
          method: 'DELETE'
      });
      if (!response.ok) {
          throw new Error('Failed to delete player');
      }
      const deletedPlayer = await response.json();
      console.log('Deleted player:', deletedPlayer);
      return deletedPlayer;
  } catch (error) {
      console.error('Error deleting player:', error);
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
