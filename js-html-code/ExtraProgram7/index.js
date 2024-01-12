frog = document.querySelector('#frog');
x = 0;
y = 0;
speed = 10;
windowWidth = window.innerWidth;
windowHeight = window.innerHeight;

//Key Codes: https://www.freecodecamp.org/news/javascript-keycode-list-keypress-event-key-codes/

document.addEventListener('keydown', (e) => {
    if (e.keyCode === 37)
    //move left
    {
        if (x > 0)
        {
            x -= speed;
            frog.style.left = x + "px";
            frog.style.transform = 'rotate(270deg)';
        }
    }
    else if (e.keyCode === 38)
    //move up
    {
        if (y > 0)
        {
            y -= speed;
            frog.style.top = y + "px";
            frog.style.transform = 'rotate(-0deg)';
        }
    }
    else if (e.keyCode === 39)
    //move right
    {
        if (x + 100 < windowWidth)
        {
            x += speed;
            frog.style.left = x + "px";
            frog.style.transform = 'rotate(90deg)';
        }
    }
    else if (e.keyCode === 40)
    //move down
    {
        if (y + 100 < windowWidth)
        {
            y += speed;
            frog.style.top = y + "px";
            frog.style.transform = 'rotate(180deg)';
        }
    }
}
)
