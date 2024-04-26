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