class LSystem     // Construct an LSystem with a starting sentence and a ruleset
    (// The sentence (a String)
    val axiom: String, // The ruleset (an array of Rule objects)
    private val ruleset: List<Rule>
) {
    // Keeping track of the generation #
    private var generation = 0
    private var sentence = axiom

    // Generate the next generation
    fun generate(): String {

        // An empty StringBuffer that we will fill
        val nextgen = StringBuffer()
        // For every character in the sentence
        sentence.forEach { element ->
            // What is the character
            // We will replace it with itself unless it matches one of our rules
            var replace: String? = "" + element
            // Check every rule
            for (j in ruleset.indices) {
                val a: Char = ruleset[j].character
                // if we match the Rule, get the replacement String out of the Rule
                if (a == element) {
                    replace = ruleset[j].transformation
                    break
                }
            }
            // Append replacement String
            nextgen.append(replace)
        }
        // Replace sentence
        // Increment generation
        generation++
        sentence = nextgen.toString()
        return sentence
    }

}