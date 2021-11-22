$(window.onload = function(){

});

function showCommentArea(blogId) {
    var x = document.getElementById(blogId);
    if (x.style.display === "none") {
        x.style.display = "block";
    }
}