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