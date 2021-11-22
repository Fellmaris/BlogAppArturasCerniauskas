$(function (){
    document.getElementById("test").style.display ="none";

    function openTest() {
        document.getElementById("test").style.display = "block";
    }

    document.getElementById('btn').addEventListener('click', openTest);
});