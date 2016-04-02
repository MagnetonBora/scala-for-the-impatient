import scala.collection.JavaConversions.propertiesAsScalaMap

def javaProperties = propertiesAsScalaMap(System.getProperties())
var lengthOfLongestKey = javaProperties.keySet.map(_.length).max
for((k, v) <- javaProperties) {
  printf("%-" + lengthOfLongestKey + "s | %s\n", k, v)
}
