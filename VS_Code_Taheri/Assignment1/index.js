const ctx = document.querySelector('canvas');
const c = ctx.getContext('2d');

ctx.width = 1024;
ctx.height = 576;
const pi = Math.PI;

drawLetters();
// drawTicTacToe();
// drawStar();
// nStarEndpoints(20, 0, 2*pi, "#328da8");




function nStarEndpoints(n, s, e, color)
{
    s = s + (0.5 * pi);
    e = e + (0.5 * pi);
    n = ((e - s)) / n;
    c.lineWidth = 2;
    c.strokeStyle = color;

    for (let x = s; x <= e; x+=n)
    {

        c.beginPath();
        c.lineWidth = 2;
        c.moveTo(200, 200);
        drawX = Math.sin(x) * 100;
        drawY = Math.cos(x) * 100;
        c.lineTo(200+drawX, 200 +drawY);
        c.stroke();
        
        // c.beginPath();
        // c.arc(200+drawX, 200 + drawY, 2, 0, 2*Math.PI);
        // c.fillStyle = "black";
        // c.fill();
    }
}


function drawStar()
{
    redSpikes(10, 0, 2*pi);
    star();
    // dashedSpikes(5, 0, 2*pi);

}
function idekStar()
{
    
    const centerX = 200; 
    const centerY = 200; 
    const outerRadius = 50;
    const innerRadius = 20; 
    const spikes = 5; 
    c.setLineDash([5, 0]);

    c.beginPath(); 

    for (let i = 0; i < spikes * 2; i++)
    { 
        const radius = i % 2 === 0 ? outerRadius : innerRadius; 
        const angle = (Math.PI / spikes) * i; 
        const x = centerX + radius * Math.cos(angle); 
        const y = centerY + radius * Math.sin(angle); 
        if (i === 0)
        {
             c.moveTo(x, y); 
        } 
        else 
        {
            c.lineTo(x, y); 
        } 
    } 
    c.closePath(); 
    c.lineWidth = 5; 
    c.strokeStyle = "blue"; 
    // c.fillStyle = "yellow"; 
    // c.fill();
    c.stroke();

}
function star()
{
    c.strokeStyle = "blue";
    c.lineWidth = 2;
    originX = 200;
    originY = 200;       
    c.setLineDash([5, 0]);

    for (let x = pi / 2 - (11 * pi/10); x <= 5 *pi / 2; x+= pi*2 / 5)
    {
        var oldX = Math.sin(x) * 100;
        var oldY = Math.cos(x) * 100;
        var newX = Math.sin(x - 4*pi/5) * 100;
        var newY = Math.cos(x - 4*pi/5) * 100;
     
        c.beginPath();
        c.moveTo(oldX + originX, oldY + originY);
        c.lineTo(newX + originX, newY + originY);
        c.stroke();

    }
}
function redSpikes(n, s, e)
{
   
    n = ((e - s)) / n;
    c.strokeStyle = "red";
    c.lineWidth = 2;

    for (let x = s; x <= e; x+=n)
    {

        c.beginPath();
        c.lineWidth = 2;
        c.moveTo(200, 200);
        drawX = Math.sin(x) * 100;
        drawY = Math.cos(x) * 100;
        c.lineTo(200+drawX, 200 +drawY);
        c.stroke();
    }
}
function dashedSpikes(n, s, e)
{
    c.strokeStyle = "black";
    s = s + (pi);
    e = e + (pi);
    n = ((e - s)) / n;
    c.lineWidth = 2;
    for (let x = s; x <= e; x+=n)
    {

        c.beginPath();
        c.lineWidth = 2;
        c.setLineDash([5, 3]);
        c.moveTo(500, 200);
        drawX = Math.sin(x) * 100;
        drawY = Math.cos(x) * 100;
        c.lineTo(500+drawX, 200 +drawY);
        c.stroke();
    }
}



function drawLetters()
{
    letterBox(75,  75, "#ff8080", "a");
    letterBox(160, 75, "#ffc67a", "b");
    letterBox(245, 75, "#ffe680", "c");
    letterBox(330, 75, "#83de8e", "d");
    
    letterBox(75,  185, "#83d6de", "e");
    letterBox(160, 185, "#8392de", "f");
    letterBox(245, 185, "#c783de", "g");
    letterBox(330, 185, "#de83a4", "h");
}
function letterBox (x,y, hexcolor, letter)
{
    c.beginPath();
    c.fillStyle = hexcolor;
    c.fillRect(x,y,75,100);
    c.font = "80px Trebuchet MS, sans-serif"
    c.fillStyle = "#62636a";
    c.fillText(letter, x+16, y+77);
    c.fillStyle = "#FFF";
    c.fillText(letter, x+14, y+75);
}


function drawTicTacToe()
{
    oTac(75,75);
    oTac(150,75);
    crossTac(225,75);

    crossTac(75,150);
    crossTac(150,150);
    oTac(225,150);

    oTac(75,225);
    crossTac(150,225);
    oTac(225,225);

}
function crossTac (x, y)
{
    c.beginPath();
    c.fillStyle = "#7ac8ff";
    c.fillRect(x,y,75,75);
    c.strokeStyle = "#1a4f75";
    c.strokeRect(x,y,75,75);
    
    c.beginPath();
    c.font = "80px sans-serif";
    c.fillStyle = "#FFF";
    c.fillText("x", x + 17, y + 60);
    //c.strokeText = outline only
}
function oTac (x, y)
{
    c.beginPath();
    c.fillStyle = "#ffc67a";
    c.fillRect(x,y,75,75);
    c.strokeStyle = "#524637";
    c.strokeRect(x,y,75,75);
    
    c.beginPath();
    c.font = "80px sans-serif";
    c.fillStyle = "#FFF";
    c.fillText("o", x + 17, y + 60);
}