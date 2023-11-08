import representation.Graph
import representation.map.IGraph
import representation.matrix.AdjacencyMatrixGraph

class GraphEngine {
    fun main() {
//        val  graph : Graph = AdjacencyMatrixGraph(12);
//        graph.display();
        val dictionaryGraph : Graph = IGraph();
        println("-----------------|ADD|--------------------")
        dictionaryGraph.apply {
            this.add(10,20,5)
            this.add(10,50,9)
            this.add(10,70,8)

            this.add(20,90,1)
            this.add(20,10,5)

            this.add(70,10,8)
            this.add(70,90,2)

            this.add(90,20,1)
            this.add(90,70,2)


            this.add(50,10,9)
        }
        dictionaryGraph.display()
        println("-----------------|DELETE|--------------------")
        // Delete
        dictionaryGraph.apply {
            this.delete(100,200)
            this.delete(70,90)
        }
        dictionaryGraph.display()
        println("-----------------|SET|--------------------")
        dictionaryGraph.apply {
            set(10,20,1000)
            set(70,10,5000)
        }
        dictionaryGraph.display()

        println("-----------------|GET|--------------------")
        dictionaryGraph.apply {
            get(10,20)
            get(90,70)
        }

    }
}