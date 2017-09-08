import java.util.Random;

class Dna constructor(val geneMarkers: Set<String>,
                      val geneMap: Map<String, GenePair> = geneMarkers.associateBy({ it },
                              {GenePair(Random().nextInt(3) + 1, Random().nextInt(3) + 1)})){

    fun mate(mate: Dna): Dna{
        if(mate.geneMap.size != this.geneMap.size){
            //incompatible mates
        }

        return Dna(geneMarkers, geneMap.map{
            //If for some reason null is the value for the mate's gene, it will get two random pairs from it
            it.key to GenePair (it.value.getRandomGene(), mate.geneMap.getOrDefault(it.key, it.value).getRandomGene())}
                .toMap()
                .toMutableMap())
    }

    fun prettyPrint(){
        for(gene in geneMap){
            println("\t [${gene.key}] : (${gene.value.geneA}, ${gene.value.geneB})")
        }
    }

    fun getGeneAtMarker(marker: String): Int{
        return geneMap.getOrDefault(marker,
                GenePair(Random().nextInt(3) + 1, Random().nextInt(3) + 1))
                .getExpressedGene()
    }
}