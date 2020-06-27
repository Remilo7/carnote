function fuelChange(that) {
    if (that.value == 3) {
        document.getElementById("lpg-cap").style.display = "block";
        document.getElementById("lpg-lev").style.display = "block";
        document.getElementById("lpg-spacer").style.display = "block";
    } else {
        document.getElementById("lpg-cap").style.display = "none";
        document.getElementById("lpg-lev").style.display = "none";
        document.getElementById("lpg-spacer").style.display = "none";
    }
}

function mainTankCap(val) {
    document.getElementById("tank1").setAttribute("max", val);
}

function secTankCap(val) {
    document.getElementById("tank2").setAttribute("max", val);
}

function validateForm() {

    var brand = document.forms["vehicleForm"]["brand"].value;
    var year = parseInt(document.forms["vehicleForm"]["year"].value, 10);
    var cap1 = parseInt(document.forms["vehicleForm"]["cap1"].value, 10);
    var cap2 = parseInt(document.forms["vehicleForm"]["cap2"].value, 10);
    var milage = parseInt(document.forms["vehicleForm"]["milage"].value, 10);

    var letters = /^[A-Za-z]+$/;

    if (!brand.match(letters)) {
        showErrorMessage();
        return false;
    }

    var date = new Date();
    var currYear = date.getFullYear();

    if (Number.isInteger(year)) {
        if (year < 1900 || year > currYear) {
            showErrorMessage();
            return false;
        }
    }

    if (!Number.isInteger(year)) {
        showErrorMessage();
        return false;
    }

    if (!(Number.isInteger(cap1) && Number.isInteger(cap2) && Number.isInteger(milage))) {
        showErrorMessage();
        return false;
    }

    if (Number.isInteger(cap1)) {
        if (cap1 < 0) {
            showErrorMessage();
            return false;
        }
    }

    if (Number.isInteger(cap2)) {
        if (cap2 < 0) {
            showErrorMessage();
            return false;
        }
    }

    if (Number.isInteger(milage)) {
        if (milage < 0) {
            showErrorMessage();
            return false;
        }
    }
}

function hideZeros() {
    if(document.getElementById("year").value == 0.0)
        document.getElementById("year").value = null;

    if(document.getElementById("milage").value == 0.0)
        document.getElementById("milage").value = null;

    if(document.getElementById("cap1").value == 0.0)
        document.getElementById("cap1").value = null;

    if(document.getElementById("cap2").value == 0.0)
        document.getElementById("cap2").value = null;
}

function showErrorMessage() {
    document.getElementById("message").innerHTML = "Provide correct data!"
    document.getElementById("errorMessage").style.display = "block";
}