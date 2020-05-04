function validateForm() {

    var price = parseFloat(document.forms["fuelExpenseForm"]["price"].value);
    var milage = parseInt(document.forms["fuelExpenseForm"]["milage"].value, 10);
    var litres = parseFloat(document.forms["fuelExpenseForm"]["litres"].value);

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

    else {
        showErrorMessage();
        return false;
    }

    if(!isNaN(price)) {
        if (price <= 0) {
            showErrorMessage();
            return false;
        }
    }

    else {
        showErrorMessage();
        return false;
    }

    if(!isNaN(litres)) {
        if (litres < 0) {
            showErrorMessage();
            return false;
        }
    }

    else {
        showErrorMessage();
        return false;
    }
}

function showErrorMessage() {
    document.getElementById("message").innerHTML = "Provide correct data!"
    document.getElementById("errorMessage").style.display = "block";
}

function addDot(txt) {
    txt.value = txt.value.replace(".", "").replace(/(\d+)(\d{2})/, "$1.$2");
}