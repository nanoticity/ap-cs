public int factorial(int n, int total) {
  if (n==1) {
    return 0;
  }
  
  return total*factorial(n-1, total);
}

