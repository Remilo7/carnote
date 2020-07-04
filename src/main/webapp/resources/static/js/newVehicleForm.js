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
    var year = document.forms["vehicleForm"]["year"].value;
    var cap1 = document.forms["vehicleForm"]["cap1"].value;
    var cap2 = parseInt(document.forms["vehicleForm"]["cap2"].value, 10);
    var milage = document.forms["vehicleForm"]["milage"].value;

    var letters = /^[A-Za-z]+$/;

    if (!brand.match(letters)) {
        showErrorMessage();
        return false;
    }

    var date = new Date();
    var currYear = date.getFullYear();

    if (year == "" || year==null) {
        showErrorMessage(1);
        return false;
    }

    else {
        year = parseInt(year, 10);
    }

    if (Number.isInteger(year)) {
        if (year < 1900 || year > currYear) {
            showErrorMessage(2);
            return false;
        }
    }

    if (!Number.isInteger(year)) {
        showErrorMessage(2);
        return false;
    }

    if (!(Number.isInteger(cap2))) {
        showErrorMessage(2);
        return false;
    }

    if (cap1 == "" || cap1==null) {
        showErrorMessage(1);
        return false;
    }

    else {
        cap1 = parseInt(cap1, 10);
    }

    if (Number.isInteger(cap1)) {
        if (cap1 < 0) {
            showErrorMessage(2);
            return false;
        }
    }

    if (Number.isInteger(cap2)) {
        if (cap2 < 0) {
            showErrorMessage(2);
            return false;
        }
    }

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

function showErrorMessage(x) {

    let mes;

    if (x==1)
        mes = "Provide data!";
    else if (x==2)
        mes = "Provide correct data!";

    document.getElementById("message").innerHTML = mes;
    document.getElementById("errorMessage").style.display = "block";
}