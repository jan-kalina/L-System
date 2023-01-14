import processing.core.PApplet
import processing.event.KeyEvent
import processing.event.MouseEvent

class LSystemPApplet(
    private val lSystem: LSystem,
    private val turtle: Turtle
) : PApplet() {

    private var counter = 0
    private var translateX = 0.0f
    private var translateY = 0.0f
    val inc: Byte = 10
    /**
    Alphabet
    - 'F' or 'G': draw line
    - '[': save state
    - ']': restore state
    - '+': turn right by theta
    - '-': turn left by theta
     */
    override fun settings() {
        size(800, 600)
    }


    override fun draw() {
        background(255)
        fill(0)
        translate(translateX,translateY)
        rotate(-PI / 2)
        turtle.render(this)

        noLoop()
    }

    override fun keyPressed(event: KeyEvent) {
        if (counter < 20 && event.keyCode == 32) {
                pushMatrix()
                val newSentence = lSystem.generate()
                turtle.todo = newSentence
                turtle.changeLen(0.5f)
                popMatrix()
                counter++
            }

        redraw()
    }

    override fun mouseWheel(event: MouseEvent) {
        turtle.len -= event.count*inc;
        redraw()

    }

    override fun mouseDragged(e: MouseEvent?) {
        translateX += (mouseX - pmouseX).toFloat()
        translateY += (mouseY - pmouseY).toFloat()
        redraw()
    }
}