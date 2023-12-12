const ctx = document.querySelector('canvas');
const c = ctx.getContext('2d');

ctx.width = 1024;
ctx.height = 576;
const pi = Math.PI;

c.fillStyle = "blue";
var drawX = 450;
var drawY = 250;
c.fillRect(drawX, drawY, 100, 100);

left = document.getElementById('leftArrow');
left.addEventListener('click',
function(){
    console.log("completed");
        if (drawX >= 21)
        {
            c.clearRect(0, 0, 1024, 576);
            drawX = drawX - 20;
            c.fillRect(drawX, drawY, 100, 100);
        }
});

right = document.getElementById('rightArrow');
right.addEventListener('click',
function(){
    console.log("completed");
        if (drawX <= 900)
        {
            c.clearRect(0, 0, 1024, 576);
            drawX = drawX + 20;
            c.fillRect(drawX, drawY, 100, 100);
        }
});

down = document.getElementById('downArrow');
down.addEventListener('click',
function(){
    console.log("completed");
        if (drawY <= 400)
        {
            c.clearRect(0, 0, 1024, 576);
            drawY = drawY + 20;
            c.fillRect(drawX, drawY, 100, 100);
        }
});

up = document.getElementById('upArrow');
up.addEventListener('click',
function(){
    console.log("completed");
        if (drawY >= 21)
        {
            c.clearRect(0, 0, 1024, 576);
            drawY = drawY - 20;
            c.fillRect(drawX, drawY, 100, 100);
        }
});