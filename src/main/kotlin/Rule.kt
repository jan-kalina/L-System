import processing.core.PApplet

class Rule(val character: Char, val transformation: String)

class RuleFunctions(map: Map<Char, (pApplet: PApplet, turtle: Turtle) -> Unit>): HashMap<Char, (pApplet: PApplet, turtle: Turtle) -> Unit>(map)