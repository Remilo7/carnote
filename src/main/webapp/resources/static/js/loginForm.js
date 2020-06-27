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