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

// Function to fetch data from API
async function fetchData(pageId) {
  const apiUrl = `http://localhost:8080/basketball_api/${pageId}`;
  const response = await fetch(apiUrl);
  if (!response.ok) {
      throw new Error(data.message || 'Failed to fetch data');
  }
  const data = await response.json();
  return data;
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
