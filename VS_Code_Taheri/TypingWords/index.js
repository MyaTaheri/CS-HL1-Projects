function type()
{
    document.addEventListener("DOMContentLoaded", function(){
    //get the output container
    const outputDiv = document.getElementById("output")
    //listen for the key pressed
    document.addEventListener("keyup", function(event){
        //check if key is pressed
        if (event.key==="Enter")
        {
            outputDiv.textContent = "";
        }
        else if(event.key.length === 1)
        {
            outputDiv.textContent += event.key;
        }
        else if (event.key === "Backspace")
        {
            var substring = outputDiv.textContent.substring(0, outputDiv.textContent.length - 1);
            outputDiv.textContent = substring;
        }
    })
})
}
type();