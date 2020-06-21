function validateForm() {

    var price = document.forms["expenseForm"]["price"].value;
    var milage = document.forms["expenseForm"]["milage"].value;

    if (milage == "" || milage==null) {
        showErrorMessage(1);
        return false;
    }

    else {
        milage = parseInt(milage, 10);
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

function hideZeros() {
    if(document.getElementById("price").value == 0.0)
        document.getElementById("price").value = null;

    if(document.getElementById("milage").value == 0.0)
        document.getElementById("milage").value = null;
}

function addDot(txt) {
    txt.value = txt.value.replace(".", "").replace(/(\d+)(\d{2})/, "$1.$2");
}