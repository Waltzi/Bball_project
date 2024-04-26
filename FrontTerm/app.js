//Parsing a JSON

function parseJson(json) {
  try {
      return JSON.parse(json);
  } catch (error) {
      console.error('Error parsing JSON:', error);
      return null;
  }
}



document.getElementById('back_button').addEventListener('click', function() {
  window.location.href = 'index.html';
});

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