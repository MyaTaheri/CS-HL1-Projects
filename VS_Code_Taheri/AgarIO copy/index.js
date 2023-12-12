const ctx = document.querySelector('canvas');
const c = ctx.getContext('2d');

ctx.width = window.innerWidth
ctx.height = window.innerHeight


x = 0;
y = 0;
xSpeed = 2;
ySpeed = 2;

class Blob
{
    constructor({position})
    {
        this.position = position
    }

    draw()
    {
        c.beginPath()
        c.arc(this.position.x, this.position.y, 50, 0, 2*Math.PI)
        c.fillStyle = "red"
        c.fill()
        c.closePath()
    }
    update()
    {
        this.draw()
        console.log("update")
    }
}

const org1 = new Blob ({
    position: {
        // x: Math.random * (ctx.width - 50),
        // y: Math.random * (ctx.height - 50)
        x: 300,
        y: 300
    }
})

function animate() {
    requestAnimationFrame(animate);
    console.log("animate")
    org1.update()
}
animate();

