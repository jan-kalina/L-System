import processing.core.PApplet

class Turtle(var todo: String, private val ruleFunctions: RuleFunctions, var len: Float, var theta: Float) {

    fun render(pApplet: PApplet) {
        pApplet.run {
            stroke(0, 175f)
            todo.forEach { element ->
                ruleFunctions[element]?.invoke(this, this@Turtle)
            }
        }

    }

    fun changeLen(percent: Float) {
        len *= percent
    }
}