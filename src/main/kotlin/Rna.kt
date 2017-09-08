import java.util.Random;

class Rna(val geneId : String, val geneValue: Int, val traits: Set<String>){

    private val RANDOM = Random()
    val yearToTraits: Map<Int, Map<String, Int>>

    init {
        var currentYear =  generateNextYear()

        this.yearToTraits = 1.until(100).associateBy( {it}, valueTransform =  {
            currentYear = generateNextYear(currentYear)
            currentYear
        })
    }

    /**
     * Generating the traits for next year.
     *
     * Traits are in the format String
     * Values are Int
     */
    private fun generateNextYear(previousYear: Map<String, Int> = traits.associateBy( {it}, {0})): Map<String, Int>{
        return previousYear.mapValues( {it.value + randomDistribution()} )
    }

    private fun randomDistribution(): Int {
        when(RANDOM.nextInt(1000)){
            in 0..700 -> return 0
            in 701..900 -> return 1 * if(RANDOM.nextBoolean()) 1 else -1
            in 901..940 -> return 2 * if(RANDOM.nextBoolean()) 1 else -1
            in 941..960 -> return 3 * if(RANDOM.nextBoolean()) 1 else -1
            in 961..970 -> return 4 * if(RANDOM.nextBoolean()) 1 else -1
            in 971..979 -> return 5 * if(RANDOM.nextBoolean()) 1 else -1
            in 980..987 -> return 6 * if(RANDOM.nextBoolean()) 1 else -1
            in 988..993 -> return 7 * if(RANDOM.nextBoolean()) 1 else -1
            in 994..997 -> return 8 * if(RANDOM.nextBoolean()) 1 else -1
            in 998..999 -> return 9 * if(RANDOM.nextBoolean()) 1 else -1
            1000 -> return 10 * if(RANDOM.nextBoolean()) 1 else -1
        }
        return 1
    }


    public fun getTraits(year: Int): Map<String, Int> {
        return this.yearToTraits[year] ?: this.traits.associateBy({it}, {0})
    }
}