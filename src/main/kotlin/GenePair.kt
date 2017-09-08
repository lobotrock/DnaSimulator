import java.util.Random;

class GenePair(val geneA: Int, val geneB: Int){
    fun getExpressedGene(): Int{
        if (geneA > geneB) return geneA else return geneB
    }

    fun getRandomGene(): Int{
        if (Random().nextBoolean()) return geneA else return geneB
    }
}