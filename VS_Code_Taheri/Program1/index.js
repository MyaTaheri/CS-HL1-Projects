const canvas = document.querySelector('canvas');
const c = canvas.getContext('2d');

//typical dimensions:
canvas.width = 1024;
canvas.height = 576;

// c.rect(40,60,77,99)
// c.fillStyle = "blue";
// c.fill();

c.beginPath();
c.arc(150,200,60,0,2*Math.PI);
c.fillStyle = "yellow";
c.fill();

c.beginPath();
c.rect(150,100,140,100);
c.fillStyle = "red";
c.fill();

c.beginPath();
c.moveTo(100, 200);
c.lineTo(50,300);
c.lineTo(150,300)
c.fillStyle = "blue";
c.fill();

c.beginPath();
c.font = "48px serif";
c.strokeText("Abstract Art :)", 10, 50);

