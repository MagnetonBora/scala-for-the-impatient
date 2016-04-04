def pow(x: Int, n: Int): Double = {
  if (n == 0) {
    1
  } else {
    if (n > 0) {
      if (n % 2 == 0 && n > 2) {
        pow(pow(x, (n / 2)).toInt, 2)
      } else {
        x * pow(x, n - 1).toInt
      }
    } else {
      1 / pow(x, -n)
    }
  }
}

printf("2^2=%f\n", pow(2, 2));
printf("10^9=%f\n", pow(10, 9));
printf("3^3=%f\n", pow(3, 3));
printf("2^-1=%f\n", pow(2, -1));
printf("5^0=%f\n", pow(5, 0));