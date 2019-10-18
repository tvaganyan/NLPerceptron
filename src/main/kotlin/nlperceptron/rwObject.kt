package nlperceptron

import java.io.*

class rwObject {
    fun write(fn: String, layer:  MutableList<Perceptron>) {
        ObjectOutputStream(FileOutputStream(fn)).use {
            it.writeObject(layer)
        }
    }
    fun read(fn:String):  MutableList<Perceptron> {
        return ObjectInputStream(FileInputStream(fn)).use {
            return it.readObject() as  MutableList<Perceptron>
        }
    }
}
