jQuery(document).ready(function(){

    setInterval(function(){
        
        $('.slide').delay(3000)
        $('.slide').animate({"left":"-1200px"})

        $('.slide').delay(3000)
        $('.slide').animate({"left":"-2400px"})

        $('.slide').delay(3000)
        $('.slide').animate({"left":"0px"})
    })

    function updateTimer() {
        const future = Date.parse("2023/09/27 19:00:00");
        const now = new Date();
        const diff = future - now;
    
        const days = Math.floor(diff / (1000 * 60 * 60 * 24));
        const hours = Math.floor(diff / (1000 * 60 * 60));
        const mins = Math.floor(diff / (1000 * 60));
        const secs = Math.floor(diff / 1000);
    
        const d = days;
        const h = hours - days * 24;
        const m = mins - hours * 60;
        const s = secs - mins * 60;
    
        document.getElementById("timer")
         .innerHTML =
         '<div>' + d + '<span>일</span></div>' +
         '<div>' + h + '<span>시</span></div>' +
         '<div>' + m + '<span>분</span></div>' +
         '<div>' + s + '<span>초</span></div>';
    }
    
    setInterval(updateTimer, 1000);






    const daysEl = document.getElementById("days");
    const hoursEl = document.getElementById("hours");
    const minsEl = document.getElementById("mins");
    const secondsEl = document.getElementById("seconds");

    const newYears = "31 Dec 2023";

    function countdown() {
        const newYearsDate = new Date(newYears);
        const currentDate = new Date();

        const totalSeconds = (newYearsDate - currentDate) / 1000;

        const days = Math.floor(totalSeconds / 3600 / 24);
        const hours = Math.floor(totalSeconds / 3600) % 24;
        const mins = Math.floor(totalSeconds / 60) % 60;
        const seconds = Math.floor(totalSeconds) % 60;

        daysEl.innerHTML = days;
        hoursEl.innerHTML = formatTime(hours);
        minsEl.innerHTML = formatTime(mins);
        secondsEl.innerHTML = formatTime(seconds);
    }

    function formatTime(time) {
        return time < 10 ? `0${time}` : time;
    }

    // initial call
    countdown();

    setInterval(countdown, 1000);
});