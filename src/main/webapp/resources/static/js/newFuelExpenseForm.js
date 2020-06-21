function validateForm() {

    var price = document.forms["fuelExpenseForm"]["price"].value;
    var milage = document.forms["fuelExpenseForm"]["milage"].value;
    var litres = document.forms["fuelExpenseForm"]["litres"].value;

    if (milage == "" || milage==null) {
        showErrorMessage(1);
        return false;
    }

    else {
        milage = parseFloat(milage);
    }

    if (Number.isInteger(milage)) {
        if (milage < 0) {
            showErrorMessage(2);
            return false;
        }
    }

    else {
        showErrorMessage(2);
        return false;
    }

    if (price == "" || price==null) {
        showErrorMessage(1);
        return false;
    }

    else {
        price = parseFloat(price);
    }

    if(!isNaN(price)) {
        if (price <= 0) {
            showErrorMessage(2);
            return false;
        }
    }

    else {
        showErrorMessage(2);
        return false;
    }

    if (litres == "" || litres==null) {
        showErrorMessage(1);
        return false;
    }

    else {
        price = parseFloat(litres);
    }

    if(!isNaN(litres)) {
        if (litres < 0) {
            showErrorMessage(2);
            return false;
        }
    }

    else {
        showErrorMessage(2);
        return false;
    }
}

function hideZeros() {
    if(document.getElementById("price").value == 0.0)
        document.getElementById("price").value = null;

    if(document.getElementById("milage").value == 0.0)
        document.getElementById("milage").value = null;

    if(document.getElementById("litres").value == 0.0)
        document.getElementById("litres").value = null;
}

function showErrorMessage(x) {

    let mes;

    if (x==1)
        mes = "Provide data!";
    else if (x==2)
        mes = "Provide correct data!";

    document.getElementById("message").innerHTML = mes;
    document.getElementById("errorMessage").style.display = "block";
}

function addDot(txt) {
    txt.value = txt.value.replace(".", "").replace(/(\d+)(\d{2})/, "$1.$2");
}