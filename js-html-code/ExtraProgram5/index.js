const ctx = document.querySelector('canvas');
const c = ctx.getContext('2d');

ctx.width = 1024;
ctx.height = 576;
const pi = Math.PI;
color = "red"

// prompt1();

btn = document.getElementById('btn');
btn.addEventListener('click',
function(){
    c.clearRect(0, 0, 1024, 576);
    var number = document.getElementById("number").value;
    var startAngle = document.getElementById("startAngle").value;
    var endAngle = document.getElementById("endAngle").value;

    startAngle = startAngle * pi / 180;
    endAngle = endAngle * pi / 180;

    nStarEndpoints (number,startAngle , endAngle, "red");
});


// function prompt1 ()
// {

//     var number = prompt("Enter number of points", "Enter points");
//     var startAngle = prompt("Enter start angle (degrees)", "Enter angle");
//     var endAngle = prompt("Enter end angle (degrees)", "Enter angle");
//     // var color = prompt("Enter end color (if it is a specific hex, include #)", "Enter angle");
    
//     startAngle = startAngle * pi / 180;
//     endAngle = endAngle * pi/180;
    
//     if (number > 0 )
//     {
//         nStarEndpoints(number, startAngle, endAngle, "red");
//     }
// }

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
