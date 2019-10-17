Non linear perceptron


Perceptron has deal with the XOR logic problem.
  
An XOR (exclusive OR gate) is a digital logic gate

that gives a true output only when both its inputs differ from each other.

The truth table for an XOR gate is shown below:

in 0 0 out 0

in 0 1 out 1

in 1 0 out 1

in 1 1 out 0

The root is that the XOR problem is not linearly separable.

The perceptron presented here is non-linear, so this problem does not arise.

I show the results that this non-linear perceptron gives for logical functions after training

AND

in [0.0, 0.0]  out 0.0015368976185416209

in [1.0, 0.0]  out 0.05250071013656802

in [0.0, 1.0]  out 0.05326861123103355

in [1.0, 1.0]  out 0.9336778786074843


OR

in [0.0, 0.0]  out 0.07558225877662605

in [1.0, 0.0]  out 0.9531594381827327

in [0.0, 1.0]  out 0.9543017009622867

in [1.0, 1.0]  out 0.9999429973905278


XOR

in [0.0, 0.0]  out 0.08367405176684817

in [1.0, 0.0]  out 0.9163259482331526

in [0.0, 1.0]  out 0.9163259482331526

in [1.0, 1.0]  out 0.0836740517668466

The project was implemented in Java compatible language Kotlin.
