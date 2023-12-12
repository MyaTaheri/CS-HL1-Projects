const ctx = document.querySelector('canvas');
const c = ctx.getContext('2d');

ctx.width = 1024;
ctx.height = 576;
const pi = Math.PI;

// sevenStar();
// fourStarRevamp();
// sixteenStar();
// nStar(33);
nStarEndpoints(16, 0.25 * pi, 1.5 * pi)


function fourStar(){
    c.beginPath();
    c.strokeStyle = "blue";
    c.lineWidth = 5;
    c.moveTo(200,200);
    c.lineTo(200, 300);
    c.stroke();
    c.moveTo(200,200);
    c.lineTo(200, 100);
    c.stroke();
    c.moveTo(200,200);
    c.lineTo(100, 200);
    c.stroke();
    c.moveTo(200,200);
    c.lineTo(300, 200);
    c.stroke();
    c.arc(200, 200, 10, 0, 2*Math.PI);
    c.fillStyle = "red";
    c.fill();
}

function fourStarRevamp(){
    c.beginPath();
    // c.strokeStyle = "blue";
    blueRandomColor();
    c.lineWidth = 3;
    c.moveTo(550,300);
    c.lineTo(650,300);
    c.stroke();
    c.moveTo(600,250);
    c.lineTo(600, 350);
    c.stroke();
    c.beginPath();
    c.arc(600, 300, 5, 0, 2*Math.PI);
    c.fillStyle = "black";
    c.fill();
}

function sevenStar()
{
    c.strokeStyle = "#F2DE5C";
    c.lineWidth = 2;
    for (let x = 0 * pi; x <= 0.5 * pi; x+=(pi/16))
    {
        c.beginPath();
        c.moveTo(400, 400);
        var drawX = Math.sin(x) * 100;
        var drawY = Math.cos(x) * 100;
        c.lineTo(400+drawX, 400 +drawY);
        c.stroke();
        
        c.beginPath();
        c.arc(400+drawX, 400 + drawY, 5, 0, 2*Math.PI);
        c.fillStyle = "#6FE471";
        c.fill();
    }
    c.beginPath();
    c.moveTo(400, 400);
    var drawX = Math.sin(0) * 100;
    var drawY = Math.cos(0) * 100;
    c.lineTo(400+drawX, 400 +drawY);
    c.stroke();
    
    c.beginPath();
    c.arc(400+drawX, 400 + drawY, 5, 0, 2*Math.PI);
    c.fillStyle = "#6FE471";
    c.fill();
    
}

function sixteenStar()
{
    c.strokeStyle = "#33A5FF";
    for (let x = 0; x < 2*pi; x+=(pi/6))
    {
        c.beginPath();
        c.moveTo(200, 200);
        c.lineWidth = 2;
        var drawX = Math.sin(x) * 100;
        var drawY = Math.cos(x) * 100;
        c.lineTo(200+drawX, 200 +drawY);
        c.stroke();
        
        c.beginPath();
        c.arc(200+drawX, 200 + drawY, 5, 0, 2*Math.PI);
        c.fillStyle = "purple";
        c.fill();
    }
}

function blueRandomColor()
{
    // var red = Math.random() * 255;
    // var blue = 10;
    // var green = Math.random() * 255;
    // c.strokeStyle = "rgb(" + red + ", " + blue + ", " + green + ")";

    h = Math.random() * 101 + 200;
    s = Math.random() * 100;
    l = (Math.random() * 41) + 30;
    color = 'hsl(' + h + ', ' + s + '%, ' + l + '%)';
    console.log(l);
    c.strokeStyle = color;

    //https://stackoverflow.com/questions/33240107/how-to-generate-all-blue-color-in-rgb-javascript
}

//random Blue color can be edited to include all lines vs indiviual lines
function nStar(n)
{
    n = (2*pi) / n;
    // blueRandomColor();
    c.lineWidth = 2;
    for (let x = 0; x < 2*pi; x+=n)
    {
        blueRandomColor();

        c.beginPath();
        c.moveTo(200, 200);
        c.lineWidth = 2;
        var drawX = Math.sin(x) * 100;
        var drawY = Math.cos(x) * 100;
        c.lineTo(200+drawX, 200 +drawY);
        c.stroke();
        
        c.beginPath();
        c.arc(200+drawX, 200 + drawY, 2, 0, 2*Math.PI);
        c.fillStyle = "black";
        c.fill();
    }
}

//Angle s and e must be in radians
function nStarEndpoints(n, s, e)
{
    s = s + (0.5 * pi);
    e = e + (0.5 * pi);
    n = ((e - s)) / n;
    // blueRandomColor();
    c.lineWidth = 2;

    for (let x = s; x <= e; x+=n)
    {
        blueRandomColor();

        c.beginPath();
        c.lineWidth = 2;
        c.moveTo(200, 200);
        drawX = Math.sin(x) * 100;
        drawY = Math.cos(x) * 100;
        c.lineTo(200+drawX, 200 +drawY);
        c.stroke();
        
        c.beginPath();
        c.arc(200+drawX, 200 + drawY, 2, 0, 2*Math.PI);
        c.fillStyle = "black";
        c.fill();
    }
}
