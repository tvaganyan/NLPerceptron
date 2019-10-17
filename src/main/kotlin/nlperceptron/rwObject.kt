package nlperceptron

import java.io.*

class rwObject {
    fun Write(fn: String, layer:  MutableList<Perceptron>) {
        val f = FileOutputStream(File(fn))
	    val os = ObjectOutputStream(f)
        os.writeObject(layer)
        os.close();
        f.close();
    }
    fun Read(fn:String):  MutableList<Perceptron> {
        val fi = FileInputStream(File(fn))
        val oi = ObjectInputStream(fi)
        val layer:  MutableList<Perceptron> = oi.readObject() as MutableList<Perceptron>
        oi.close();
        fi.close();
        return layer
    }
}
