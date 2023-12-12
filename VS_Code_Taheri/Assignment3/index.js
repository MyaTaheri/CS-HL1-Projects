const ctx = document.querySelector('canvas');
const c = ctx.getContext('2d');


ctx.width = window.innerWidth
ctx.height = window.innerHeight

var slider = document.getElementById("amtRange")

c.fillStyle = "Black"
c.fill()
c.fillRect(0,0,ctx.width, ctx.height)

const gravity = 0.05
const friction = 0.99
const mouse = {
    x: 0,
    y: 0
}

class Particle
{
    constructor(x,y, radius, color, velocity){
        this.x = x
        this.y = y
        this.radius = radius
        this.color = color
        this.velocity = velocity;
        this.alpha = 1;
        this.lightness = 50;
    }
    draw(){
        c.beginPath()
        c.arc(this.x, this.y, this.radius, 0, 2*Math.PI,false)
        c.fillStyle = this.color
        c.fill()
        c.closePath()
    }
    update(){
        this.draw()
        this.velocity.y *= friction
        this.velocity.x *= friction
        this.velocity.y += gravity
        this.x += this.velocity.x
        this.y += this.velocity.y

        var [hue, saturation] = this.color.match (/\d+/g).map(Number);

        if (this.lightness>0){
            this.lightness -= 0.5;
            this.color = `hsl(${hue},${saturation}%, ${this.lightness}%)`
        }

        if(this.alpha > 0)
        {
            this.alpha-=0.005
        }
    }
}

let particles
function init(){
    particles = []
} 
addEventListener('click', event => {
    mouse.x = event.clientX
    mouse.y = event.clientY
    const particleCount = slider.value;
    const angle = (2 * Math.PI) / particleCount
    pallet = 60 * Math.floor(Math.random()*6)

    for (let i =0; i < particleCount; i++)
    {  
        randV = Math.random()*3-0.1;
    
        particles.push(new Particle(mouse.x, mouse.y, 3, 
            `hsl(${Math.random()*60 + pallet}, 50%, 50%)`
            , {
            x: Math.cos(angle * i) * randV,
            y: Math.sin(angle*i) *randV
        }))
    }
    console.log(particles)
})
function animate(){
    requestAnimationFrame(animate);
    c.fillStyle = "black";
    c.fillRect(0,0, ctx.width, ctx.height);
    
    particles.forEach((particle, i) =>
    {   
        if (particle.alpha > 0)
            particle.update()
        else   
            particles.splice(i,1)
    })
}
init()
animate()
