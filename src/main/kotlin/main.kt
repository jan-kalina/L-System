import processing.core.PApplet

fun main() {
    val ruleset: List<Rule> = listOf(
        Rule('F', "F[+G][-T]F[F-F]"),
        Rule('G', "F"),
        Rule('+', "+"),
        Rule('-', "-"),
        Rule('[', "["),
        Rule(']', "]")
    )

    val ruleFunctions = RuleFunctions(
        mapOf(
            'F' to { applet, turtle ->
                run {
                    applet.line(0f, 0f, turtle.len, 0f)
                    applet.translate(turtle.len, 0f)
                }
            },
            'G' to { applet, turtle ->
                run {
                    applet.line(0f, 0f, turtle.len, 0f)
                    applet.translate(turtle.len, 0f)
                }
            },
            '+' to { applet, turtle ->
                run {
                    applet.rotate(turtle.theta)
                }
            },
            '-' to { applet, turtle ->
                run {
                    applet.rotate(turtle.theta)
                }
            },
            '[' to { applet, _ ->
                run {
                    applet.pushMatrix()
                }
            },
            ']' to { applet, _ ->
                run {
                    applet.popMatrix()
                }
            }
        )
    )
    val lSystem = LSystem("F", ruleset)
    val turtle = Turtle(lSystem.axiom, ruleFunctions, 75f, PApplet.radians(25f))

    PApplet.runSketch(arrayOf("LSystemPApplet"), LSystemPApplet(lSystem, turtle))
}