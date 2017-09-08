fun main(args : Array<String>) {

    val traits = setOf<String>("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
    val geneMarkers = setOf<String>("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")

    val lookup = RnaLookupTable(traits, geneMarkers)

    val oneDna = Dna(geneMarkers)
    oneDna.prettyPrint()

    for (year in 1..99){
        println("Traits at year: $year")
        println(lookup.getTraitsForDnaAndYear(oneDna, year))
    }
}
