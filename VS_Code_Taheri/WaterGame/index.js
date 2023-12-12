const canvas = document.querySelector('canvas');
const c = canvas.getContext('2d');
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;

const image01 = new Image();
image01.src = 'flower01.png'; 
const image02 = new Image();
image02.src = 'flower02.png'; 
const image03 = new Image();
image03.src = 'flower03.png'; 
const imageCloud = new Image();
imageCloud.src = 'cloud.png';
let flowers = [];

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
    constructor(number,x,y,velocity, image)
    {
        this.number = number;
        this.x = x - 10;
        this.y = y;
        this.velocity = velocity;
        this.image = image;
    }

    draw() {
        c.fillStyle = 'rgb(6, 6, 6)'
        c.drawImage(this.image, this.x, this.y, 50, 50);
        c.fill();
      }

      check()
      {
      }

      update()
      {
        this.draw();
        this.x += this.velocity;
        this.y = canvas.height - (Math.sin(this.x * 0.030) * 30) - 180;
      }
}

flower01 = new Flower (1, 0, 500, 2.5, image01);
flower02 = new Flower (1, 75, 500, 2.5, image02)
flower03 = new Flower (1, 150, 500, 2.5, image03);

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
    flower03.update();
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
