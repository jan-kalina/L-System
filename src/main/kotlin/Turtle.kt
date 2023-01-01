import processing.core.PApplet

class Turtle(var todo: String, var len: Float, var theta: Float) {

    fun render(pApplet: PApplet) {
        pApplet.run {
            stroke(0, 175f)
            todo.forEach { element ->
                when (element) {
                    'F', 'G' -> {
                        line(0f, 0f, len, 0f)
                        translate(len, 0f)
                    }
                    '+' -> {
                        rotate(theta)
                    }
                    '-' -> {
                        rotate(-theta)
                    }
                    '[' -> {
                        pushMatrix()
                    }
                    ']' -> {
                        popMatrix()
                    }
                }
            }
        }
       
    }

    fun changeLen(percent: Float) {
        len *= percent
    }
}