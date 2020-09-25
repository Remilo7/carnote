function displayRegister() {
    document.getElementById("loginForm").style.display = "none";
    document.getElementById("registerForm").style.display = "flex";
    document.getElementById("pageTitle").innerText = "Sign Up";
}

function displayLogin() {
    document.getElementById("registerForm").style.display = "none";
    document.getElementById("loginForm").style.display = "flex";
    document.getElementById("pageTitle").innerText = "Log In";
}

function validateForm() {

    var password = document.forms["registrationForm"]["password"].value;
    var retyped_password = document.forms["registrationForm"]["retyped_password"].value;

    if (password != retyped_password) {
        document.getElementById("passwordError").innerHTML = "Passwords don't match!";
        document.getElementById("passwordError").style.display = "block";
        return false;
    }
}