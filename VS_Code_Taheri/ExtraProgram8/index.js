greenFrog = document.querySelector('#greenFrog');
greenFrogX = 500;
greenFrogY = 500;

blueFrog = document.querySelector('#blueFrog');
blueFrogX = 0;
blueFrogY = 0;

beetle = document.querySelector('#beetle');
beetleX = 250;
beetleY = 250;

greenFrogSpeed = 10;
blueFrogSpeed = 15;

windowWidth = window.innerWidth;
windowHeight = window.innerHeight;

//ERRORS:
//- Beetle won't move after being eaten
//- Collision is wacky ("invisible" border on image?)
// optimize w/ classses


//Possible:
//Frog + Beetle = Speed Boost
//Counter variable in each frog button (4) => when they move 15 times (then it runs out and resets)
//If the frogs overlap and one of the frogs has a counter varibale > 0 (winner!)

//Key Codes: https://www.freecodecamp.org/news/javascript-keycode-list-keypress-event-key-codes/

//Frog Controls
document.addEventListener('keydown', (e) => {
    if (e.keyCode === 37)
    //move G left
    {
        if (greenFrogX > 0)
        {
            greenFrogX -= greenFrogSpeed;
            greenFrog.style.left = greenFrogX + "px";
            greenFrog.style.transform = 'rotate(270deg)';
        }
    }
    else if (e.keyCode === 38)
    //move G up
    {
        if (greenFrogY > 0)
        {
            greenFrogY -= greenFrogSpeed;
            greenFrog.style.top = greenFrogY + "px";
            greenFrog.style.transform = 'rotate(-0deg)';
        }
    }
    else if (e.keyCode === 39)
    //move G right
    {
        if (greenFrogX + 100 < windowWidth)
        {
            greenFrogX += greenFrogSpeed;
            greenFrog.style.left = greenFrogX + "px";
            greenFrog.style.transform = 'rotate(90deg)';
        }
    }
    else if (e.keyCode === 40)
    //move down
    {
        if (greenFrogY + 100 < windowWidth)
        {
            greenFrogY += greenFrogSpeed;
            greenFrog.style.top = greenFrogY + "px";
            greenFrog.style.transform = 'rotate(180deg)';
        }
    }

    if (e.keyCode === 65)
    //move G left
    {
        if (blueFrogX > 0)
        {
            blueFrogX -= blueFrogSpeed;
            blueFrog.style.left = blueFrogX + "px";
            blueFrog.style.transform = 'rotate(270deg)';
        }
    }
    else if (e.keyCode === 87)
    //move B up
    {
        if (blueFrogY > 0)
        {
            blueFrogY -= blueFrogSpeed;
            blueFrog.style.top = blueFrogY + "px";
            blueFrog.style.transform = 'rotate(-0deg)';
        }
    }
    else if (e.keyCode === 68)
    //move B right
    {
        if (blueFrogX + 100 < windowWidth)
        {
            blueFrogX += blueFrogSpeed;
            blueFrog.style.left = blueFrogX + "px";
            blueFrog.style.transform = 'rotate(90deg)';
        }
    }
    else if (e.keyCode === 83)
    //move B down
    {
        if (blueFrogY + 100 < windowWidth)
        {
            blueFrogY += blueFrogSpeed;
            blueFrog.style.top = blueFrogY + "px";
            blueFrog.style.transform = 'rotate(180deg)';
        }
    }
    if (isOverLappingFrogs())
    {
        alert("they bumped into each other!");
        greenFrogX = 500;
        greenFrogY = 500;
        blueFrogX = 0;
        greenFroxY = 0;
    }
    if (isBeetleAndGreen())
    {
        alert("green had speed!");
        greenFrogSpeed += 2;
        beetleX = Math.random() * 500;
        beetleY = Math.random() * 500;

        beetle.style.left = beetleX;
        beetle.style.top = beetleY;
    }

    if (isBeetleAndBlue())
    {
        alert("blue had speed!");
        blueFrogSpeed += 2;
        //Max = 500; Min = 0;
        beetleX = Math.random() * 500
        beetleY = Math.random() * 500
       
        beetle.style.left = beetleX;
        beetle.style.top = beetleY;
    }


    console.log("X: " + greenFrogX + ", " + beetleX);
    console.log("Y: " + greenFrogY + ", " + beetleY);
}
)


function isOverLappingFrogs()
{
    var betweenFrogsX = Math.abs(greenFrogX - blueFrogX);
    var betweenFrogsY = Math.abs(greenFrogY - blueFrogY);
    return (betweenFrogsX < 65 && betweenFrogsY < 60);
}

function isBeetleAndGreen()
{
    var betweenFrogX = Math.abs(greenFrogX - beetleX);
    var betweenFrogY = Math.abs(greenFrogY - beetleY);
    return (betweenFrogX < 50 && betweenFrogY < 50);

}

function isBeetleAndBlue()
{
    var betweenFrogX = Math.abs(blueFrogX - beetleX);
    var betweenFrogY = Math.abs(blueFrogY - beetleY);
    return (betweenFrogX < 70 && betweenFrogY < 70);
}
