const canvas = document.querySelector('canvas');
const c = canvas.getContext('2d');
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;
score = 0; // 60Hz Cycle

const imageCloud = new Image();
imageCloud.src = 'cloud.png';


let flowers = [];
var colorArray = [
    "#42d4f5",
    "#4c5fba",
    "#54c490",
    "#d6a7eb",
    "#3463e3",
    "#3d995a",
    "#6a5acd",
    "#6495ed",   
    "#00bfff",
    "#d6897a",
    "#d6b37a",
    "#4aa0b5",
    "#d16d77",
    "#c979b7"
];
var rainDropArray = []

//Draw Functions:

function background()
{
    c.fillStyle = "#bed9ed";
    c.fillRect(0,0,canvas.width, canvas.height);
    clouds();
    hills();
}

function clouds()
{
    c.strokeStyle = "#96b2d9";
    for (let x = 0; x < canvas.width; x++)
    {
    c.lineWidth = 1;
    c.beginPath();
    c.moveTo(x, Math.sin(x * 5) * 100);
    c.lineTo (x+1, Math.sin(x * 5+ 5)* 100);
    c.stroke();
    }
}

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

function randomColor()
{
    return Math.round(Math.random()*colorArray.length-1);
}

function dFlower(centerX, centerY, radius, numPetals, color){
    this.centerX = centerX;
    this.centerY = centerY;
    this.radius = radius;
    this.numPetals = numPetals;
    this.color = color;
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
    c.fillStyle = this.color;
    c.fill();
    
    // draw yellow center
    c.beginPath();
    c.arc(this.centerX, this.centerY, this.radius / 6, 0, 2 * Math.PI, false);
    c.fillStyle = "#f8fcd2";
    c.fill();

}

//Class Functions
class Flower
{
    constructor(number,x,y,velocity, color)
    {
        this.number = number;
        this.x = x - 10;
        this.y = y;
        this.velocity = velocity;
        this.color = color
    }

    draw() {
       dFlower(this.x,this.y, 50, 6, this.color);
      }

      check()
      {
      }

      update()
      {
        this.draw();
        if (this.x > canvas.width)
        {
            this.x = 0;
        }
        this.x += this.velocity;
        this.y = canvas.height - (Math.sin(this.x * 0.030) * 30) - 160;
      }
}

class RainCloud
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
        if (rainDropArray.length < 5)
        rainDropArray.push(new Rain(this.x + 75 , 150, 0.5));
      }

      update()
      {
        this.draw();
        if ((this.x + 150 > canvas.width) || (this.x < 0))
          this.velocity *= -1;
        this.x -= this.velocity;
      }
}

class Rain
{
    constructor(x, y, rainVelocity)
    {
        this.x = x;
        this.y = y;
        this.velocity = rainVelocity;
    }
    draw()
    {
        c.beginPath();
        c.fillStyle = "blue";
        c.arc(this.x,this.y, 4, 0, 2*Math.PI, false)
        c.fill();
        c.closePath();
    }
    update()
    {
        this.draw();
        this.check();
        this.y = this.y + this.velocity;
        this.velocity = this.velocity + 0.05;
        if (this.y > canvas.height - (Math.sin(this.x * 0.03) * 30) - 150)
        {
            rainDropArray.shift();
        }
    }
    check()
    {
        for (let f = 0; f < flowers.length; f++)
        {
            var flowerX = flowers[f].x;
            var flowerY = flowers[f].y;
            console.log("FlowerX: " + flowerX + ", FlowerY:" + flowerY);
            console.log("rainX: " + this.x + ", rainY:" + this.y);

            if (flowerX + 10 > this.x && flowerX - 10 < this.x
                && flowerY + 10 > this.y && flowerY - 10 < this.y)
            {
                console.log("hit");
                flowers.splice(f,1);
            }
        }
    }
}


//Moving Functions
window.addEventListener('keyup', (e) => {
    switch(event.key)
    {
        case 'ArrowLeft':
            rCloud.velocity = 2;        
            break;
        case 'ArrowRight':
            rCloud.velocity = -2;
            break;
        case ' ':
                rCloud.launch();
                break;
    }
});

function init()
{
  for(let k = 0; k < Math.floor(canvas.width / 75); k++)
  {
    flowers.push(new Flower(k, 0 + 75 * k, 500, 2.5, colorArray[randomColor()]))
  }
}

rCloud = new RainCloud (canvas.width / 2, 0)

function animate() {
    window.requestAnimationFrame(animate);
    score++;
    background();
    flowers.forEach((flower,i)=>{
        flower.update();
    });
    rainDropArray.forEach((rain)=> {rain.update()})
    

    rCloud.update();
    for (let j = 0; j < rainDropArray.length; j++)
    {
        rainDropArray[j].update();
    }

    if (flowers.length === 0)
    {
        c.font = "40px sans-serif";
        c.fillStyle = "#3155a8";
        c.fillText("You Win!", canvas.width / 2 - 75, canvas.height * 0.3)
        rCloud.x = canvas.width / 2 - 75;
        rCloud.velocity = 0;
    }
}
init();
animate();


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
