
long number = 10928198154l; 

int rings = int((number / 100000l)) % 5;
println("Rings:" + rings);

if (number % 10l > (number / 10l) % 10) {
  println("Yes");
} else {
  println("No");
}
