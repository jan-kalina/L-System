import processing.core.PApplet

class LSystemPApplet(
    private val lSystem: LSystem,
    private val turtle: Turtle
): PApplet() {

    private var counter = 0

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
        translate((width / 2).toFloat(), height.toFloat())
        rotate(-PI / 2)
        turtle.render(this)
        noLoop()
    }

    override fun mousePressed() {
        if (counter < 10) {
            pushMatrix()
            val newSentence = lSystem.generate()
            turtle.todo = newSentence
            turtle.changeLen(0.5f)
            popMatrix()
            redraw()
            counter++
        }
    }
}