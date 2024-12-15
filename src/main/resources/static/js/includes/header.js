document.addEventListener("DOMContentLoaded", function () {
    const hamburger = document.querySelector(".hamburger");
    const navMenu = document.querySelector(".navbar ul");

    hamburger.addEventListener("click", function () {
        navMenu.classList.toggle("show");
    });
});