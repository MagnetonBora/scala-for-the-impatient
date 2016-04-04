
class UnitConversion(val factor: Double){
  def convert(value: Double) = {
    value * factor
  }
}
