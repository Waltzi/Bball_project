// Function to fetch data from API based on pageId
async function fetchData(pageId) {
  try {
      const apiUrl = 'http://localhost:8080/basketball_api/addPlayer';
      const response = await fetch(apiUrl);
      const data = await response.json();

      return data; // Return the fetched data
  } catch (error) {
      console.error(`Error fetching data for ${pageId}:`, error);
      throw error; // Rethrow the error for handling in the calling code
  }
}

// Function to handle button click events
function handleButtonClick(pageId) {
  fetchData(pageId)
      .then(data => {
          // Display the fetched data in the corresponding div based on pageId
          const targetDiv = document.getElementById(`${pageId}Data`);
          targetDiv.innerHTML = JSON.stringify(data); // Example: Display JSON data as string
      })
      .catch(error => {
          // Handle errors if fetching data fails
          console.error(`Failed to fetch data for ${pageId}:`, error);
      });
}

// Event listeners for button clicks
document.getElementById('roster').addEventListener('click', () => {
  handleButtonClick('page1');
});

document.getElementById('threepoint').addEventListener('click', () => {
  handleButtonClick('page2');
});

document.getElementById('freethrow').addEventListener('click', () => {
  handleButtonClick('page3');
});
