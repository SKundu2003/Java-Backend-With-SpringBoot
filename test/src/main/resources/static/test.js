function storeInput() {
    var input = document.getElementById("inputField").value;
    alert(typeof input)
    alert("Hello " + input + "!");
}
function sendInput() {
    const input = document.getElementById("inputField").value;
    const url = 'http://localhost:8080/api'; // Replace with your API endpoint

    fetch(url, {
        method: 'POST',
        body: JSON.stringify({inputField: inputField}),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.error(error));
}
