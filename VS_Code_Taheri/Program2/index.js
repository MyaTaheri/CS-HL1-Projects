const ctx = document.querySelector('canvas');
const c = ctx.getContext('2d');

ctx.width = 1024;
ctx.height = 576;
const pi = Math.PI;

c.beginPath();
c.fillStyle = "#FD0";
//Yellow color
c.fillRect(0,0,75,75);

c.beginPath();
c.fillStyle = "#6C0";
//Green color
c.fillRect(75,0,75,75);

c.beginPath();
c.fillStyle = "#09F";
//Blue color
c.fillRect(0,75,75,75);

c.beginPath();
c.fillStyle = "#F30";
//Red color
c.fillRect(75,75,75,75);

c.globalAlpha = 0.2;
//opacity of a shape
// c.fillStyle = "#6495ED";
c.fillStyle = "#FFF";

for (let x = 0; x < 16; x++)
{
    c.beginPath();
    c.arc(75,75, 10+4*x, 0, 2*pi);
    c.fill();
}




//https://www.w3schools.com/colors/colors_names.asp
//https://www.w3schools.com/colors/colors_hex.asp