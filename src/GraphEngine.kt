import exercise.BFS
import exercise.BFT
import exercise.Bipartite
import exercise.DFS
import exercise.DFT
import representation.Graph
import representation.map.IGraph
//import representation.matrix.AdjacencyMatrixGraph

class GraphEngine {
    fun main() {
//        val  graph : Graph = AdjacencyMatrixGraph(12);
//        graph.display();
        val dictionaryGraph : DFT = DFT();
        println("-----------------|ADD|--------------------")
        dictionaryGraph.apply {
            this.add(10,20,5)
            this.add(10,50,9)
            this.add(10,70,8)

            this.add(20,90,1)
            this.add(20,10,5)

            this.add(70,10,8)
            this.add(70,90,2)
            this.add(70,20,3)

            this.add(90,20,1)
            this.add(90,70,2)


            this.add(50,10,9)
            this.add(50,70,12)
        }
        dictionaryGraph.display()
        println("-----------------|DELETE|--------------------")
        // Delete
        dictionaryGraph.apply {
//            this.delete(100,200)
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
//            get(10,20)
//            get(90,70)
        }

        println("-----------------|EDGES|--------------------")
        val edgeCount = dictionaryGraph.noOfEdges()
        println("Total edges ${edgeCount}")

        println("-----------------|HAS-PATH|--------------------")
        println("Has path between vertex 50 - 90 : ${dictionaryGraph.hasPath(50,90)}")
        println("Has path between vertex 100 - 90 : ${dictionaryGraph.hasPath(100,90)}")

        println("-----------------|PRINT-ALL-PATH|--------------------")
        dictionaryGraph.printAllPaths(50,90)


        if (dictionaryGraph is BFS){
            println("-----------------|BFS|--------------------")
            val bfsResult = dictionaryGraph.bfs(10,20)
            println("source = 10, destination = 20 :: bfs result = ${bfsResult}")
        }

        if (dictionaryGraph is DFS){
            println("-----------------|DFS|--------------------")
            val dfsResult = dictionaryGraph.dfs(10,20)
            println("source = 10, destination = 20 :: dfs result = ${dfsResult}")
        }

        if (dictionaryGraph is BFT){
            println("-----------------|BFT|--------------------")
            dictionaryGraph.bft()
        }


        if (dictionaryGraph is DFT){
            println("-----------------|DFT|--------------------")
            dictionaryGraph.dft()
        }

        println("-----------------|Get Connected Component|--------------------")
        println(dictionaryGraph.connectedComponent)

        println("---------------------------------------------------------|New Graph|-------------------------------------------------------------")

        val bipartiteGraph : Bipartite = Bipartite();
        bipartiteGraph.apply {
            this.add(1,5,5)
            this.add(1,2,9)


            this.add(2,1,1)
            this.add(2,3,5)

            this.add(3,2,8)
            this.add(3,4,2)


            this.add(4,3,2)
            this.add(4,5,1)

            this.add(5,1,5)
            this.add(5,4,1)
        }
        bipartiteGraph.display()
        if (bipartiteGraph is Bipartite){
            println("-----------------|Is Graph Bipartite|--------------------")
            println(bipartiteGraph.isBipartite)
        }
    }
}