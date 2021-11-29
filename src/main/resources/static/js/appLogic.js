$(window.onload = function(){

});

function showCommentArea(blogId, buttonId, formId) {
    var blogCommentArea = document.getElementById(blogId);
    var blogCommentButton = document.getElementById(buttonId)
    var commentForm = document.getElementById(formId)
    if (blogCommentArea.style.display === "none") {
        blogCommentArea.style.display = "block";
        blogCommentButton.className = "btn btn-outline-primary";
        commentForm.setAttribute("method", "post");
    } else {
        blogCommentButton.setAttribute("type", "submit");
    }
}