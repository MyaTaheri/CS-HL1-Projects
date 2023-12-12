const canvas = document.querySelector('canvas');
const c = canvas.getContext('2d');
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;


const imageCloud = new Image();
imageCloud.src = 'cloud.png';
let flowers = [];

var colorArray = [
    "#42d4f5",
    "#4c5fba",
    "#80edba",
    "#d6a7eb",
    "#3463e3",
    "#7fd490"
];

function hills()
{
    for (let x = 0; x < canvas.width; x = x + 0.5)
    {
        c.strokeStyle = "#82bf90";
        c.lineWidth = 1;
        c.beginPath();
        c.moveTo(x, canvas.height - (Math.sin(x * 0.03) * 30) - 150);
        c.lineTo (x, canvas.height);
        c.stroke();
    }
}
class Flower
{
    constructor(number,x,y,velocity)
    {
        this.number = number;
        this.x = x - 10;
        this.y = y;
        this.velocity = velocity;
    }

    draw() {
       dFlower(this.x,this.y, 50, 6);
      }

      check()
      {
      }

      update()
      {
        this.draw();
        this.x += this.velocity;
        this.y = canvas.height - (Math.sin(this.x * 0.030) * 30) - 160;
      }
}


flower01 = new Flower (1, 0, 500, 2.5);
flower02 = new Flower (1, 75, 500, 2.5);



class rainCloud
{
    constructor(x,velocity)
    {
        this.x = x;
        this.velocity = velocity;
    }

    draw() {
        c.drawImage(imageCloud, this.x, 100, 150, 100);
      }

      launch()
      {
        console.log("launch!")
      }

      update()
      {
        this.draw();
        if ((this.x + 150 > canvas.width) || (this.x < 0))
          this.velocity *= -1;
        this.x -= this.velocity;
      }
}

class rain{
    constructor()
    {

    }
    check()
    {

    }
    draw()
    {

    }
    update()
    {
        
    }
}

rCloud = new rainCloud (canvas.width / 2, 0)

window.addEventListener('keyup', (e) => {
    switch(event.key)
    {
        case 'ArrowLeft':
            rCloud.velocity = 2;        
            break;
        case 'ArrowRight':
            rCloud.velocity = -2;
            break;
    }
});

window.addEventListener('keydown', (e) => {
    switch(event.key)
    {
        case 'Shift':
            console.log("shift");
            rCloud.launch();
            break;
    }
});


function background()
{
    c.fillStyle = "#bed9ed";
    c.fillRect(0,0,canvas.width, canvas.height);
}

function animate() {
    window.requestAnimationFrame(animate);
    background();
    hills();
    flower01.update();
    flower02.update();
    rCloud.update();
}
animate();

function clouds()
{
    for (let x = 0; x < canvas.width; x++)
    {
    c.lineWidth = 1;
    c.beginPath();
    c.moveTo(x, Math.sin(x * 5) * 100);
    c.lineTo (x+1, Math.sin(x * 5+ 5)* 100);
    c.stroke();
    }
}

function dFlower(centerX, centerY, radius, numPetals){
    this.centerX = centerX;
    this.centerY = centerY;
    this.radius = radius;
    this.numPetals = numPetals;
    color =  colorArray[Math.round(Math.random()*colorArray.length-1)];
    c.beginPath();
    
    for (var n = 0; n < this.numPetals; n++) {
        var theta1 = ((Math.PI * 2) / this.numPetals) * (n + 1);
        var theta2 = ((Math.PI * 2) / this.numPetals) * (n);
        
        var x1 = (this.radius * Math.sin(theta1)) + this.centerX;
        var y1 = (this.radius * Math.cos(theta1)) + this.centerY;
        var x2 = (this.radius * Math.sin(theta2)) + this.centerX;
        var y2 = (this.radius * Math.cos(theta2)) + this.centerY;
        
        c.moveTo(this.centerX, this.centerY);
        c.bezierCurveTo(x1, y1, x2, y2, this.centerX, this.centerY);
    }
    
    c.closePath();
    c.fillStyle = color;
    c.fill();
    
    // draw yellow center
    c.beginPath();
    c.arc(this.centerX, this.centerY, this.radius / 5, 0, 2 * Math.PI, false);
    c.fillStyle = "#f8fcd2";
    c.fill();

}


//other stuff

//draw sine wave
// for (let x = 0; x < canvas.width; x = x + 0.5)
// {
    
//     c.lineWidth = 1;
//     c.beginPath();
//     c.moveTo(x, canvas.height - (Math.sin(x * 0.05) * 30) - 75);
//     c.lineTo (x+0.5, canvas.height - (Math.sin(x * 0.05) * 30) - 75);
//     c.stroke();
// }
