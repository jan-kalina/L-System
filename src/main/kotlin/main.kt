import processing.core.PApplet

fun main() {
    val ruleset: List<Rule> = listOf(
        Rule('F', "F[+G][-T]F[F-F]"),
        Rule('G', "F"),
        Rule('T', "--F")
    )
    val lSystem = LSystem("F", ruleset)
    val turtle = Turtle(lSystem.axiom, 75f, PApplet.radians(25f))

    PApplet.runSketch(arrayOf("LSystemPApplet"), LSystemPApplet(lSystem, turtle))
}