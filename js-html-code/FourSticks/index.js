let sticks = 21;
let player = 2

function myFunction()
{
    let picked = document.getElementById("sticks").value
    sticks = sticks - picked;
    document.getElementById("remaining").innerHTML = sticks;
   
    if (player === 1)
    {
        document.getElementById("player").innerHTML = player;
        player = 2

    }
    else    
    {
        document.getElementById("player").innerHTML = player;
        player = 1;
    }

    if (sticks < 1)
    {
        window.alert("Player " + player + " lost :(");
        let newSticks = window.prompt("New stick amount?", "must be positive")
        sticks = newSticks
        document.getElementById("remaining").innerHTML = sticks;
    }
}