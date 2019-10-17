package nlperceptron

import kotlin.test.Test

class QaTests {
    private val andOutput = listOf(0.0, 0.0, 0.0, 1.0)
    private val orOutput = listOf(0.0, 1.0, 1.0, 1.0)
    private val xorOutput = listOf(0.0, 1.0, 1.0, 0.0)

    @Test
    fun andLearn() {
        val n = Network()
        n.output = andOutput
        n.learn()
        n.test()
        n.save("out/and.nn")
    }

    @Test
    fun andLoad() {
        val n = Network()
        n.load("out/and.nn")
        n.test()
    }

    @Test
    fun orLearn() {
        val n = Network()
        n.output = orOutput
        n.learn()
        n.test()
        n.save("out/or.nn")
    }

    @Test
    fun orLoad() {
        val n = Network()
        n.load("out/or.nn")
        n.test()
    }

    @Test
    fun xorLearn() {
        val n = Network()
        n.output = xorOutput
        n.learn()
        n.test()
        n.save("out/xor.nn")
    }

    @Test
    fun xorLoad() {
        val n = Network()
        n.load("out/xor.nn")
        n.test()
    }

}