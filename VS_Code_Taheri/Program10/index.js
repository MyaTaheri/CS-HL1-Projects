const ball = document.getElementById("ball");
x = 0;
y = 0;
xSpeed = 5;
ySpeed = 5;
red = 250; //minus 18
blue = 110; // minus 14
green = 110; //add 6
redToBlue = -1
function animate() {
    x += xSpeed;
    y += ySpeed;
    if (x + 50 > window.innerWidth || x < 0) {
        xSpeed = -xSpeed;
    }
    if (y + 50 > window.innerHeight || y < 0) {
        ySpeed = -ySpeed;
    }
    ball.style.left = x + "px";
    ball.style.top = y + "px";
    
    gradient();
    ball.style.backgroundColor = red + "," + green + "," + blue;
   requestAnimationFrame(animate);
}
animate();

function gradient()
{
    console.log(red);
    for (let i = 0; i < 10; i++)
    {
        red = red + (18 * redToBlue);
        blue = blue + (14 * redToBlue);
        green = green + (-6 * redToBlue);
    }
    redToBlue *= -1;
}