function validateForm() {

    var price = parseFloat(document.forms["expenseForm"]["price"].value);
    var milage = parseInt(document.forms["expenseForm"]["milage"].value, 10);

    var letters = /^[A-Za-z]+$/;

    if (!brand.match(letters)) {
        showErrorMessage();
        return false;
    }

    if (Number.isInteger(milage)) {
        if (milage < 0) {
            showErrorMessage();
            return false;
        }
    }

    if (price <= 0) {
        showErrorMessage();
        return false;
    }
}

function showErrorMessage() {
    document.getElementById("message").innerHTML = "Provide correct data!"
    document.getElementById("errorMessage").style.display = "block";
}