let spot = 0;
let names;
function init(){
    names = []
}

init();
function myFunction()
{
    let last = document.getElementById("lName").value
    let first = document.getElementById("fName").value
    names.push(last + ', ' + first);
    let list = ""
    for (let k = names.length - 1; k >= 0; k--)
    {
        list += names[k] + "<br>";
    }
    document.getElementById("listNames").innerHTML = list;
    spot++;
}