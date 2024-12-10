document.addEventListener("DOMContentLoaded", () => {
    const slide1 = document.querySelector(".slide1");
    const slide2 = document.querySelector(".slide2");
    const delayBarProgress = document.querySelector(".delay-bar-progress");
    const slideIndicator = document.getElementById("slide-indicator");
    const images1 = ["/images/main/main1.jpg", "/images/main/main2.jpg", "/images/main/main3.jpg"];
    const images2 = ["/images/main/main4.jpg", "/images/main/main5.jpg", "/images/main/main6.jpg"];
    let currentIndex1 = 0;
    let currentIndex2 = 0;
    const slideInterval = 9000;
    let interval = null;
    let delayBarStartTime = 0;
    let delayBarElapsedTime = 0;
    let isPlaying = false;

    function updateSlide() {
        slide1.style.backgroundImage = `url('${images1[currentIndex1]}')`;
        slide2.style.backgroundImage = `url('${images2[currentIndex2]}')`;
        updateSlideIndicator();
        resetDelayBar();
    }

    function updateSlideIndicator() {
        const slideNumber = currentIndex1 + 1;
        const totalSlides = images1.length;
        slideIndicator.textContent = `${String(slideNumber).padStart(2, "0")}/${String(totalSlides).padStart(2, "0")}`;
    }

    function resetDelayBar() {
        delayBarStartTime = Date.now();
        delayBarElapsedTime = 0;
        delayBarProgress.style.transition = `none`;
        delayBarProgress.style.width = "0";
        setTimeout(() => {
            delayBarProgress.style.transition = `width ${slideInterval}ms linear`;
            delayBarProgress.style.width = "100%";
        }, 50);
    }

    function pauseDelayBar() {
        delayBarElapsedTime += Date.now() - delayBarStartTime;
        delayBarProgress.style.transition = "none";
        const progressWidth = (delayBarElapsedTime / slideInterval) * 100;
        delayBarProgress.style.width = `${progressWidth}%`;
    }

    function resumeDelayBar() {
        const remainingTime = slideInterval - delayBarElapsedTime;
        delayBarStartTime = Date.now();
        delayBarProgress.style.transition = `width ${remainingTime}ms linear`;
        delayBarProgress.style.width = "100%";
    }

    function toggleSlideShow() {
        const toggleButton = document.getElementById("toggle");
        if (isPlaying) {
            clearInterval(interval);
            pauseDelayBar();
            toggleButton.textContent = "Start";
            isPlaying = false;
        } else {
            const remainingTime = slideInterval - delayBarElapsedTime;
            interval = setTimeout(() => {
                currentIndex1 = (currentIndex1 + 1) % images1.length;
                currentIndex2 = (currentIndex2 + 1) % images2.length;
                updateSlide();
                interval = setInterval(() => {
                    currentIndex1 = (currentIndex1 + 1) % images1.length;
                    currentIndex2 = (currentIndex2 + 1) % images2.length;
                    updateSlide();
                }, slideInterval);
                resetDelayBar();
            }, remainingTime);
            resumeDelayBar();
            toggleButton.textContent = "Stop";
            isPlaying = true;
        }
    }

    document.getElementById("toggle").addEventListener("click", toggleSlideShow);

    document.getElementById("prev").addEventListener("click", () => {
        clearInterval(interval);
        delayBarElapsedTime = 0;
        currentIndex1 = (currentIndex1 - 1 + images1.length) % images1.length;
        currentIndex2 = (currentIndex2 - 1 + images2.length) % images2.length;
        updateSlide();

        if (isPlaying) {
            interval = setInterval(() => {
                currentIndex1 = (currentIndex1 + 1) % images1.length;
                currentIndex2 = (currentIndex2 + 1) % images2.length;
                updateSlide();
            }, slideInterval);
            resetDelayBar();
        }
    });

    document.getElementById("next").addEventListener("click", () => {
        clearInterval(interval);
        delayBarElapsedTime = 0;
        currentIndex1 = (currentIndex1 + 1) % images1.length;
        currentIndex2 = (currentIndex2 + 1) % images2.length;
        updateSlide();

        if (isPlaying) {
            interval = setInterval(() => {
                currentIndex1 = (currentIndex1 + 1) % images1.length;
                currentIndex2 = (currentIndex2 + 1) % images2.length;
                updateSlide();
            }, slideInterval);
            resetDelayBar();
        }
    });

    updateSlide();
    setTimeout(() => {
        toggleSlideShow();
    }, 100);

    const topButtons = document.querySelectorAll(".top-button");
    const firstSection = document.querySelector(".main-section");

    topButtons.forEach(button => {
        button.addEventListener("click", () => {
            firstSection.scrollIntoView({ behavior: "smooth" });
        });
    });
});