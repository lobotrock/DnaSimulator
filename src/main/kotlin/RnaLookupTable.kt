class RnaLookupTable constructor (val traits: Set<String>, val geneMarkers: Set<String>) {

    val geneLookup: Map<String, Map<Int, Rna>>

    init{
        geneLookup = geneMarkers.associateBy ( {it}, { markerInteration(it, traits) } )
    }

    fun getTraitsForDnaAndYear(dna: Dna, year: Int): Map<String, Int>{
        var individualTraits: MutableMap<String, Int> = traits.associateBy ( {it}, {0} ).toMutableMap()
        geneMarkers.forEach {
            marker ->
            run {
                geneLookup[marker]?.get(dna.getGeneAtMarker(marker))?.getTraits(year)?.forEach {
                    individualTraits.put(it.key, it.value + (individualTraits[it.key]?: 0)) }
            }
        }

        return individualTraits.toMap()
    }


    private fun markerInteration(marker: String, traits: Set<String>): Map<Int, Rna> {
        return 1.until(4).associateBy( {it}, {Rna(marker, it, traits)})
    }
}
