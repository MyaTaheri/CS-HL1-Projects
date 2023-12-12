const canvas = document.querySelector('canvas')
const c = canvas.getContext('2d')

canvas.width = window.innerWidth * 0.98
canvas.height = window.innerHeight * 0.98

c.font = "30px Arial"
c.textAlign = "center";

const letters = ["", "ก", "ข", "ฃ", "ค", "ฅ", "ฆ", "ง", "จ", "ฉ", "ช", "ซ", "ฌ", "ญ", "ฎ", "ฏ", "ฐ", "ฑ", "ฒ", "ณ", "ด", "ต", "ถ", "ท", "ธ", "น", "บ", "ป", "ผ", "พ", "ภ", "ม", "ฝ", "ฟ", "ย", "ร", "ล", "ว", "ศ", "ษ", "ส", "ห", "ฬ", "อ", "ฮ"]

class Player {
    constructor({x, y, radius, value, color, velocity}) {
    this.x = x
    this.y = y
    this.radius = radius
    this.value = value
    this.color = color
    this.velocity = velocity
}

    draw() {
        c .fillStyle = this.color
        c.beginPath()
        c.arc(this.x, this.y, this.radius, 0, 2*Math.PI)
        c.closePath()
        c.fill()

        c.fillStyle = "black"
        c.fillText(letters[this.value - 1], this.x, this.y + 10)
    }

    update() {
        this.draw()
        this.x += this.velocity.x
        this.y += this.velocity.y

        if(this.x < this.radius) {
            this.x = this.radius
        }
        if(this.x > canvas.width - this.radius) {
            this.x = canvas.width - this.radius
        }

        if(this.y < this.radius) {
            this.y = this.radius
        }
        if(this.y > canvas.height - this.radius) {
            this.y = canvas.height - this.radius
        }
    }

    checkEat(circle) {
        const dx = circle.x - player.x
        const dy = circle.y - player.y
        const distance = Math.sqrt(dx*dx + dy*dy)

        if(distance < player.radius - circle.radius) {
            if(circle.value == this.value - 1) {
                this.value++
                this.radius += 3
                circles.delete(circle)
                addCircle(circle.value)
            } else if(this.value > 1) {
            // make sure we don't eat twice on consecutive frames
            circles.delete(circle)
            addCircle(circle.value)
            this.value--
            this.radius -= 3
            }
        }
    }
}

class Circle {
    constructor({x, y, value, radius, color, velocity}) {
    this.x = x
    this.y = y
    this.value = value
    this.radius = radius
    this.color = color
    this.velocity = velocity

    this.disabled = false
}

    draw() {
        c.fillStyle = this.color

        c.beginPath()
        c.arc(this.x, this.y, this.radius, 0, 2*Math.PI)
        c.fill()

        c.fillStyle = "black"
        c.fillText(letters[this.value+1], this.x, this.y + 10)
    }

    update() {
        this.draw()

        this.x += this.velocity.x
        this.y += this.velocity.y

        if(this.x < this.radius) {
            this.velocity.x = Math.abs(this.velocity.x)
        }
        if(this.x > canvas.width - this.radius) {
            this.velocity.x = -Math.abs(this.velocity.x)
        }

        if(this.y < this.radius) {
            this.velocity.y = Math.abs(this.velocity.y)
        }
        if(this.y > canvas.height - this.radius) {
            this.velocity.y = -Math.abs(this.velocity.y)
        }
    }
}

const player = new Player({
    x:canvas.width/2, y:canvas.height/2,
    value:1,
    radius:35,
    color:"blue",
    velocity:{x:0, y:0}
})

canvas.addEventListener("mousemove", event => {
    const mouseX = event.offsetX
    const mouseY = event.offsetY

    player.velocity.x = (mouseX - player.x)/75
    player.velocity.y = (mouseY - player.y)/75
})

// addEventListener("keydown", event => {
// switch(event.key) {
// case "ArrowLeft":
// player.velocity.x = -10
// break;
// case "ArrowRight":
// player.velocity.x = 10
// break;
// case "ArrowUp":
// player.velocity.y = -10
// break;
// case "ArrowDown":
// player.velocity.y = 10
// break;
// }
// })

// addEventListener("keyup", event => {
// switch(event.key) {
// case "ArrowLeft":
// case "ArrowRight":
// player.velocity.x = 0
// break;
// case "ArrowUp":
// case "ArrowDown":
// player.velocity.y = 0
// break;
// }
// })

const circles = new Set()

function addCircle(value) {
    let x = (Math.random() - 2) * 50
    let y = (Math.random() - 2) * 50
    if(Math.random() < 0.5) {
        x = canvas.width - x
    }
    if(Math.random() < 0.5) {
        y = canvas.height - y
    }

const color = `hsl(${Math.random()*360},75%,50%)`

circles.add(new Circle({
    x:x,
    y:y,
    value:value,
    radius:20,
    color:color,
    velocity:{x:(Math.random()+1), y:(Math.random()+1)}
}))
}

for(let i = 0; i < 44; i++) {
    addCircle(i)
}

function animate() {
    c.fillStyle = "#C7CFD6"
    c.fillRect(0, 0, canvas.width, canvas.height)

    for(let circle of circles) {
        circle.update()
        player.checkEat(circle)
    }

    player.update()

    window.requestAnimationFrame(animate)
}

window.requestAnimationFrame(animate)