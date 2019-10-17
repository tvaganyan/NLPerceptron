
// - - - - - - Copyright (C) 2019  T. Vaganyan - - - - - -

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

package nlperceptron

import java.io.*
import kotlin.math.exp
import kotlin.math.pow
import kotlin.random.Random.Default.nextDouble as random

open class Perceptron(val iDim: Int, val epsilon: Double = 0.01) : Serializable{
    val sigma = { x: Double -> 1 / (1 + exp(-x)) }
    val dSigma = { x: Double -> exp(-x) / (1 + exp(-x)).pow(2) }
    private val a = MutableList(iDim) { MutableList(iDim) { 0.0 }}
    private val c = MutableList(iDim) { (random()*2-1)/iDim }
    private var y = random()*2-1
    private val ma = MutableList(iDim) { MutableList(iDim) { 0.0 }}
    private val mc = MutableList(iDim) { 0.0 }
    private val moment = 0.5

    init {
        for (i in 0 until iDim) {
            a[i][i] = (random()*2-1)/iDim
        }
    }

    private fun q(x: List<Double>): Double  {
        var r = y
        for (i in 0 until iDim) {
            for (j in 0 until iDim) {
                r += a[i][j] * (x[i] - c[i]) * (x[j] - c[j])
            }
        }
        return r
    }

    private fun qc(k:Int,x: List<Double>): Double  {
        var r = 0.0
        for (j in 0 until iDim) {
            r -= 2 * a[k][j] * (x[j] - c[j])
        }
        return r
    }

    private fun qa(k:Int, m:Int, x: List<Double>): Double  {
        return (x[k] - c[k]) * (x[m] - c[m])
    }

    fun result(input: List<Double>): Double = sigma(q(input))
    fun result(i:Int, input: List<Double>): Double = qc(i,input) * dSigma(q(input))
    fun result(i:Int, j:Int, input: List<Double>): Double = qa(i,j,input) * dSigma(q(input))
    fun resulty(input: List<Double>):Double = dSigma(q(input))

    fun newC(dc:List<Double>) {
        for (i in 0 until iDim) {
            mc[i] = dc[i] * epsilon + moment * mc[i]
            c[i] -= mc[i]
        }
    }

    fun newA(da:List<List<Double>>){
        for (i in 0 until iDim) {
            for (j in 0 until iDim) {
                ma[i][j] = da[i][j] * epsilon + moment * ma[i][j]
                a[i][j] -= ma[i][j]
            }
        }
    }

    fun newY(dy:Double){
        y -= dy
    }
}