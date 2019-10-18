## Non linear perceptron


- Non linear perceptron example that solves the XOR logic problem (as well as AND and OR). 
- XOR problem is not linearly separable, but since the perceptron presented is non-linear this problem does not arise. 
- Sample results after training: 

AND
- in [0.0, 0.0]  out 0.0015368976185416209
- in [1.0, 0.0]  out 0.05250071013656802
- in [0.0, 1.0]  out 0.05326861123103355
- in [1.0, 1.0]  out 0.9336778786074843

OR
- in [0.0, 0.0]  out 0.07558225877662605
- in [1.0, 0.0]  out 0.9531594381827327
- in [0.0, 1.0]  out 0.9543017009622867
- in [1.0, 1.0]  out 0.9999429973905278

XOR
- in [0.0, 0.0]  out 0.08367405176684817
- in [1.0, 0.0]  out 0.9163259482331526
- in [0.0, 1.0]  out 0.9163259482331526
- in [1.0, 1.0]  out 0.0836740517668466

The project is implemented in Java-compatible language Kotlin.
