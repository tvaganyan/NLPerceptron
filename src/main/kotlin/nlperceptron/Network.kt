package nlperceptron

import kotlin.math.pow

class Network() {
     private val iDim: Int = 2
     private val epsilon = 0.01
     private val n = 10000
     private var layer: MutableList<Perceptron> = MutableList(1) { Perceptron(iDim, epsilon) }
     private val input = listOf(listOf(0.0, 0.0), listOf(1.0, 0.0), listOf(0.0, 1.0), listOf(1.0, 1.0))
     var output = listOf(0.0, 0.0, 0.0, 1.0)
     private val rwLayer = rwObject()

     private fun err(p:Perceptron): Double {
          var r = 0.0
          for (i in input.indices) {
               r += (p.result(input[i]) - output[i]).pow(2)
          }
          return r
     }

     private fun gradY(p:Perceptron): Double {
          var r = 0.0
          for (j in input.indices) {
               r += p.resulty(input[j]) * (p.result(input[j]) - output[j])
          }
          return r
     }

     private fun gradC(p:Perceptron): List<Double> {
          val res = mutableListOf<Double>()
          for(i in 0 until iDim){
               var r = 0.0
               for (j in 0 until input.size) {
                    r += p.result(i,input[j]) * (p.result(input[j]) - output[j])
               }
               res.add(r)
          }
          return res
     }

     private fun gradA(p:Perceptron): List<List<Double>>{
          val res = mutableListOf<MutableList<Double>>()
          for(i in 0 until iDim){
               res.add(mutableListOf())
               for(j in 0 until iDim) {
                    var r = 0.0
                    for (k in input.indices) {
                         r += p.result(i,j,input[k]) * (p.result(input[k]) - output[k])
                    }
                    res[i].add(r)
               }
          }
          return res
     }

     fun learn() {
          var i = 0
          var e = err(layer[0])
          while (e >= epsilon && i < n) {
               layer[0].newA(gradA(layer[0]))
               layer[0].newC(gradC(layer[0]))
               layer[0].newY(gradY(layer[0]))
               e = err(layer[0])
               i++
          }
          println("Error: $e")
     }

     fun test(){
          input.forEach { println("in $it  out " + layer[0].result(it)) }
     }

     fun save(fn:String){
          rwLayer.write(fn, layer)
     }
     fun load(fn:String){
          layer = rwLayer.read(fn)
     }
}
